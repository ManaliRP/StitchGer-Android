package com.example.admin1.stitchger_android;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin1.stitchger_android.adapter.HomeRecyclerAdapter;
import com.example.admin1.stitchger_android.model.HomeItem;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeRecyclerAdapter adapter;
    List<HomeItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.home_recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list = new ArrayList<>();
        adapter = new HomeRecyclerAdapter(this, list, new HomeRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeItem item) {
                //Toast.makeText(Home.this, "Item Clicked = "+item.getName(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(Home.this, OrderDetails.class);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);

        //dummy
        HomeItem item = new HomeItem("Manali", "Panjabi", "12-12-12");
        list.add(item);
        HomeItem item1 = new HomeItem("Sonali", "One Piece", "09-12-12");
        list.add(item1);
        HomeItem item2 = new HomeItem("Sayali", "Skirt", "11-12-18");
        list.add(item2);
        adapter.notifyDataSetChanged();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.home_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                final Dialog dialog = new Dialog(Home.this);
                dialog.setContentView(R.layout.home_dialog_layout);
                dialog.setTitle("Choose customer type");
                TextView tv1, tv2;
                tv1 = (TextView) dialog.findViewById(R.id.home_dialog_new_customer);
                tv2 = (TextView) dialog.findViewById(R.id.home_dialog_existing_customer);
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Home.this, NewCustomer.class);
                        startActivity(i);
                    }
                });
                dialog.show();
            }
        });
    }

}
