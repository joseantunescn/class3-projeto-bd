package cotiinformatica.services;

import cotiinformatica.entities.Pessoa;
import cotiinformatica.repositories.PessoaRepository;

import javax.crypto.spec.PSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService() {

        pessoaRepository = new PessoaRepository();

    }

    public void cadastrarPessoa() {
        var scanner = new Scanner(System.in);
        var pessoa = new Pessoa();

        System.out.println("\nInforme o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        System.out.println("\nInforme o CPF: ");
        pessoa.setCpf(scanner.nextLine());

        System.out.println("\nInforme a data de nascimento (dd/MM/yyyy): ");
        // pessoa.setDataNascimento(LocalDate.parse(scanner.nextLine()));
        var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        pessoa.setDataNascimento(
                LocalDate.parse(scanner.nextLine(), formato)
        );

        try {
            pessoaRepository.createPessoa(pessoa);
            System.out.println("Gravado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao gravar!");
            System.out.println(e.getMessage());
        }

    }

    public void atualizarPessoa() {
        var scanner = new Scanner(System.in);
        var pessoa = new Pessoa();

        System.out.println("\nInforme o id da pessoa: ");
        var id = Integer.parseInt(scanner.nextLine());

        System.out.println("\nInforme o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        System.out.println("\nInforme o CPF: ");
        pessoa.setCpf(scanner.nextLine());

        System.out.println("\nInforme a data de nascimento (dd/MM/yyyy): ");
        // pessoa.setDataNascimento(LocalDate.parse(scanner.nextLine()));
        var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        pessoa.setDataNascimento(
                LocalDate.parse(scanner.nextLine(), formato)
        );


        try {
            if(pessoaRepository.updatePessoa(pessoa)){
                System.out.printf("Pessoa com id %d atualizada com sucesso!", pessoa.getId());
                }
            else {
                System.out.println("Pessoa com id " + pessoa.getId() + " não encontrada!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao gravar!");
            System.out.println(e.getMessage());
        }

    }

    public void excluirPessoa() {
        var scanner = new Scanner(System.in);
        var pessoa = new Pessoa();

        System.out.println("\nInforme o id da pessoa: ");
        var id = Integer.parseInt(scanner.nextLine());

        try {
            if(pessoaRepository.deletePessoa(id)){
                System.out.printf("Pessoa excluída com sucesso!", pessoa.getId());
            }
            else {
                System.out.println("Pessoa com id " + pessoa.getId() + " não encontrada!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao gravar!");
            System.out.println(e.getMessage());
        }

    }

    public void consultarPessoa() {

        try {
            for (var pessoa : pessoaRepository.readPessoa()) {
                System.out.println("Id: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Data Nascimento: " + pessoa.getDataNascimento());
            }
        } catch (Exception e) {
            System.out.println("Erro ao gravar!");
            System.out.println(e.getMessage());

        }

    }


}
