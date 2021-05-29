package com.example.coreldraw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilLatihanSoal extends AppCompatActivity {
    private long back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_latihan_soal);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);
        hasil.setText("Jawababan Benar : "+Latihan.benar+"\nJawaban Salah : "+Latihan.salah);
        nilai.setText(""+Latihan.hasil);
    }

    public void ulangi (View view){
        finish();
        Intent i = new Intent(getApplicationContext(),Latihan.class);
        startActivity(i);
    }

    public void onBackPressed() {
        if (back + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {

        }
    }
}
