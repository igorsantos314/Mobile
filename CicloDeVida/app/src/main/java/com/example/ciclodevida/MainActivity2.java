package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Intent i;
    TextView titulo;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //TEXT VIEW
        titulo = findViewById(R.id.tvTitulo);
        finalizar = findViewById(R.id.btnFinalizar);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //PEGAR INTENÇÃO
        i = getIntent();

        //PEGAR OS ATRIBUTOS QUE CHEGAM
        String name = i.getStringExtra("Nome");

        //SETAR ATRIBUTOS
        titulo.setText("Bem a nova Activy "+name);
    }
}