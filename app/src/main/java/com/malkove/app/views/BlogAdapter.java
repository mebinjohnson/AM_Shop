package com.malkove.app.views;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.malkove.app.models.Blog;
import com.malkove.app.models.Media;
import com.malkove.app.network.AppDelegate;

import java.util.List;

import io.paperdb.Paper;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Slf4j
public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    private Context context;
    private List<Blog> blogList;

    public BlogAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_list_item, parent, false);
        return new BlogViewHolder(layoutView);
    }

    private boolean setBlogImage(Blog b, ImageView imageView) {
        if (b.getFeatured_media() == 0) return false;
        AppDelegate.getInstance().get().getMediaInfo(b.getFeatured_media()).enqueue(new Callback<Media>() {
            @Override
            public void onResponse(Call<Media> call, Response<Media> response) {
                try {
                    if (response.body() != null)
                        Glide.with(getContext())
                                .load(response.body().getSourceUrl())
                                .into(imageView);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Media> call, Throwable t) {
                t.printStackTrace();
            }
        });


        return true;
    }


    @Override
    public void onBindViewHolder(BlogViewHolder holder, int position) {
        Blog blog = blogList.get(position);
        if (blog == null) {
            return;// TODO: 12/5/18 handle this
        }
        if (!setBlogImage(blog, holder.imageView)) {
            holder.imageView.setVisibility(View.GONE);
            // TODO: 12/5/18 replace this with error image
        }
        if (blog.getExcerpt() != null)
            holder.desc.setText(Html.fromHtml(blog.getExcerpt().getRendered()));
        holder.textView.setText(Html.fromHtml(blog.getTitle().getRendered()));

        holder.itemView.setOnClickListener(v -> {
//            Log.d("position", Integer.toString(getAdapterPosition()));
            Paper.book().write("currentBlog", blog);
            Intent intent = new Intent(BlogAdapter.this.getContext(), BlogItemView.class);
            intent.putExtra("blog", blog.getId());
            BlogAdapter.this.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        TextView desc;
        View view;

        public BlogViewHolder(View v) {
            super(v);
            view = v;
            v.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.blog_image);
            textView = itemView.findViewById(R.id.blog_title);
            desc = itemView.findViewById(R.id.blog_desc);

        }

        @Override
        public void onClick(View view) {


        }
    }


}
