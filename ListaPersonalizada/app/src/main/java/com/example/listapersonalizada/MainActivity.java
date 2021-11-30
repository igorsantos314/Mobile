package com.example.listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = findViewById(R.id.ltvPersons);

        ArrayList<Person> persons_list = new ArrayList<>();

        persons_list.add(
                new Person("Igor", "Santos", 22, "ATIVO")
        );

        persons_list.add(
                new Person("Rafa", "Weiss", 28, "INATIVO")
        );

        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.custom_list_person, persons_list);
        persons.setAdapter(adapter);

        persons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(findViewById(R.id.telaHome), persons.getItemAtPosition(i).toString(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}