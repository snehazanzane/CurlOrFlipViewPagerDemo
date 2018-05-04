package com.sneha.viewpagerpagetransformaredemos.curlPageLib;

import android.support.v4.view.ViewPager;
import android.view.View;


public class PageCurlPageTransformer implements ViewPager.PageTransformer {

    String TAG="PageCurlPageTransformer";

    @Override
    public void transformPage(View page, float position) {

        if (page instanceof PageCurl) {
            if (position > -1.0F && position < 1.0F) {
                // hold the page steady and let the views do the work
                page.setTranslationX(-position * page.getWidth());
            } else {
                page.setTranslationX(0.0F);
            }
            if (position <= 1.0F && position >= -1.0F) {
                ((PageCurl) page).setCurlFactor(position);
            }
        }
    }
}
