package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class Latihan extends AppCompatActivity {
    private long back;
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan Soal
    String[] pertanyaan_soal = new String[]{
            "1. CorelDRAW adalah...",
            "2. Rectangle Tool berfungsi untuk...",
            "3. Elipse Tool berfungsi untuk...",
            "4. Alat yang digunakan untuk membentuk berbagai objek garis artistik adalah…..",
            "5. Alat yang digunakan untuk menarik, memindahkan objek adalah...",
            "6. Freehand tool berfungsi untuk....",
            "7. Berikul ini adalah menu yang terdapat di aplikasi corel draw, kecuali...",
            "8. Drop Shadow Tool digunakan untuk…..",
            "9. Tombol pada keyboard untuk mengexport gambar...",
            "10. Ctrl+D adalah shortcut pada keyboard yang berfungsi untuk..."
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

        pertanyaan.setText(pertanyaan_soal[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;

    }

    public void next (View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;

            if (nomor < pertanyaan_soal.length) {
                pertanyaan.setText(pertanyaan_soal[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 10;
                Intent selesai = new Intent(getApplicationContext(), HasilLatihanSoal.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this, "Pilih Jawaban Dulu!",Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
        if (back + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Selesaikan Soal Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
        }
    }
}
