package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity {
    private long keluar;
    private CardView kikd, materi, video, latihan, pintasan, bantuan, profilku, logout;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        kikd = (CardView) findViewById(R.id.cardKIKD);
        kikd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, KIKD.class));
            }
        });

        materi = (CardView) findViewById(R.id.cardMateri);
        materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Materi.class));
            }
        });

        video = (CardView) findViewById(R.id.cardVideo);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Video.class));
            }
        });

        latihan = (CardView) findViewById(R.id.cardLatihan);
        latihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Latihan.class));
            }
        });

        pintasan = (CardView) findViewById(R.id.cardPintasan);
        pintasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Pintasan.class));
            }
        });

        bantuan = (CardView) findViewById(R.id.cardBantuan);
        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Bantuan.class));
            }
        });

        profilku = (CardView) findViewById(R.id.cardTentang);
        profilku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Profil.class));
            }
        });

        logout = (CardView) findViewById(R.id.cardKeluar);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
    public void onBackPressed() {
        if (keluar + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Tekan sekali lagi untuk keluar!", Toast.LENGTH_SHORT).show();
        }

        keluar = System.currentTimeMillis();
    }
}
