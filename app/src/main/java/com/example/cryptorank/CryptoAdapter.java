package com.example.cryptorank;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.ViewHolder>{
    private Context context;
    private List<model> list;

    public CryptoAdapter(Context context, List<model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.single_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        model model = list.get(position);

        int drawableid = context.getResources().getIdentifier(model.getSymbol().toLowerCase(),"drawable",context.getPackageName());
        if(drawableid!=0){
            holder.icon.setImageResource(drawableid);
        }else{
            holder.icon.setImageResource(R.drawable.defaulticon);
        }

        holder.name.setText(model.getName());

        holder.price.setText("$"+String.valueOf(model.getPriceUsd()));

        if(Float.parseFloat(model.getChangePercent24Hr()) < 0){
            holder.changepercent.setTextColor(Color.RED);
        }else{
            holder.changepercent.setTextColor(Color.GREEN);
        }
        holder.changepercent.setText(String.valueOf(model.getChangePercent24Hr()));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView  symbol, name, price, changepercent;
        public ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.cryptoIcon);
            name = itemView.findViewById(R.id.name);
            price =  itemView.findViewById(R.id.price);
            changepercent = itemView.findViewById(R.id.change_percent);

        }
    }

}
