package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class Bantuan extends AppCompatActivity {

    private ViewPager sliderViewPager;
    private SliderAdapter sliderAdapter;
    private LinearLayout sliderDots;
    private TextView[] sDots;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        sliderViewPager = findViewById(R.id.sliderViewPager);
        sliderDots = findViewById(R.id.sliderDots);

        sliderAdapter = new SliderAdapter(Bantuan.this);
        sliderViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        sliderViewPager.addOnPageChangeListener(viewListener);
    }


    private void addDotsIndicator(int position){
        sDots = new TextView[7];
        sliderDots.removeAllViews();

        for (int i = 0; i < sDots.length; i++){
            sDots[i] = new TextView(Bantuan.this);
            sDots[i].setText(Html.fromHtml("&#8226;"));
            sDots[i].setTextSize(35);
            sDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));

            sliderDots.addView(sDots[i]);
        }

        if (sDots.length > 0){
            sDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int il) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}


