package entities;

import javax.swing.*;

public class Aluno {
    private Spring nome;
    private Integer idade;
    private Double matricula;
    private String curso;

    public Aluno(String curso, Double matricula, Integer idade, Spring nome) {
        this.curso = curso;
        this.matricula = matricula;
        this.idade = idade;
        this.nome = nome;
    }
    public Aluno(){

    }

    public Spring getNome() {
        return nome;
    }

    public void setNome(Spring nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getMatricula() {
        return matricula;
    }

    public void setMatricula(Double matricula) {
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
        return "Aluno{" +
                "nome=" + nome +
                ", idade=" + idade +
                ", matricula=" + matricula +
                ", curso='" + curso + '\'' +
                '}';
    }
}

