package com.itheima.androidl.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.androidl.R;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    int icons[] = {R.drawable.vector_icon_cloud, R.drawable.vector_icon_movie, R.drawable.vector_icon_laptop, R.drawable.vector_icon_loop, R.drawable.vector_icon_menu, R.drawable.vector_icon_mood, R.drawable.vector_icon_palette, R.drawable.vector_icon_search, R.drawable.vector_icon_time, R.drawable.vector_icon_work};
    String names[] = {"Cloud", "Movie", "Laptop", "Loop", "Menu", "Mood", "Palette", "Search", "Time", "Work"};
    Context context;
    boolean flag;

    public ListAdapter(Context context, boolean flag) {
        this.context = context;
        this.flag = flag;
    }




    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(flag ? R.layout.list_item : R.layout.list_item_h, parent, false);
        return new ListHolder(view);
    }
    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 1000;
   }


    class ListHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView subName;

        public ListHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            name = (TextView) itemView.findViewById(R.id.name);
            subName = (TextView) itemView.findViewById(R.id.subname);
        }

        public void setData(int position) {
            icon.setImageDrawable(context.getResources().getDrawable(icons[position % 10]));
            name.setText(names[position % 10]);
            subName.setText("This is position " + position);
        }


    }
}
