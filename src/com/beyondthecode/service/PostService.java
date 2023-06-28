package com.beyondthecode.service;

import com.beyondthecode.entity.Post;
import com.beyondthecode.repository.PostRepository;

import java.util.List;

public class PostService {
    private static PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    // Salvar no banco
    public Post salvarPost(Post post) throws Exception {
        Post postSalvo = postRepository.salvarPost(post);
        return postSalvo;
    }

    // Listar
    public List<Post> listar() {
        List<Post> listar = postRepository.listar();
        listar.stream().forEach(System.out::println);
        return listar;
    }

    // Editar
    public boolean editar(Post post) throws Exception {
        return postRepository.editar(post);
    }

    // Excluir
    public boolean excluir(Integer id) throws Exception{
        return postRepository.excluir(id);
    }
}

