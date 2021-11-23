package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CICLO_DE_VIDA";

    // Get reference of widgets from XML layout
    ListView lv;
    Button add;
    EditText item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "ON CREATE");

        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        add = (Button) findViewById(R.id.btAdd);
        item = (EditText) findViewById(R.id.etvItem);

        // Initializing a new String Array
        String[] fruits = new String[] {
                "Igor",
                "Maria"
        };

        // Create a List from String Array elements
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));
        
        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

                String selectedFromList =(String) (lv.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, selectedFromList, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra(
                        "Nome",
                        selectedFromList
                );
                startActivity(i);

            }});

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(item.getText().length() > 0){
                    fruits_list.add(item.getText().toString());

                    //ATUALIZAR ARRAYS
                    arrayAdapter.notifyDataSetChanged();

                    item.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Digite Algo !!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Digite Algo !!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();

        Log.i(TAG, "ON START");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "ON RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "ON PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "ON STOP");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "ON RESTART");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "ON DESTROY");
    }
}