package com.beyondthecode.entity.enums;

public enum Message {

  REGISTER_SUCCESS ("Usuário cadastrado com sucesso!"),
  REGISTER_FAIL("Email já cadastrado"),
  LOGIN_SUCCESS("Login realizado com sucesso!"),
  LOGIN_FAIL("Email ou senha incorretos!"),
  POST_SUCCESS("Post adicionado com sucesso"),
  POST_FAIL("Erro ao realizar operação"),
  POST_EDIT_SUCCESS("Post alterado com sucesso"),
  POST_EDIT_FAILED("Erro ao editar"),
  POST_EXCLUIR("Post excluido com sucesso"),
  POST_EXCLUIR_FAILED("Post não pertence a essa conta!");

  private final String message;

  Message(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }

}
