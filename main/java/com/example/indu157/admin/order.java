package com.example.indu157.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class order extends AppCompatActivity {

    EditText deliverydate,price;
    Spinner stylespinner;
    String[] style={"Pala","Printed","Cotton","etc","etc1"};
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        order=(Button)findViewById(R.id.btnorder);
        stylespinner = (Spinner)findViewById(R.id.stylespinner);
        stylespinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        deliverydate=(EditText)findViewById(R.id.etdate);
        price = (EditText)findViewById(R.id.etprice);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,style);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        stylespinner.setAdapter(aa);


    }
}
