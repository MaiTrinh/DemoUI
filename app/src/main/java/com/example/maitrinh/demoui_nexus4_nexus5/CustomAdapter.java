package com.example.maitrinh.demoui_nexus4_nexus5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maitrinh.demoui_nexus4_nexus5.models.Datum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mai Trinh on 7/8/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    public Context context;
    public List<Datum> serviceList = new ArrayList<>();
    public LayoutInflater layoutInflater;

    public CustomAdapter (Context context, List<Datum> serviceList){
        this.context = context;
        this.serviceList = serviceList;
        this.layoutInflater = LayoutInflater.from(context);
        Log.d("adapter","check list size : " + serviceList.size());
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.custom_recycle_row, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if((position % 2) != 0 ){
            holder.layoutRow.setBackgroundColor(context.getResources().getColor(R.color.recycleview_row));
            holder.tvName.setText(serviceList.get(position).getName());
            holder.tvPrice.setText((serviceList.get(position).getPrice1()));
        }else{
            holder.layoutRow.setBackgroundColor(context.getResources().getColor(R.color.white));
            holder.tvName.setText(serviceList.get(position).getName());
            holder.tvPrice.setText((serviceList.get(position).getPrice1()));
        }


    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvPrice;
        private LinearLayout layoutRow;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrices);
            layoutRow = (LinearLayout) itemView.findViewById(R.id.layoutRow);
        }
    }
}
