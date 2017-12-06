package com.example.thali.segundoprojeto;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapterContato extends BaseAdapter {
    List<Contato> contatos;
    Context context;



    @Override
            public int getCount(){

        return contatos.size();
        }
        @Override
            public Object getItem(int position){

                return contatos.get(position);
        }
        @Override
            public  long getItemId(int position){
                return position;
            };
        @Override
            public View getView(int position, View ConvertView, ViewGroup parent){
            View resultView = LayoutInflater.from(context).inflate(R.layout.item_contato,parent,false);
            TextView txtViewNome  = resultView.findViewById(R.id.txtViewNome);
            TextView txtViewNumero =  resultView.findViewById(R.id.txtViewNumero);

            Contato contato = contatos.get(position);
            txtViewNome.setText(contato.getNomeContato());
            txtViewNumero.setText(contato.getNumeroContato());

            return resultView;
        }
}
