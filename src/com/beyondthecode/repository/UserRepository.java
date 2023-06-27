package com.beyondthecode.repository;

import com.beyondthecode.entity.User;

import java.sql.*;

public class UserRepository {

    public User salvarUserDB(User user) {
        Connection connection = null;
        try {
            // abrir conexao
            connection = ConexaoDB.getConnection();

            // executar operacao
            String sqlSequence = "SELECT seq_user.nextval AS proxval FROM DUAL";
            Statement statement = connection.createStatement();
            ResultSet retorno = statement.executeQuery(sqlSequence);

            Integer proximoId = -1;
            if (retorno.next()) {
                proximoId = retorno.getInt("proxval");
            }

            String sql = "INSERT INTO USER (ID_USER, NAME, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

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
}