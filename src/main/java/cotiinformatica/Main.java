package cotiinformatica;

import cotiinformatica.services.PessoaService;

import java.lang.classfile.constantpool.InterfaceMethodRefEntry;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        System.out.println("\nPROJETO BD\n");

        System.out.println("(1) Cadastrar pessoa");
        System.out.println("(2) Atualizar pessoa");
        System.out.println("(3) Excluir pessoa");
        System.out.println("(4) Consultar pessoa");

        var scanner = new Scanner(System.in);
        var pessoaService = new PessoaService();

        System.out.println("\nEscolha uma opção: ");

        var opcao = Integer.parseInt(scanner.nextLine());

        switch(opcao) {
            case 1:
                System.out.println("\nCadastro de pessoa\n");
                // var pessoaService = new PessoaService();
                pessoaService.cadastrarPessoa();

            case 2:
                System.out.println("\nAtualização de pessoa\n");
                break;

            case 3:
                System.out.println("\nExclusão de pessoa\n");
                break;

            case 4:
                System.out.println("\nConsulta de pessoa\n");
                break;

            default:
                System.out.println("\nOpção inválida\n");

        }
    }
}
