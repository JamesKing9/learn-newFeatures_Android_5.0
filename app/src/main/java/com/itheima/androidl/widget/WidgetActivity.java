package com.itheima.androidl.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.itheima.androidl.R;


public class WidgetActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener, MenuItem.OnMenuItemClickListener {

    public static final int NONE = 0;
    public static final int LIST_V = 1;
    public static final int LIST_H = 2;
    public static final int GRID_V = 3;
    public static final int GRID_H = 4;
    public static final int STAGGERED_GRID_V = 5;
    public static final int STAGGERED_GRID_H = 6;

    int mOrientation;
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOrientation = getIntent().getIntExtra("orientation", NONE);
        setContentView(R.layout.widget_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refreshLayout.setProgressBackgroundColor(R.color.refresh_bg);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user);
        Bitmap b =createRoundConerImage(bitmap);
        toolbar.setNavigationIcon(new BitmapDrawable(b));
        //toolbar.setLogo(R.drawable.ic_launcher);
        setActionBar(toolbar);

        switch (mOrientation) {
            case LIST_V:
                initListView(true);
                break;
            case LIST_H:
                initListView(false);
                break;
            case GRID_V:
                initGridView(true);
                break;
            case GRID_H:
                initGridView(false);
                break;
            case STAGGERED_GRID_V:
                initStaggeredGridView(true);
                break;
            case STAGGERED_GRID_H:
                initStaggeredGridView(false);
                break;
        }
    }


    private View initListView(boolean isVer) {
        toolbar.setSubtitle(isVer ?"LinearLayoutManager Vertical":"LinearLayoutManager Horizontal");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(isVer ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ListAdapter(this,isVer));

       // recyclerView.setHasFixedSize(true);
        recyclerView.setBackgroundColor(Color.WHITE);
        return recyclerView;
    }

    private View initGridView(boolean isVer) {
        toolbar.setSubtitle(isVer ?"GridLayoutManager Vertical":"GridLayoutManager Horizontal");
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setOrientation(isVer ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new GridAdapter(this,isVer));
        return recyclerView;
    }

    private View initStaggeredGridView(boolean isVer) {
        toolbar.setSubtitle(isVer ?"StaggeredGridLayoutManager Vertical":"StaggeredGridLayoutManager Horizontal");
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,isVer ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new StaggeredGridAdapter(this,isVer));
        return recyclerView;
    }

    @Override
    public void onRefresh() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        },3000);
    }

    private String[] menuTitles;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuTitles == null) {
            menuTitles = getResources().getStringArray(R.array.style_names);
        }

        for (String name : menuTitles){
            MenuItem menuItem = menu.add(name);
            menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
            menuItem.setOnMenuItemClickListener(this);
        }

        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        for (int i = 0; i < menuTitles.length; i++) {

            if (item.getTitle().equals(menuTitles[i])) {
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
    private Bitmap createRoundConerImage(Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);

        int size = Math.min(source.getWidth(),source.getHeight());

        Bitmap target = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        RectF rect = new RectF(0, 0, size, size);
        canvas.drawRoundRect(rect, size /2, size/2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }

}
