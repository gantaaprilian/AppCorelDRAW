package com.example.coreldraw;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class TebakGambar extends AppCompatActivity {
    private long back;
    ImageView pertanyaan_gambar;
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;
    public ArrayList<Integer> nomor_soal;

    //Pertanyaan Soal
    int[] pertanyaan_soal = new int[]{
            R.drawable.efekbackminusfront,
            R.drawable.efekblend,
            R.drawable.efekcontour,
            R.drawable.efekdistort,
            R.drawable.efekextrude,
            R.drawable.efekfrontminusback,
            R.drawable.efekshadow,
            R.drawable.efektransparan,
            R.drawable.efektrim,
            R.drawable.efekweld
    };

    //Pilihan Jawaban a, b, c, d
    String[] pilihan_jawaban_a = new String[]{
            "Back Minus Front",
            "Contour",
            "Weld",
            "Distort",
            "Extrude",
            "Front Minus Back",
            "Shadow",
            "Transparency",
            "Trim",
            "Weld",
    };
    String[] pilihan_jawaban_b = new String[]{
            "Contour",
            "Blend",
            "Shadow",
            "Extrude",
            "Weld",
            "Transparency",
            "Trim",
            "Distort",
            "Back Minus Front",
            "Front Minus Back",
    };
    String[] pilihan_jawaban_c = new String[]{
            "Blend",
            "Front Minus Back",
            "Trim",
            "Transparency",
            "Distort",
            "Back Minus Front",
            "Distort",
            "Shadow",
            "Front Minus Back",
            "Distort",
    };
    String[] pilihan_jawaban_d = new String[]{
            "Transparency",
            "Trim",
            "Contour",
            "Back Minus Front",
            "Transparency",
            "Shadow",
            "Transparency",
            "Contour",
            "Blend",
            "Trim",
    };

    //Jawaban yang benar
    String[] jawaban_benar = new String[]{
            "Back Minus Front",
            "Blend",
            "Contour",
            "Distort",
            "Extrude",
            "Front Minus Back",
            "Shadow",
            "Transparency",
            "Trim",
            "Weld",
            "Shadow",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pertanyaan_gambar = findViewById(R.id.soal_gambar);
        pertanyaan = (TextView)findViewById(R.id.pertanyaan_gambar);
        rg = (RadioGroup)findViewById(R.id.radio_group_gambar);
        PilihanA = (RadioButton)findViewById(R.id.pilihanA_gambar);
        PilihanB = (RadioButton)findViewById(R.id.pilihanB_gambar);
        PilihanC = (RadioButton)findViewById(R.id.pilihanC_gambar);
        PilihanD = (RadioButton)findViewById(R.id.pilihanD_gambar);
        nomor_soal = randomSoal();

        pertanyaan_gambar.setImageResource(pertanyaan_soal[nomor_soal.get(nomor)]);
//        pertanyaan.setText(pertanyaan_soal[nomor_soal.get(nomor)]);
//        PilihanA.setText(pilihan_jawaban_a[nomor_soal.get(nomor)]);
//        PilihanB.setText(pilihan_jawaban_b[nomor_soal.get(nomor)]);
//        PilihanC.setText(pilihan_jawaban_c[nomor_soal.get(nomor)]);
//        PilihanD.setText(pilihan_jawaban_d[nomor_soal.get(nomor)]);
        randomJawaban(nomor_soal.get(nomor));

        rg.check(0);
        benar = 0;
        salah = 0;

    }

    ArrayList<Integer> randomSoal(){
        ArrayList<Integer> nosoal = new ArrayList<Integer>();
        for (int i = 0; i< pertanyaan_soal.length;i++){
            nosoal.add(i);
        }
        Collections.shuffle(nosoal);
        Log.d("list data",nosoal.toString());
        Log.d("list size",nosoal.size()+"");
        return nosoal;
    }

    public void randomJawaban(int soal){
        ArrayList<String> dumpsoal = new ArrayList<>();
        dumpsoal.add(pilihan_jawaban_a[soal]);
        dumpsoal.add(pilihan_jawaban_b[soal]);
        dumpsoal.add(pilihan_jawaban_c[soal]);
        dumpsoal.add(pilihan_jawaban_d[soal]);
        Collections.shuffle(dumpsoal);

        PilihanA.setText(dumpsoal.get(0));
        PilihanB.setText(dumpsoal.get(1));
        PilihanC.setText(dumpsoal.get(2));
        PilihanD.setText(dumpsoal.get(3));
    }

    public void nextGambar(View view){
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor_soal.get(nomor)])) benar++;
            else salah++;
            nomor++;

            if (nomor < pertanyaan_soal.length) {
                pertanyaan_gambar.setImageResource(pertanyaan_soal[nomor_soal.get(nomor)]);
//                PilihanA.setText(pilihan_jawaban_a[nomor_soal.get(nomor)]);
//                PilihanB.setText(pilihan_jawaban_b[nomor_soal.get(nomor)]);
//                PilihanC.setText(pilihan_jawaban_c[nomor_soal.get(nomor)]);
//                PilihanD.setText(pilihan_jawaban_d[nomor_soal.get(nomor)]);
                randomJawaban(nomor_soal.get(nomor));

            } else {
                goToHasil(benar,salah);
            }
        }
        else {
            Toast.makeText(this, "Pilih Jawaban Dulu!",Toast.LENGTH_SHORT).show();
        }

    }

    private void goToHasil(int jumbenar, int jumsalah) {
        int finalHasil = jumbenar * 10;
        Intent selesai = new Intent(getApplicationContext(), HasilLatihanSoal.class);
        selesai.putExtra(HasilLatihanSoal.FINAL_NILAI,finalHasil);
        selesai.putExtra(HasilLatihanSoal.FINAL_BENAR,jumbenar);
        selesai.putExtra(HasilLatihanSoal.FINAL_SALAH,jumsalah);
        startActivity(selesai);
    }
}