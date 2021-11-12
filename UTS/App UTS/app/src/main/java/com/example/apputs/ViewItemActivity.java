package com.example.apputs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewItemActivity extends AppCompatActivity {

    Toolbar toolbar;

    ImageView imageView;
    TextView listData, listDesc, listPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listData = findViewById(R.id.listMenu);
        listDesc = findViewById(R.id.listDesc);
        listPrice = findViewById(R.id.listPrice);
        imageView = findViewById(R.id.imageView);


        Intent intent = getIntent();
        String receiveMenu = intent.getStringExtra("menu");
        String receiveDesc = intent.getStringExtra("description");
        String receivePrice = intent.getStringExtra("price");
        int receiveImage = intent.getIntExtra("image",0);
        listData.setText(receiveMenu);
        listDesc.setText(receiveDesc);
        listPrice.setText(receivePrice);
        imageView.setImageResource(receiveImage);

    }
}
