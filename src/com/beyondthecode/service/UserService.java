package com.beyondthecode.service;

import com.beyondthecode.entity.User;
import com.beyondthecode.repository.UserRepository;

import java.util.List;

public class UserService {
    private static UserRepository userRepository;
    private static User usuarioLogado;
    private List<User> users;

    public UserService() {
        userRepository = new UserRepository();
    }

    // Salvar no banco
    public User salvarUserDB(User user) throws Exception {
        User usuarioSalvo = userRepository.salvarUserDB(user);
        return usuarioSalvo;
    }

    // Listar
    public List<User> listar() {
        List<User> listar = userRepository.listar();
        listar.stream().forEach(System.out::println);
        return listar;
    }

    // Editar
    public boolean editar(User user) throws Exception {
        return userRepository.editar(user);
    }

    // Excluir
    public boolean excluir(Integer id) throws Exception{
        return userRepository.excluir(id);
    }


    public static User autenticarUsuario(String email, String senha) {
        User user = userRepository.buscarUsuarioPorEmail(email);
        if (user != null && user.getPassword().equals(senha)) {
            return user;
        }
        return null;
    }
}
