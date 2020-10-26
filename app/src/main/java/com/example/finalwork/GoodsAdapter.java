package com.example.finalwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GoodsAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private Context context;
    private List<Goods> datas;
    public GoodsAdapter(Context context, List<Goods> datas){
        this.context = context;
        this.datas = datas;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        Goods good = (Goods) getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_item, parent, false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.tvTitle.setText(good.getTitle());
        holder.tvPrice.setText(good.getPrice());
        holder.ivPic.setBackgroundResource(good.getIcon());
        return convertView;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvPrice;
        ImageView ivPic;

        public ViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvPrice = (TextView) view.findViewById(R.id.tv_price);
            ivPic = (ImageView) view.findViewById(R.id.iv_pic);
        }
    }


}