package main;

import services.AlunoService;
import entities.Aluno;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlunoService alunoService = new AlunoService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarAluno(alunoService, scanner);
                    break;
                case 2:
                    listarAlunos(alunoService);
                    break;
                case 3:
                    buscarAluno(alunoService, scanner);
                    break;
                case 4:
                    atualizarAluno(alunoService, scanner);
                    break;
                case 5:
                    removerAluno(alunoService, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE ALUNOS ===");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Buscar por matrícula");
        System.out.println("4 - Atualizar aluno");
        System.out.println("5 - Remover aluno");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarAluno(AlunoService service, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        Integer idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Matrícula: ");
        Integer matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, idade, matricula, curso);
        service.adicionar(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos(AlunoService service) {
        List<Aluno> alunos = service.listarTodos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\nLista de alunos:");
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        }
    }

    private static void buscarAluno(AlunoService service, Scanner scanner) {
        System.out.print("Digite a matrícula: ");
        Integer matricula = scanner.nextInt();
        Aluno aluno = service.buscarPorMatricula(matricula);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void atualizarAluno(AlunoService service, Scanner scanner) {
        System.out.print("Matrícula do aluno a atualizar: ");
        Integer matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno alunoAtualizado = new Aluno();
        System.out.print("Novo nome: ");
        alunoAtualizado.setNome(scanner.nextLine());
        System.out.print("Nova idade: ");
        alunoAtualizado.setIdade(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Novo curso: ");
        alunoAtualizado.setCurso(scanner.nextLine());

        if (service.atualizar(matricula, alunoAtualizado)) {
            System.out.println("Aluno atualizado!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void removerAluno(AlunoService service, Scanner scanner) {
        System.out.print("Matrícula do aluno a remover: ");
        Integer matricula = scanner.nextInt();
        if (service.remover(matricula)) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}