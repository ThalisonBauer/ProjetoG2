package com.example.thali.segundoprojeto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class infoContato extends AppCompatActivity {
    public void isMain(){
        Intent letsMain = new Intent(infoContato.this, MainActivity.class);
        startActivity(letsMain);
    }
    public void msn(){
        Context contex = getApplicationContext();
        int tempo = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contex,"CONTATO REMOVIDO",tempo);
        toast.show();
    }
    repositorioContato repositorio = new repositorioContato();
    EditText edtNome;
    EditText edtNumero;
    EditText edtNascimento;


    Spinner spinnerSexo;
    Button btnSalvar;

    Button btnDeletar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_contato);
        edtNome = findViewById(R.id.edtNome);
        edtNumero = findViewById(R.id.edtNumero);
        edtNascimento = findViewById(R.id.edtNascimento);
        spinnerSexo = findViewById(R.id.spinnerSexo);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnDeletar = findViewById(R.id.btnDeletar);



         final Contato contatoOld = (Contato) getIntent().getExtras().getSerializable("objeto");
         final  int id = (int) getIntent().getExtras().get("id");

        edtNome.setText(contatoOld.getNomeContato());
        edtNumero.setText(contatoOld.getNumeroContato());
        edtNascimento.setText(contatoOld.getIdadeContato());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sexo,android.R.layout.simple_spinner_item);
        spinnerSexo.setAdapter(adapter);

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nome,numero,nascimento,sexo;
                    nome = edtNome.getText().toString();
                    numero = edtNumero.getText().toString();
                    nascimento = edtNascimento.getText().toString();
                    sexo = spinnerSexo.getSelectedItem().toString();

                    Contato contatoNew = new Contato(nome, numero,sexo,nascimento);
                    repositorio.updateContato(contatoNew, id);

                }
            });
            btnDeletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    repositorio.dellContato(id);
                    isMain();
                    msn();
                }
            });


    }
}
