package com.example.tugas5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dh;
    public static ListView listView;
    public static EditText editName, editClub;
    Button btnTambah;

    ArrayAdapter adapter;

    ArrayList<String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listdata);
        editName = findViewById(R.id.dataplayer);
        editClub = findViewById(R.id.dataclub);
        btnTambah = findViewById(R.id.btnadd);
        dh = new DatabaseHelper(this);
        listviewku = new ArrayList<>();
        view_AllData();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String noid = listviewku.get(i);
                final String nomor = noid.substring(0,2);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Warning !")
                        .setMessage("Yakin menghapus data ini ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Integer deletedRows = dh.deleteData(nomor);
                                listviewku.remove(i);
                                listView.invalidateViews();
                                if(deletedRows > 0)
                                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return false;
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dh.addData(editName.getText().toString(),editClub.getText().toString());
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                listviewku.clear();
                view_AllData();
            }
        });
    }

    private void view_AllData() {
        Cursor cursor = dh.viewAll();
        if (cursor.getCount()==0){
            Toast.makeText(this, "Record Kosong", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listviewku.add(String.valueOf(cursor.getInt(0))+" "+cursor.getString(1)+" "+cursor.getString(2));
            }
            adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }
}