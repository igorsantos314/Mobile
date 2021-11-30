package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView minha_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minha_lista = findViewById(R.id.ltv);

        ArrayList<String> numeros = new ArrayList<>();

        for(int i=0; i<10; i++){
            numeros.add(String.valueOf(
                    i
            ));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros);

        minha_lista.setAdapter(adapter);

        minha_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(findViewById(R.id.minhaView), minha_lista.getItemAtPosition(i).toString(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}