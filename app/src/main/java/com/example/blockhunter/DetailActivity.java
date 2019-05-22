package com.example.blockhunter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//TODO: Larger image, Price and Description
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

                    Intent intent = getIntent();
                    String name = intent.getStringExtra("image_name");

                    TextView txtName = findViewById(R.id.txtProductTitle);
                    txtName.setText(name);

                    String image = intent.getStringExtra("image_url");
                    ImageView pImage = findViewById(R.id.imgProductDetail);

                    Glide.with(DetailActivity.this)
                            .asBitmap()
                            .load(image)
                            .into(pImage);
    }
}
