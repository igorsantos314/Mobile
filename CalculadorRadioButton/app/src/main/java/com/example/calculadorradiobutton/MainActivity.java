package com.example.calculadorradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button operacao;
    EditText n1;
    EditText n2;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacao = findViewById(R.id.btnSelecionarOperacao);
        n1 = findViewById(R.id.etnN1);
        n2 = findViewById(R.id.etnN2);

        operacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity.this, Operacao.class);

                i.putExtra("n1", n1.getText().toString());
                i.putExtra("n2", n2.getText().toString());

                startActivity(i);
            }
        });
    }
}