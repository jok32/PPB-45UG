package com.example.myfirebaseapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivityView extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    Mahasiswa mahasiswa;

    ArrayList<Mahasiswa> arrayView = new ArrayList<>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        listView = findViewById(R.id.listdata);

        mahasiswa = new Mahasiswa();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("mahasiswa");
        arrayAdapter = new ArrayAdapter(MainActivityView.this,R.layout.support_simple_spinner_dropdown_item,arrayView);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Mahasiswa hasil = snapshot.getValue(Mahasiswa.class);
                    arrayView.add(hasil);
                    arrayAdapter.notifyDataSetChanged();
//                arrayView.add(snapshot.getValue(Mahasiswa.class));
//                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}