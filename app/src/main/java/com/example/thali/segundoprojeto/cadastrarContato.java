package com.example.thali.segundoprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class cadastrarContato extends AppCompatActivity {
    EditText edtNome;
    EditText edtTelefone;
    EditText edtNascimento;
    Spinner spinnerSexo;
    Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_contato);


        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        spinnerSexo = findViewById(R.id.spinnerSexo);
        edtNascimento =  findViewById(R.id.edtNascimento);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sexo,android.R.layout.simple_spinner_item);
        spinnerSexo.setAdapter(adapter);

            btnCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nome,telefone,sexo,idade;
                    nome = edtNome.getText().toString();
                    telefone = edtTelefone.getText().toString();
                    sexo = spinnerSexo.getSelectedItem().toString();
                    idade = edtNascimento.getText().toString();

                    Contato contato = new Contato(nome,telefone,sexo,idade);
                    repositorioContato repositorio = new repositorioContato();
                    repositorio.adicionarContato(contato);




                }
            });


    }
}
