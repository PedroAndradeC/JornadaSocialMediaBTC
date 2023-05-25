package com.beyondthecode.enums;

public enum Message {

  REGISTER_SUCCESS ("Usuário cadastrado com sucesso!"),
  REGISTER_FAIL("Email já cadastrado"),
  LOGIN_SUCCESS("Login realizado com sucesso!"),
  LOGIN_FAIL("Email ou senha incorretos!"),
  POST_SUCCESS("Post adicionado com sucesso"),
  POST_FAIL("Erro ao realizar operação"),
  POST_CHANGE("Post alterado com sucesso"),
  POST_EXCLUIR("Post excluido com sucesso");

  private final String message;

  Message(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }

}
