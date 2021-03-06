package com.example.thali.segundoprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdicionar;
    ListView listViewContato;
    List<Contato> lista = repositorioContato.getContatos();
    repositorioContato  repositorio = new repositorioContato();
    adapterContato adapter = new adapterContato(this,lista);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<Contato>();
        btnAdicionar = findViewById(R.id.btnAdicionar);
        listViewContato = findViewById(R.id.listViewContato);

        listViewContato.setAdapter(adapter);

        listViewContato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contato =(Contato) parent.getItemAtPosition(position);
                Intent info = new Intent(MainActivity.this, infoContato.class);
                info.putExtra("objeto",contato);
                info.putExtra("id",position);
                startActivity(info);
            }
            });


        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, cadastrarContato.class);
                startActivity(it);
            }

        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
