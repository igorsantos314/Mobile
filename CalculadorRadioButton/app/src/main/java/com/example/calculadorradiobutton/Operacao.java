package com.example.calculadorradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Operacao extends AppCompatActivity {

    TextView n1;
    TextView n2;

    Button calc;
    RadioGroup radio_operacoes;
    RadioButton radio_operacao_selecionada;

    Intent i;

    Double numero1;
    Double numero2;

    public void realizarOperacao(String operacao){
        Double res = 0.00;

        switch (operacao){
            case "Soma":
                res = numero1 + numero2;
                break;
            case "Subtração":
                res = numero1 - numero2;
                break;
            case "Multiplicacão":
                res = numero1 * numero2;
                break;
            case "Divisão":
                res = numero1 / numero2;
                break;
        }

        Toast.makeText(Operacao.this, "O resultado é: "+res.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacao);

        n1 = findViewById(R.id.tvNumero1);
        n2 = findViewById(R.id.tvNumero2);

        radio_operacoes = findViewById(R.id.rgOperacoes);
        calc = findViewById(R.id.btnCalcular);

        i = getIntent();

        numero1 = Double.parseDouble(i.getStringExtra("n1")) ;
        numero2 = Double.parseDouble(i.getStringExtra("n2")) ;

        n1.setText(numero1.toString());
        n2.setText(numero2.toString());

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer idOperacao = radio_operacoes.getCheckedRadioButtonId();

                //PEGAR O COMBO SELECIONADO
                radio_operacao_selecionada = findViewById(idOperacao);

                //PEGA O NOME DA OPERAÇÃO E ENVIA PARA A FUNÇÃO
                realizarOperacao(radio_operacao_selecionada.getText().toString());
            }
        });
    }
}