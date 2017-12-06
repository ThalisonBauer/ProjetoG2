package com.example.thali.segundoprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdicionar;
    ListView listViewContato;
    List<Contato> lista = repositorioContato.getContatos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<Contato>();
        btnAdicionar = findViewById(R.id.btnAdicionar);
        listViewContato = findViewById(R.id.listViewContato);

        adapterContato adapter = new  adapterContato(getApplication(),lista);
        listViewContato.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, cadastrarContato.class);
                startActivity(it);
            }
        });
    }
}
