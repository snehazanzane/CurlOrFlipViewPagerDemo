package com.sneha.viewpagerpagetransformaredemos;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    ArrayList<PageModel> arr = new ArrayList<>();

    public CustomPagerAdapter(Context context, ArrayList<PageModel> arr) {
        mContext = context;
        this.arr = arr;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        PageModel modelObject = arr.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = (View) inflater.inflate(R.layout.view_pager_item, collection, false);

        ImageView img = (ImageView) itemView.findViewById(R.id.img_PagerItem);
        TextView txtTlt = (TextView) itemView.findViewById(R.id.txtTitle_PagerItem);

        img.setImageResource(modelObject.getImg());
        txtTlt.setText(modelObject.getTitle());

        collection.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        PageModel obj = arr.get(position);
        return obj.getTitle();
    }

}