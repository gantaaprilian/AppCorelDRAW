package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class Latihan extends AppCompatActivity {
    private long back;
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0, nomorsoal=1 ;
    public static int hasil, benar, salah;
    public ArrayList<Integer> nomor_soal;

    //Pertanyaan Soal
    String[] pertanyaan_soal = new String[]{
            "CorelDRAW adalah...",
            "Rectangle Tool berfungsi untuk...",
            "Elipse Tool berfungsi untuk...",
            "Alat yang digunakan untuk membentuk berbagai objek garis artistik adalah…..",
            "Alat yang digunakan untuk menarik, memindahkan objek adalah...",
            "Freehand tool berfungsi untuk....",
            "Berikul ini adalah menu yang terdapat di aplikasi corel draw, kecuali...",
            "Drop Shadow Tool digunakan untuk…..",
            "Tombol pada keyboard untuk mengexport gambar...",
            "Ctrl+D adalah shortcut pada keyboard yang berfungsi untuk..."
    };

    //Pilihan Jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Aplikasi Editor Grafik Vektor","Aplikasi Membuat Program","Aplikasi Membuat Animasi Flash","Aplikasi Berhitung",
            "Membuat lingkaran atau elips","Membuat garis lurus","Membuat persegi atau persegi panjang","Membuat segitiga",
            "Membuat persegi atau persegi panjang","Membuat lingkaran atau elips","Membuat garis lurus","Membuat gambar 3D",
            "Pen Tool","Crop Tool","Bezier Tool","Artistic Media Tool",
            "Knife Tool","Pick Tool","Envelope Tool","Shape Tool",
            "Alat yang digunakan untuk menggambar garis lurus atau garis bebas","Alat yang digunakan untuk membentuk berbagai objek garis artistik","Alat yang digunakan untuk membentuk beragam garis lurus dan garis yang tidak beraturan secara bersamaan","Alat yang digunakan untuk membuat garis-garis tabel yang menyerupai kertas grafik",
            "File","View","Effect","Mailing",
            "Untuk membuat efek transparan pada objek","Untuk membuat efek 3D pada objek","Untuk membuat efek bayangan pada objek","Untuk membuat efek distorsi pada objek",
            "CTRL+D","CTRL+E","CTRL+N","CTRL+Z",
            "Menduplikat gambar","Memotong gambar","Menyatukan gambar","Memisahkan gambar"
    };
    String[] pilihan_jawaban_a = new String[]{
            "Aplikasi Editor Grafik Vektor",
            "Membuat lingkaran atau elips",
            "Membuat persegi atau persegi panjang",
            "Pen Tool",
            "Knife Tool",
            "Alat yang digunakan untuk menggambar garis lurus atau garis bebas",
            "File",
            "Untuk membuat efek transparan pada objek",
            "CTRL+D",
            "Menduplikat gambar"
    };    String[] pilihan_jawaban_b = new String[]{
            "Aplikasi Membuat Program",
            "Membuat garis lurus",
            "Membuat lingkaran atau elips",
            "Crop Tool",
            "Pick Tool",
            "Alat yang digunakan untuk membentuk berbagai objek garis artistik",
            "View",
            "Untuk membuat efek 3D pada objek",
            "CTRL+E",
            "Memotong gambar"
    };    String[] pilihan_jawaban_c = new String[]{
            "Aplikasi Membuat Animasi Flash",
            "Membuat persegi atau persegi panjang",
            "Membuat garis lurus",
            "Bezier Tool",
            "Envelope Tool",
            "Alat yang digunakan untuk membentuk beragam garis lurus dan garis yang tidak beraturan secara bersamaan",
            "Effect",
            "Untuk membuat efek bayangan pada objek",
            "CTRL+N",
            "Menyatukan gambar"
    };    String[] pilihan_jawaban_d = new String[]{
            "Aplikasi Berhitung",
            "Membuat segitiga",
            "Membuat gambar 3D",
            "Artistic Media Tool",
            "Shape Tool",
            "Alat yang digunakan untuk membuat garis-garis tabel yang menyerupai kertas grafik",
            "Mailing",
            "Untuk membuat efek distorsi pada objek",
            "CTRL+Z",
            "Memisahkan gambar"
    };

    //Jawaban yang benar
    String[] jawaban_benar = new String[]{
            "Aplikasi Editor Grafik Vektor",
            "Membuat persegi atau persegi panjang",
            "Membuat lingkaran atau elips",
            "Artistic Media Tool",
            "Pick Tool",
            "Alat yang digunakan untuk menggambar garis lurus atau garis bebas",
            "Mailing",
            "Untuk membuat efek bayangan pada objek",
            "CTRL+E",
            "Menduplikat gambar"
    };

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton)findViewById(R.id.pilihanA);
        PilihanB = (RadioButton)findViewById(R.id.pilihanB);
        PilihanC = (RadioButton)findViewById(R.id.pilihanC);
        PilihanD = (RadioButton)findViewById(R.id.pilihanD);
        nomor_soal = randomSoal();


        pertanyaan.setText(nomorsoal+". " + pertanyaan_soal[nomor_soal.get(nomor)]);
        PilihanA.setText(pilihan_jawaban_a[nomor_soal.get(nomor)]);
        PilihanB.setText(pilihan_jawaban_b[nomor_soal.get(nomor)]);
        PilihanC.setText(pilihan_jawaban_c[nomor_soal.get(nomor)]);
        PilihanD.setText(pilihan_jawaban_d[nomor_soal.get(nomor)]);

        rg.check(0);
        benar = 0;
        salah = 0;

    }

    public void next (View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor_soal.get(nomor)])) benar++;
            else salah++;
            nomor++;
            nomorsoal++;

            if (nomor < pertanyaan_soal.length) {
                pertanyaan.setText(nomorsoal+". "+pertanyaan_soal[nomor_soal.get(nomor)]);
                PilihanA.setText(pilihan_jawaban_a[nomor_soal.get(nomor)]);
                PilihanB.setText(pilihan_jawaban_b[nomor_soal.get(nomor)]);
                PilihanC.setText(pilihan_jawaban_c[nomor_soal.get(nomor)]);
                PilihanD.setText(pilihan_jawaban_d[nomor_soal.get(nomor)]);
            } else {
                goToHasil(benar,salah);
            }
        }
        else {
            Toast.makeText(this, "Pilih Jawaban Dulu!",Toast.LENGTH_SHORT).show();
        }
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

    public void goToHasil(int jumbenar,int jumsalah){
        int finalHasil = jumbenar * 10;
        Intent selesai = new Intent(getApplicationContext(), HasilLatihanSoal.class);
        selesai.putExtra(HasilLatihanSoal.FINAL_NILAI,finalHasil);
        selesai.putExtra(HasilLatihanSoal.FINAL_BENAR,jumbenar);
        selesai.putExtra(HasilLatihanSoal.FINAL_SALAH,jumsalah);
        startActivity(selesai);
    }

//    public void onBackPressed() {
//        if (back + 1000 > System.currentTimeMillis()) {
//            super.onBackPressed();
//            return;
//        } else {
//            Toast.makeText(getBaseContext(), "Selesaikan Soal Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
//        }
//    }
}
