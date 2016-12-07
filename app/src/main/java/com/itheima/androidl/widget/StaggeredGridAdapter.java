package com.itheima.androidl.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.androidl.R;



public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ListHolder>{

    Context context;
    boolean flag;
    int iconsV[] = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p9,
            R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,
            R.drawable.p20,R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,
            R.drawable.p30,R.drawable.p31,R.drawable.p32,R.drawable.p33,R.drawable.p34,R.drawable.p35,R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,
            R.drawable.p40,R.drawable.p41,R.drawable.p42,R.drawable.p43,R.drawable.p44};

    int iconsH[] = {R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7,R.drawable.h9,
            R.drawable.h10,R.drawable.h11,R.drawable.h12,R.drawable.h13,R.drawable.h14,R.drawable.h15,R.drawable.h16,R.drawable.h17,R.drawable.h18,R.drawable.h19,
            R.drawable.h20,R.drawable.h21,R.drawable.h22,R.drawable.h23,R.drawable.h24,R.drawable.h25,R.drawable.h26,R.drawable.h27,R.drawable.h28,R.drawable.h29,
            R.drawable.h30,R.drawable.h31,R.drawable.h32,R.drawable.h33,R.drawable.h34,R.drawable.h35,R.drawable.h36,R.drawable.h37,R.drawable.h38,R.drawable.h39,
            R.drawable.h40,R.drawable.h41,R.drawable.h42,R.drawable.h43,R.drawable.h44};
    public StaggeredGridAdapter(Context context, boolean flag){
        this.context = context;
        this.flag = flag;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(flag ? R.layout.staggered_grid_item : R.layout.staggered_grid_item_h, parent, false);
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

        public ListHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
        }

        public void setData(int position){
            if (flag) {
                icon.setImageResource(iconsV[position % iconsV.length]);
            } else {
                icon.setImageResource(iconsH[position % iconsH.length]);
            }
            name.setText("This is position "+ position);
        }


    }
}
