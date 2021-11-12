package com.example.apputs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    Toolbar toolbar;

    String[] ListviewMenu = new String[]{
            "Es Teh","Es Kopi","Jus Jeruk","Jus Apel","Jus Mangga",
            "Coca Cola","Sprite"
    };

    String[] ListviewDescription = new String[]{
            "Es Teh Manis semanis yang minum","Es kopi yang dibuat dari bahan kopi murni","Jus jeruk dari buah segar yang langsung dipetik dari pohon",
            "Jus Apel dari buah segar yang langsung dipetik dari pohon","Jus Mangga dari buah segar yang langsung dipetik dari pohon",
            "Coca Cola minuman bersoda yang menyegarkan","Sprite minuman bersoda yang menyegarkan"
    };

    String[] ListviewPrice = new String[]{
            "5.000","10.000","10.000",
            "13.000","10.000","10.000",
            "8.000","8.000"
    };

    int[] ListviewImages = new int[]{
            R.drawable.esteh,R.drawable.eskopi,R.drawable.jusjeruk,
            R.drawable.jusapel,R.drawable.jusmangga,R.drawable.cocacola,
            R.drawable.sprite
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Minuman");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ListView simpleListview = (ListView) findViewById(R.id.listView);


        CustomAdapter2 adapter = new CustomAdapter2();
        simpleListview.setAdapter(adapter);

        simpleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),ViewItemActivity.class);
                intent.putExtra("menu", ListviewMenu[i]);
                intent.putExtra("description", ListviewDescription[i]);
                intent.putExtra("price", ListviewPrice[i]);
                intent.putExtra("image", ListviewImages[i]);

                startActivity(intent);
            }
        });

    }

    private class
    CustomAdapter2 extends BaseAdapter {

        @Override
        public int getCount() {
            return ListviewImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.list_item, null);

            TextView menu = view1.findViewById(R.id.Menu);
            TextView price = view1.findViewById(R.id.Price);
            ImageView image = view1.findViewById(R.id.Images);

            menu.setText(ListviewMenu[i]);
            price.setText(ListviewPrice[i]);
            image.setImageResource(ListviewImages[i]);

            return view1;
        }
    }
}