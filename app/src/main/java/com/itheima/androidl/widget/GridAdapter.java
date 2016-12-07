package com.itheima.androidl.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.androidl.R;



public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ListHolder>{

    int icons[] = {R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4,R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g9,
            R.drawable.g10,R.drawable.g11,R.drawable.g12,R.drawable.g13,R.drawable.g14,R.drawable.g15,R.drawable.g16,R.drawable.g17,R.drawable.g18,R.drawable.g19,
            R.drawable.g20,R.drawable.g21,R.drawable.g22,R.drawable.g23,R.drawable.g24,R.drawable.g25,R.drawable.g26,R.drawable.g27,R.drawable.g28,R.drawable.g29,};

    String names[] = {"浏览器","输入法","健康","效率","教育","理财","阅读","个性化","购物","资讯","生活","工具","出行","通讯","拍照","社交","影音","安全","休闲","棋牌","益智","射击","体育","儿童","网游","角色","策略","经营","竞速"};
    Context context;
    boolean flag;
    public GridAdapter(Context context, boolean flag){
        this.context = context;
        this.flag = flag;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);

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
            icon.setImageDrawable(context.getResources().getDrawable(icons[position % icons.length]));
            name.setText(names[position % names.length]);
        }
    }
}
