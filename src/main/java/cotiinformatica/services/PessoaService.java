package cotiinformatica.services;

import cotiinformatica.entities.Pessoa;
import cotiinformatica.repositories.PessoaRepository;

import javax.crypto.spec.PSource;
import java.time.LocalDate;
import java.util.Scanner;

public class PessoaService {

    private void cadastrarPessoa() {
        var scanner = new Scanner(System.in);
        var pessoa = new Pessoa();

        System.out.println("\nInforme o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        System.out.println("\nInforme o CPF: ");
        pessoa.setCpf(scanner.nextLine());

        System.out.println("\nInforme a data de nascimento (yyyy-mm-dd): ");
        pessoa.setDataNascimento(LocalDate.parse(scanner.nextLine()));

        var pessoaRepository = new PessoaRepository();
        pessoaRepository.createPessoa(pessoa);
    }

}
