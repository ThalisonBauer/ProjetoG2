package com.example.thali.segundoprojeto;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thali on 05/12/2017.
 */

public  class repositorioContato {
        private static List<Contato> contatos = new ArrayList<>();

            public static List<Contato> getContatos(){
                return contatos;
            }

            public static void adicionarContato(Contato contato){
                contatos.add(contato);
            }
            public static void updateContato(Contato contatoNew, Contato contatoOld){
                contatos.remove(contatoOld);
                contatos.add(contatoNew);
            }
            }
