package com.sneha.viewpagerpagetransformaredemos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerRecyclerAdapter extends RecycledPagerAdapter<ViewPagerRecyclerAdapter.FooViewHolder> {

    Context mContext;
    LayoutInflater mLayoutInflater;

    private List<PageModel> arr;
    private LayoutInflater layoutInflater;

    public ViewPagerRecyclerAdapter(Context context, ArrayList<PageModel> arr) {
        mContext = context;
        this.arr = arr;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FooViewHolder onCreateViewHolder(ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        // Inflate view
        View v = layoutInflater.inflate(R.layout.view_pager_item, parent, false);
        // Return view holder
        return new FooViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FooViewHolder viewHolder, final int position) {
        // Show foo inside viewHolder

        PageModel modelObject=arr.get(position);

        viewHolder.img.setImageResource(modelObject.getImg());
        viewHolder.txtTlt.setText(modelObject.getTitle());

    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        // TODO: optional callback when current object has changed
    }
/*
    public TrackSet getData() {
        return data;
    }

    public void setData(TrackSet data) {
        if (this.data != data) {
            this.data = data;
            notifyDataSetChanged();
        }
    }*/

    public static class FooViewHolder extends RecycledPagerAdapter.ViewHolder {
        ImageView img;
        TextView txtTlt;

        public FooViewHolder(View v) {
            super(v);

            img = (ImageView) itemView.findViewById(R.id.img_PagerItem);
            txtTlt = (TextView) itemView.findViewById(R.id.txtTitle_PagerItem);

        }
    }
}