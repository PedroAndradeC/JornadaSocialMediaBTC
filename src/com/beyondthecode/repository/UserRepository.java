package com.beyondthecode.repository;

import com.beyondthecode.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private User usuarioLogado;
    public User salvarUserDB(User user) {
        Connection connection = null;
        try {
            // abrir conexao
            connection = ConexaoDB.getConnection();

            // executar operacao
            String sqlSequence = "SELECT usuario_seq.nextval AS proxval FROM DUAL";
            Statement statement = connection.createStatement();
            ResultSet retorno = statement.executeQuery(sqlSequence);

            Integer proximoId = -1;
            if (retorno.next()) {
                proximoId = retorno.getInt("proxval");
            }

            String sql = "INSERT INTO usuario (ID_USER, NOME, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, proximoId);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());

            int resposta = preparedStatement.executeUpdate();
            System.out.println("salvarUserDB.resposta = " + resposta);

            user.setId(proximoId);
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar conexao
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<User> listar(){
        List<User> listaUsuarios = new ArrayList<>();
        // abrir conexao
        Connection connection = null;
        try{
            connection = ConexaoDB.getConnection();
            String sql = "SELECT * FROM JORNADA.USUARIO";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()) {
                User user = new User();
                user.setId(res.getInt("id_user"));
                user.setName(res.getString("nome"));
                user.setEmail(res.getString("email"));
                listaUsuarios.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return listaUsuarios;
    }
    public boolean editar(User user) {
        UserRepository userRepository = new UserRepository();
        Connection connection = null;
        try {
            // abrir conexao
            connection = ConexaoDB.getConnection();

            int idUsuario = 0;
            if (userRepository.isUsuarioLogado()) {
                User usuarioLogado = userRepository.getUsuarioLogado();
                idUsuario = usuarioLogado.getId();
            }
            // update
            String sql = "UPDATE usuario SET " +
                    "nome = ?, " +
                    "email = ?, " +
                    "senha = ? " +
                    "WHERE id_user = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, idUsuario);

            //executar
            int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar conexao
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    //Excluir
    public boolean excluir(Integer id) {
        Connection connection = null;
        try {
            connection = ConexaoDB.getConnection();

            String sql = "delete from jornada where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally {
            // fechar conexao
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    //Login Busca
    public User buscarUsuarioPorEmail(String email) {
        Connection connection = null;
        try {
            // Abrir conexão
            connection = ConexaoDB.getConnection();

            // Consulta SQL
            String sql = "SELECT * FROM JORNADA.USUARIO WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);

            // Executar consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Extrair os dados do resultado
                int id = resultSet.getInt("ID_USER");
                String nome = resultSet.getString("NOME");
                String senha = resultSet.getString("SENHA");

                // Criar um objeto User com os dados obtidos
                User user = new User();
                user.setId(id);
                user.setName(nome);
                user.setEmail(email);
                user.setPassword(senha);

                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Fechar conexão
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return null; // Retorna null se nenhum usuário for encontrado
    }
    public User getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }
}
