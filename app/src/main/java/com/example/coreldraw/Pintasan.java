package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class Pintasan extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    ArrayList<ModelPintasan> arrayList = new ArrayList<ModelPintasan>();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pintasan);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        title = new String[]{
                "2-Point Line Tool",
                "3-Point Callout Tool",
                "3-Point Curve Tool",
                "3-Point Ellipse Tool",
                "3-Point Rectangle Tool",
                "Add Perspective",
                "Angular Dimension Tool",
                "Arrows Shapes Tool",
                "Artistic Media Tool",
                "Attrach Tool",
                "Attributes Eyedropper Tool",
                "Banner Shapes Tool",
                "Basic Shapes Tool",
                "Bezier Tool",
                "Blend Tool",
                "B-Spline Tool",
                "Callout Shapes Tool",
                "Color Eyedropper Tool",
                "Color Palettes",
                "Complex Star Tool",
                "Contour Tool",
                "Crop Tool",
                "Distort Tool",
                "Drop Shadow Tool",
                "Edit Anchor Tool",
                "Ellipse Tool",
                "Envelope Tool",
                "Eraser Tool",
                "Extrude Tool",
                "Flowchart Shapes Tool",
                "Free Transform Tool",
                "Freehand Pick Tool",
                "Freehand Tool",
                "Graph Paper Tool",
                "Horizontal or Vertical Dimension Tool",
                "Interactive Fill Tool ",
                "Jendela Dokumen",
                "Knife Tool",
                "Menu Bar",
                "Mesh Fill Tool",
                "Page Navigator",
                "Palet Color",
                "Parallel Dimension Tool",
                "Pattern Fill",
                "Pen Tool",
                "Pick Tool",
                "Polygon Tool",
                "Polyline Tool",
                "PowerClip",
                "Property Bar",
                "Rectangle Tool",
                "Right-Angle Connector Tool",
                "Roughen Tool",
                "Rounded Right-Angle Connector Tool",
                "Scroll Bar",
                "Segment Dimension Tool",
                "Shape Tool",
                "Smart Drawing Tool ",
                "Smart Fill Tool",
                "Smear Tool",
                "Smooth Tool",
                "Smudge Tool",
                "Spiral Tool",
                "Standard Toolbar",
                "Star Tool",
                "Straight-Line Connector Tool",
                "Table Tool",
                "Teks Artistik",
                "Teks Paragraf",
                "Text Tool",
                "Texture",
                "Toolbox",
                "Transparency Tool",
                "Twirl Tool",
                "Uniform Fill",
                "Virtual Segment Delete Tool",
                "Zoom Tool"
        };
        description = new String[]{
                "Untuk membuat garis lurus dengan cara menarik dari titik awal ke titik akhir",
                "Untuk menggambar objek callout yang berguna untuk memberi keterangan objek",
                "Untuk membuat garis lengkung dengan tiga titik",
                "Untuk membuat objek elips dengan acuan tiga titik",
                "Untuk membuat objek persegi empat atau bujur sangkar dengan acuan tiga titik",
                "Untuk mengubah bentuk objek",
                "Untuk mengukur derajat sudut objek",
                "Untuk membuat berbagai bentuk objek panah",
                "Untuk menggambar garis-garis artistik",
                "Untuk mengubah objek menjadi lancip dengan cara klik dan tahan agak lama pada outline objek tersebut",
                "Untuk menyalin sampel atribut pada suatu objek, seperti warna garis luar, warna bidang, atau gradasi",
                "Untuk membuat berbagai bentuk objek banner",
                "Untuk membuat objek-objek dasar yang telah disediakan CorelDRAW",
                "Untuk menggambar garis lurus maupun lengkung",
                "Untuk mengkombinasikan bentuk dan warna antar objek",
                "Untuk membuat garis kurva tanpa henti",
                "Untuk membuat berbagai bentuk objek sebagai teks keterangan gambar",
                "Untuk mengambil sampel warna dari suatu warna objek yang lain",
                "Menyediakan berbagai macam warna yang dapat Anda gunakan untuk mewarnai objek.",
                "Untuk membuat objek bintang dengan pola yang lebih kompleks",
                "Untuk menciptakan garis-garis kontur objek",
                "Untuk memotong objek",
                "Untuk memberi efek distorsi dan efek ini sering digunakan untuk mengubah-ubah pola dan bentuk dari suatu objek",
                "Untuk menerapkan efek bayangan pada objek",
                "Untuk mengedit titik garis penghubung",
                "Untuk membuat objek lingkaran atau elips",
                "Untuk mengubah bentuk dengan cara menggeser titik-titik handle atau garis di sekeliling objek",
                "Untuk menghapus objek seperti menggunakan penghapus",
                "Untuk memberi ketebalan objek dan memberi kesan tiga dimensi (3D) pada objek",
                "Untuk membuat berbagai bentuk objek diagram alur atau flowchart",
                "Untuk memutar, memiringkan, dan mengubah skala objek dengan bebas",
                "Untuk memilih objek dengan arah yang bebas",
                "Untuk menggambar sat garis lurus atau garis bebas sesuai seperti Anda menggambar dengan pensil",
                "Untuk membuat garis-garis tabel yang menyerupai kertas grafik",
                "Untuk mengukur objek dengan arah horizontal atau vertikal",
                "Untuk mewarnai bidang objek dengan berbagai macam pilihan warna",
                "Tempat untuk membuat dan mengolah objek",
                "Untuk memotong objek, seperti memotong dengan menggunakan pisau",
                "Menampilkan semua peintah-perintah yang digukanan untuk mengatur dan mengolah objek",
                "Untuk mewarnai objek dengan berbagai pilihan warna yang terpola",
                "Tombol untuk mengolah dan mengatur halaman",
                "Kotak yang berisi daftar warna yang berfungsi untuk mewarnai objek, baik warna permukaan maupun warna garis tepi objek",
                "Untuk mengukur objek dengan arah bebas",
                "Perintah untuk mewarnai objek dengan corak tertentu",
                "Untuk menggambar objek garis lurus dan lengkung dengan garis yang masih berada pada ujung pen (Ketika menggambar)",
                "Untuk memilih, memutar, memindah, memiringkan, dan mengatur skala objek",
                "Untuk menggambar objek poligon atau segi banyak",
                "Untuk membuat beberapa garis lurus (jika menggambar dengan klik) dan garis bebas (jika menggambar dengan cara menggeser)",
                "Untuk menyisipkan objek ke dalam objek yang lain",
                "Menampilkan beberapa tombol perintah dan parameter sesuai dengan tool yang aktif.",
                "Untuk membuat objek persegi Panjang atau bujur sangkar",
                "Untuk membuat garis penghubung dengan bentuk garis siku",
                "Untuk mengubah bentuk tepian objek dengan pola kasar",
                "Untuk membuat garis penghubung dengan bentuk garis tumpul",
                "Untuk menggeser tampilan lembar kerja",
                "Untuk mengukur beberapa segmen garis objek secara bersamaan",
                "Untuk mengedit objek kurva atau karakter teks menggunakan node",
                "Untuk membuat garis bebas dan mengkonversi gambar bebas yang Anda buat menjadi bentuk dasar atau merapikan kurva",
                "Untuk menerapkan warna pada pbjek dengan garis tertutup dengan menciptakan objek baru",
                "Untuk mengubah objek dengan cara menarik objek tersebut sehingga menjadi bentuk lain",
                "Untuk menghaluskan objek dengan menggeser garis outline-nya",
                "Untuk mengubah bentuk tepian objek dengan pola halus",
                "Untuk membuat objek spiral",
                "Menampilkan beberapa tombol perintah yang sering digunakan dalam mengolah objek.",
                "Untuk membuat objek bintang dengan berbagai variasi",
                "Untuk membuat garis penghubung dengan bentuk garis lurus",
                "Untuk menggabar tabel",
                "Untuk mengetik teks yang pendek seperti judul",
                "Untuk mengetik teks berbentuk kalimat yang cukup panjang dan lebar di dalam sebuah frame teks",
                "Untuk mengetik teks di dalam lembar kerja",
                "Perintah yang digunakan untuk mengisi bidang objek dengan pola tekstur yang tersedia",
                "Tempat tombol-tombol perintah untuk membuat dan memodifikasi objek",
                "Untuk membuat objek menjadi transparan",
                "Untuk membuat efek pusaran dengan cara klik dan tahan agak lama pada bagian objek tertentu",
                "Perintah untuk mewarnai objek dengan satu warna solid",
                "Untuk menghapus bagian objek tertentu",
                "Untuk mengatur ukuran tampilan lembar kerja"
        };

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++){
            ModelPintasan model = new ModelPintasan(title[i], description[i]);
            arrayList.add(model);
        }

        adapter = new ListViewAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
