package com.sneha.viewpagerpagetransformaredemos;

import android.support.design.widget.BottomSheetDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sneha.viewpagerpagetransformaredemos.DepthPageTrensformer.DepthViewPageTransformer;
import com.sneha.viewpagerpagetransformaredemos.FadeTransformer.FadePageTransformer;
import com.sneha.viewpagerpagetransformaredemos.ZoomTransformer.ZoomOutPageTransformer;
import com.sneha.viewpagerpagetransformaredemos.curlPageLib.PageCurlPageTransformer;
import com.sneha.viewpagerpagetransformaredemos.flipPage.FlipPageViewTransformer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button btnChangeTransformer;

    ArrayList<PageModel> arr = new ArrayList<>();

    CustomPagerAdapter customPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager_MainActivity);
        btnChangeTransformer = (Button) findViewById(R.id.btnChangeTransformer_MainActivity);

        arr.add(new PageModel(R.drawable.img1, "halloween", true));
        arr.add(new PageModel(R.drawable.img2, "Colors", true));
        arr.add(new PageModel(R.drawable.img3, "Holli", true));
        arr.add(new PageModel(R.drawable.img4, "Flowers", true));
        arr.add(new PageModel(R.drawable.img5, "Music Party", true));
        arr.add(new PageModel(R.drawable.img6, "Balloons", true));
        arr.add(new PageModel(R.drawable.img7, "Lights", true));
        arr.add(new PageModel(R.drawable.img8, "Happy Mothers Day", true));
        arr.add(new PageModel(R.drawable.img9, "Happy Children's Day", true));
        arr.add(new PageModel(R.drawable.img10, "Live Free", true));
        arr.add(new PageModel(R.drawable.img11, "Clouds", true));
        arr.add(new PageModel(R.drawable.img12, "Under Sea", true));
        arr.add(new PageModel(R.drawable.img13, "Sun Shine", true));
        arr.add(new PageModel(R.drawable.img14, "Happy to see you", true));

        customPagerAdapter = new CustomPagerAdapter(MainActivity.this, arr);
        viewPager.setAdapter(customPagerAdapter);

        btnChangeTransformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionDialog();
            }
        });

    }

    private void showOptionDialog() {
        View view = getLayoutInflater().inflate(R.layout.dia_options, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        TextView btnCurl = (TextView) view.findViewById(R.id.txtCurl_dia);
        TextView btnFlip = (TextView) view.findViewById(R.id.txtFlipPage_dia);
        TextView btnZoomOut = (TextView) view.findViewById(R.id.txtZoomOutPage_dia);
        TextView btnDepthPage = (TextView) view.findViewById(R.id.txtDepthPage_dia);
        TextView btnFadePage = (TextView) view.findViewById(R.id.txtFadePage_dia);

        btnCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setPageTransformer(false, new PageCurlPageTransformer());
                dialog.dismiss();
            }
        });

        btnFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setPageTransformer(false, new FlipPageViewTransformer());
                dialog.dismiss();
            }
        });

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setPageTransformer(false, new ZoomOutPageTransformer());
                dialog.dismiss();
            }
        });

        btnDepthPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setPageTransformer(false, new DepthViewPageTransformer());
                dialog.dismiss();
            }
        });

        btnFadePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setPageTransformer(false, new FadePageTransformer());
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
