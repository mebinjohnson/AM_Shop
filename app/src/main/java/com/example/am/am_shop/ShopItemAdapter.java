package com.example.am.am_shop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ShopItemView> {
    private Context context;

    int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};
    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};

    public Context getContext() {
        return context;
    }

    public ShopItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ShopItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item, parent, false);
        ShopItemView shopitemView = new ShopItemView(layoutView);
        return shopitemView;
    }

    @Override
    public void onBindViewHolder(ShopItemView holder, int position) {
        holder.imageView.setImageResource(imgList[position]);
        holder.textView.setText(nameList[position]);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    class ShopItemView extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView imageView;
        TextView textView;
        View view;

        private ShopItemView(View v) {
            super(v);
            view=v;
            v.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_name);

        }
        @Override
        public void onClick(View view) {

            Log.d("position", Integer.toString(getAdapterPosition()));
            ShopItemAdapter.this.getContext().startActivity(new Intent(ShopItemAdapter.this.getContext(), ShopItemActivity.class));

        }
    }
}