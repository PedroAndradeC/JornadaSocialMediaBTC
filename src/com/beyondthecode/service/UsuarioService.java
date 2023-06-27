package com.beyondthecode.service;

import com.beyondthecode.entity.User;
import com.beyondthecode.repository.UserRepository;

import java.util.List;

public class UsuarioService {
    private static UserRepository userRepository;

    public UsuarioService(){
        userRepository = new UserRepository();

    }
    //Salvar No banco
    public User salvarUserDB(User user)throws Exception{
        User usuarioSalvo = userRepository.salvarUserDB(user);
        return usuarioSalvo;
    }
    //Listar
    public List<User> listar(){
        List<User> listar = this.userRepository.listar();
        listar.stream().forEach(System.out::println);
        return listar;
    }
    //Editar
    public boolean editar(User user) throws Exception {
        return userRepository.editar(user);
    }
    //Excluir
    public boolean excluir(Integer id){
        return this.userRepository.excluir(id);
    }

    public void validarUser(User user){
    }
    public static User autenticarUsuario(String email, String senha) {
        User user = userRepository.buscarUsuarioPorEmail(email);
        if (user != null && user.getPassword().equals(senha)) {
            return user;
        }
        return null;
    }
    // Verificar se usuário está logado
    public boolean isUsuarioLogado() {
        return userRepository.isUsuarioLogado();
    }

    // Obter usuário logado
    public User getUsuarioLogado() {
        return userRepository.getUsuarioLogado();
    }

}
