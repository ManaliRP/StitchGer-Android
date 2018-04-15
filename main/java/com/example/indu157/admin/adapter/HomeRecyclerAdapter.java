package com.example.admin1.stitchger_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin1.stitchger_android.R;
import com.example.admin1.stitchger_android.model.HomeItem;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeItemHolder>{

    private Context context;
    private List<HomeItem> list;

    public interface OnItemClickListener {
        void onItemClick(HomeItem item);
    }
    private OnItemClickListener listener;

    public class HomeItemHolder extends RecyclerView.ViewHolder{
        public TextView name, style, date;
        public LinearLayout linearLayout;
        public HomeItemHolder(View view){
            super(view);
            name = view.findViewById(R.id.home_item_name);
            style = view.findViewById(R.id.home_item_style);
            date = view.findViewById(R.id.home_item_date);
            linearLayout = view.findViewById(R.id.home_item_ll);
        }
        public void bind(final HomeItem card, final OnItemClickListener listener){
            name.setText(card.getName());
            style.setText(card.getStyle());
            date.setText(card.getDate());
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(card);
                }
            });
        }
    }

    public HomeRecyclerAdapter(Context con, List<HomeItem> list, OnItemClickListener listener){
        context = con;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public HomeItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_screen_item, parent, false);

        return new HomeItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeItemHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void clearData(){
        list.clear();
    }
}
