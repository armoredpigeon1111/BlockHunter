package com.example.blockhunter;
//Mohammad is working on Detail Activity
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String image = intent.getStringExtra("image_url");
        String name = intent.getStringExtra("image_name");

        TextView txtName = findViewById(R.id.txtProductTitle);
        txtName.setText(name);

        ImageView pImage = findViewById(R.id.imgProductDetail);
        try {
            Bitmap bmp;
            bmp = new BitmapFactory.decodeStream(new URL(image).openConnection().getInputStream());
            pImage.setImageBitmap(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
