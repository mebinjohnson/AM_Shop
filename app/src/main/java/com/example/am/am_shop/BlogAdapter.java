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

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogView> {
    private Context context;

    int[] imgList = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4,
            R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8,
            R.drawable.b9, R.drawable.b10};
    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};

    public Context getContext() {
        return context;
    }

    public BlogAdapter(Context context) {
        this.context = context;
    }


    @Override
    public BlogView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_list_item, parent, false);
        BlogView blogView = new BlogView(layoutView);
        return blogView;
    }

    @Override
    public void onBindViewHolder(BlogView holder, int position) {
        holder.imageView.setImageResource(imgList[position]);
        holder.textView.setText(nameList[position]);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    class BlogView extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        View view;

        public BlogView(View v) {
            super(v);
            view = v;
            v.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.blog_image);
            textView = itemView.findViewById(R.id.blog_title);

        }

        @Override
        public void onClick(View view) {

            Log.d("position", Integer.toString(getAdapterPosition()));
            BlogAdapter.this.getContext().startActivity(new Intent(BlogAdapter.this.getContext(), BlogItemView.class));

        }
    }


}
