package services;

import entities.Aluno;
import java.util.List;
import java.util.ArrayList;

public class AlunoService {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public Aluno buscarPorMatricula(Integer matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null; // não encontrou
    }

    public boolean atualizar(Integer matricula, Aluno dadosAtualizado) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                aluno.setNome(dadosAtualizado.getNome());
                aluno.setCurso(dadosAtualizado.getCurso());
                aluno.setIdade(dadosAtualizado.getIdade());
                return true; // achou e atualizou
            }
        }
        return false; // não encontrou
    }

    public boolean remover(Integer matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return alunos.remove(aluno); // remove e retorna true/false
            }
        }
        return false; // não encontrou
    }
}