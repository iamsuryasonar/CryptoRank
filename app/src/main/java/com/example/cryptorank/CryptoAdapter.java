package com.example.cryptorank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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

        holder.symbol.setText(model.getSymbol());
        holder.name.setText(model.getName());
        holder.price.setText(String.valueOf(model.getPriceUsd()));
        holder.changepercent.setText(String.valueOf(model.getChangePercent24Hr()));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView  symbol, name, price, changepercent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            symbol = itemView.findViewById(R.id.symbol);
            name = itemView.findViewById(R.id.name);
            price =  itemView.findViewById(R.id.price);
            changepercent = itemView.findViewById(R.id.change_percent);

        }
    }

}
