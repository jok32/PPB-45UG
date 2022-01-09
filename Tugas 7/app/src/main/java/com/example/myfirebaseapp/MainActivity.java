package com.example.myfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nim,namasiswa;
    Button tbladd,tblview;
    DatabaseReference reference;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nim = findViewById(R.id.editNim);
        namasiswa = findViewById(R.id.editNama);
        tbladd = findViewById(R.id.tombolAdd);
        tblview = findViewById(R.id.tombolView);

        mahasiswa = new Mahasiswa();

        reference = FirebaseDatabase.getInstance().getReference().child("Mahasiswa");

        tbladd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa.setNim(nim.getText().toString().trim());
                mahasiswa.setNama(namasiswa.getText().toString().trim());
                reference.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivityView.class);
//                startActivity(intent);
                startActivity(new Intent(MainActivity.this, MainActivityView.class));
            }
        });

    }
}