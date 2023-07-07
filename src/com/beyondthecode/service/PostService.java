package com.beyondthecode.service;

import com.beyondthecode.entity.Post;
import com.beyondthecode.entity.User;
import com.beyondthecode.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

import static com.beyondthecode.view.Main.idToEdit;

public class PostService {
    private static PostRepository postRepository;
    private Post[] posts;

    public PostService() {
        postRepository = new PostRepository();
    }

    // Salvar no banco
    public Post salvarPost(Post post) throws Exception {
        Post postSalvo = postRepository.salvarPost(post);
        System.out.println("Post salvo! " + postSalvo);
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
        id = idToEdit;
        return postRepository.excluir(id);
    }
    public static int autenticarPost() {
        int postID = postRepository.buscarPostID();
        return postID;
    }

}



