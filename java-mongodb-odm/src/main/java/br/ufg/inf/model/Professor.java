package br.ufg.inf.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professores")
public class Professor {
    
    @Id
    private String id;
    private String nomeCompleto;
    private String dataDeNascimento;
    private String nivelPos;
    private double salario;

    public Professor() {}

    public Professor(String nomeCompleto, String dataDeNascimento, String nivelPos, double salario) {
        this.nomeCompleto = nomeCompleto;
        this.dataDeNascimento = dataDeNascimento;
        this.nivelPos = nivelPos;
    }

    public String getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNivelPos() {
        return nivelPos;
    }

    public void setNivelPos(String nivelPos) {
        this.nivelPos = nivelPos;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }
}
