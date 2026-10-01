package cotiinformatica.repositories;

import cotiinformatica.entities.Pessoa;
import cotiinformatica.factories.ConnectionFactory;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    // atribute
    private ConnectionFactory connectionFactory;

    // method
    public PessoaRepository() {

        connectionFactory = new ConnectionFactory();

    }

    public void createPessoa(Pessoa pessoa) throws Exception {

        try(var connection = connectionFactory.createConnection()) {

            var statement = connection.prepareStatement("insert into class3.pessoas(nome, datanascimento, cpf) values(?,?,?)");
            statement.setString(1, pessoa.getNome());
            statement.setObject(2, pessoa.getDataNascimento());
            statement.setString(3, pessoa.getCpf());
            statement.execute();

        }

    }

    public List<Pessoa> readPessoa() throws Exception {

        try (var connection = connectionFactory.createConnection()) {

            var statement = connection.prepareStatement("select id, nome, cpf, datanascimento from class.pessoas order by id");
            var result = statement.executeQuery();
            var lista = new ArrayList<Pessoa>();

            //Percorrendo cada registro obtido do banco de dados
            while(result.next()) {

                var pessoa = new Pessoa();

                pessoa.setId(result.getInt("id"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setCpf(result.getString("cpf"));
                pessoa.setDataNascimento(result.getObject("datanascimento", LocalDate.class));

                lista.add(pessoa);
            }

            return lista;
        }

    }

    public boolean updatePessoa(Pessoa pessoa) throws Exception{

        try (var connection = connectionFactory.createConnection()) {

            var statement = connection.prepareStatement("update class.pessoas set nome=?, datanascimento=?, cpf=? where id=?");
            statement.setString(1, pessoa.getNome());
            statement.setObject(2, pessoa.getDataNascimento());
            statement.setString(3, pessoa.getCpf());
            statement.setInt(4, pessoa.getId());
            return statement.executeUpdate() > 0;



        }
    }

    public boolean deletePessoa(Integer id) throws Exception{
        try (var connection = connectionFactory.createConnection()) {

            var statement = connection.prepareStatement("delete from class.pessoas where id=?");
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }

    }

}
