package com.malkove.app.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.malkove.app.models.Blog;
import com.malkove.app.models.Media;
import com.malkove.app.network.AppDelegate;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BlogItemView extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_item_view);
        int blogId = getIntent().getIntExtra("blog", 0);
        updateView(blogId);
        Toast.makeText(this, "blog id " + blogId, Toast.LENGTH_SHORT).show();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //To make the status bar light themed with dark icons
        getWindow().setStatusBarColor(Color.parseColor("#eeeeee")); //TODO: Add the status bar color here instead of WHITE

        Toolbar toolbar = (Toolbar) findViewById(R.id.blog_toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blog_menu, menu);
        return true;
    }

    private boolean setBlogImage(Blog b, ImageView imageView) {
        if (b.getFeatured_media() == 0) return false;
        AppDelegate.getInstance().get().getMediaInfo(b.getFeatured_media()).enqueue(new Callback<Media>() {
            @Override
            public void onResponse(Call<Media> call, Response<Media> response) {
                try {
                    if (response.body() != null)
                        Glide.with(getBaseContext())
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

    private void updateView(int id) {
        Blog currentBlog = Paper.book().read("currentBlog");
        ((TextView) findViewById(R.id.title)).setText(currentBlog.getTitle().getRendered());
        ((TextView) findViewById(R.id.desc)).setText(Html.fromHtml(currentBlog.getContent().getRendered()));
        setBlogImage(currentBlog, findViewById(R.id.image1));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_pinned_blogs) {
            startActivity(new Intent(this, PinnedBlogs.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
