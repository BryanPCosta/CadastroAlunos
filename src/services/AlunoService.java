package services;

import entities.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {
    private List<Aluno> alunos = new ArrayList<>();

    public void Adicioar (Aluno aluno){
        alunos.add(aluno);

    }
    public List<Aluno> listarTodos(){
        return alunos;

    }
    public Aluno buscarPorMatricula(Double matricula){
        for(Aluno a : alunos){
            if(a.getMatricula().equals(matricula)){
                return a;
            }
        }

    return null;

    }

    public boolean atualizar(Double matricula, Aluno dadosAtualizado){
        for(Aluno aluno : alunos){
            if(aluno.getMatricula().equals(matricula)){
                aluno.setNome(dadosAtualizado.getNome());
                aluno.setCurso(dadosAtualizado.getCurso());
                aluno.setIdade(dadosAtualizado.getIdade());
            }
        }
        return false;
    }

    public boolean remover(double matricula){
        for(Aluno aluno : alunos){
            if (aluno.getMatricula().equals(matricula)){
                alunos.remove(aluno);
            }
        }
        return false;
    }
}
