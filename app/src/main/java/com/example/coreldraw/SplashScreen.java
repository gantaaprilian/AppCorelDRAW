package com.example.coreldraw;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        tv = (TextView)findViewById(R.id.tvjudul);
        iv = (ImageView)findViewById(R.id.ivlogo);
        Animation mine = AnimationUtils.loadAnimation(this, R.anim.transition);
        final Intent go = new Intent(this, Home.class);

        //set durasi
        mine.setDuration(1000);
        tv.startAnimation(mine);
        iv.startAnimation(mine);

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(go);
                    finish();
                }
            }
        };
        t.start();
    }
}
