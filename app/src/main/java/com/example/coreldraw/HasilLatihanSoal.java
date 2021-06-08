package com.example.coreldraw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilLatihanSoal extends AppCompatActivity {
    private long back;
    public static final String FINAL_NILAI = "nilai_final";
    public static final String FINAL_BENAR = "nilai_benar";
    public static final String FINAL_SALAH = "nilai_salah";
    int nilaifinal,jumlahbenar,jumlahsalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_latihan_soal);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nilaifinal = bundle.getInt(FINAL_NILAI);
            jumlahbenar = bundle.getInt(FINAL_BENAR);
            jumlahsalah = bundle.getInt(FINAL_SALAH);
        }
        hasil.setText("Jawababan Benar : "+jumlahbenar+"\nJawaban Salah : "+jumlahsalah);
        nilai.setText(""+nilaifinal);
    }

    public void ulangi (View view){
        finish();
        Intent i = new Intent(getApplicationContext(),Soal.class);
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
