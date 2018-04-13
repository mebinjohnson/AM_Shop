package com.example.am.am_shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogView> {
    private Context context;

    int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};
    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};

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

    class BlogView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public BlogView(View itemView) {
            super(itemView);

            imageView = (ImageView
                    ) itemView.findViewById(R.id.blog_image);
            textView = (TextView) itemView.findViewById(R.id.blog_title);

        }
    }
}