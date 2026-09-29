package cotiinformatica.repositories;

import cotiinformatica.entities.Pessoa;

import java.sql.DriverManager;

public class PessoaRepository {

    public void createPessoa(Pessoa pessoa) {

        try{

            var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/bd-pessoas", "coti", "coti");
            var statement = connection.prepareStatement("insert into class3.pessoas(nome, datanascimento, cpf) values(?,?,?)");
            statement.setString(1, pessoa.getNome());
            statement.setObject(2, pessoa.getDataNascimento());
            statement.setString(3, pessoa.getCpf());
            statement.execute();

            connection.close();

            System.out.println("\nPessoa cadastrada com sucesso");

        }
        catch (Exception e){
            System.out.println("\nFalha ao inserir pessoa");
            System.out.println(e.getMessage());
        }

    }

    public void readPessoa(Pessoa pessoa) {

    }

    public boolean updatePessoa(Pessoa pessoa) {
        return false;

    }

    public boolean deletePessoa(Integer id) {
        return false;

    }

}
