package com.example.coreldraw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] lst_images = {
            R.drawable.bglibrary,
            R.drawable.bgopenbook,
            R.drawable.bgvideo,
            R.drawable.bgexam,
            R.drawable.bgsearch,
            R.drawable.bgidea,
            R.drawable.bgstudent,
    };

    public String[] lst_title = {
            "KI dan KD",
            "Materi",
            "Video",
            "Latihan",
            "Glosarium",
            "Bantuan",
            "Profil",

    };

    public String[] lst_desc = {
            "Dalam menu KI dan KD ini ditampilkan Kompetensi Inti dan Kompetensi Dasar dari mata pelajaran Dasar Desain Grafis terutama materi pembelajaran CorelDRAW. Sebelum memulai suatu pembelajaran tentunya user perlu mengetahui terlebih dahulu KI dan KD, sehingga user tahu materi apa saja yang nantinya akan dipelajari dalam media pembelajaran CorelDRAW ini.",
            "Dalam menu Materi ini ditampilkan menu pilihan dari sub-sub materi yang dibahas pada materi pembelajaran Dasar Desain Grafis terutama materi CorelDRAW.",
            "Dalam menu Video ini ditampilkan menu pilihan video yang tersedia dan sesuai dengan materi pembelajaran CorelDRAW. Setelah memilih video user akan langsung bisa menikmanti materi sesuai dengan Kompetensi Dasar yang disajikan dalam bentuk video.",
            "Dalam menu Latihan ini terdapat latihan soal berdasarkan materi yang telah diajarkan. User akan mengerjakan latihan soal Pilihan Ganda dan jiku sudah selesai mengerjakan soal maka akan muncul nilai dari latihan soal tersebut.",
            "Dalam menu Glosarium ini memuat kata/istilah yang sukar atau sulit dimengerti.",
            "Dalam menu Bantuan ini menampilkan slide-slide yang bertujuan untuk membantu user dalam menggunakan aplikasi media pembelajaran CorelDRAW ini.",
            "Dalam menu Profil ini ditampilkan informasi terkait identitas dan latar belakang pengembang aplikasi media pembelajaran CorelDRAW ini.",
    };

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imgslide = (ImageView) view.findViewById(R.id.slide_image);
        TextView txtlt = (TextView) view.findViewById(R.id.texttittle);
        TextView txtdesc = (TextView) view.findViewById(R.id.textdesc);

        imgslide.setImageResource(lst_images[position]);
        txtlt.setText(lst_title[position]);
        txtdesc.setText(lst_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
