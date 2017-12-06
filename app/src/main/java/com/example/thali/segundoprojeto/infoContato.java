package com.example.thali.segundoprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class infoContato extends AppCompatActivity {
    repositorioContato repositorio = new repositorioContato();
    EditText edtNome;
    EditText edtNumero;
    EditText edtNascimento;


    Spinner spinnerSexo;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_contato);
        edtNome = findViewById(R.id.edtNome);
        edtNumero = findViewById(R.id.edtNumero);
        edtNascimento = findViewById(R.id.edtNascimento);
        spinnerSexo = findViewById(R.id.spinnerSexo);
        btnSalvar = findViewById(R.id.btnSalvar);



        final Contato contatoOld = (Contato) getIntent().getExtras().getSerializable("objeto");


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
                    repositorio.updateContato(contatoNew, contatoOld);

                }
            });


    }
}
