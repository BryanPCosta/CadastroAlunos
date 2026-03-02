package entities;

import javax.swing.*;

public class Aluno {
    private String nome;
    private Integer idade;
    private Integer matricula;
    private String curso;

    public Aluno(String nome, Integer idade, Integer matricula, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.curso = curso;


    }
    public Aluno(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return
                "nome=" + nome +
                ", idade=" + idade +
                ", matricula=" + matricula +
                ", curso='" + curso + '\'' +
                '}';
    }
}

