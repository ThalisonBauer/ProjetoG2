package com.example.thali.segundoprojeto;

/**
 * Created by thali on 05/12/2017.
 */

public class Contato {
    private String nomeContato;
    private String numeroContato;
    private String sexoContato;
    private String idadeContato;

    public Contato(String nomeContato, String numeroContato, String sexoContato, String idadeContato){
                this.nomeContato = nomeContato;
                this.numeroContato = numeroContato;
                this.sexoContato = sexoContato;
                this.idadeContato = idadeContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public String getSexoContato() {
        return sexoContato;
    }

    public void setSexoContato(String sexoContato) {
        this.sexoContato = sexoContato;
    }

    public String getIdadeContato() {
        return idadeContato;
    }

    public void setIdadeContato(String idadeContato) {
        this.idadeContato = idadeContato;
    }
}
