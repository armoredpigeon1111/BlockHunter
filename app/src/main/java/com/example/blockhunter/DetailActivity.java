package com.example.blockhunter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

//TODO: Larger image, Price and Description
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        final Product product = (Product)intent.getSerializableExtra("product");

        String name = product.getProductName();//intent.getStringExtra("image_name");

        TextView txtName = findViewById(R.id.txtProductTitle);
        txtName.setText(name);

        TextView bbPrice = findViewById(R.id.bbPrice);
        bbPrice.setText(product.getBbPrice());
        findViewById(R.id.bbPrice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = product.getBBUrl();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        TextView walmartPrice = findViewById(R.id.walmartPrice);
        walmartPrice.setText(product.getWalmartPrice());

        TextView description = findViewById(R.id.txtDescription);
        description.setText(product.getProductDescription());

        String image = product.getMediumImage();//intent.getStringExtra("image_url");
        ImageView pImage = findViewById(R.id.imgProductDetail);

        Glide.with(DetailActivity.this)
                .asBitmap()
                .load(image)
                .into(pImage);
    }
}
