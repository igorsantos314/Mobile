package com.example.receberintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class BuscarCliente extends AppCompatActivity {

    Button escolher;
    Spinner lista_clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);

        escolher = findViewById(R.id.btnEscolher);
        lista_clientes = findViewById(R.id.spnClientes);

        escolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();

                //ENVIAR INFORMAÇÕES
                i.putExtra("cliente", lista_clientes.getSelectedItem().toString());

                //ENVIA A INTENÇÃO
                setResult(15, i);

                //FINALIZAR CONSULTA DE CLIENTES
                finish();
            }
        });
    }
}