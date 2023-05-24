package enums;

public enum Message {

  REGISTER_SUCCESS ("Usuário cadastrado com sucesso!"),
  REGISTER_FAIL("Email já cadastrado"),
  LOGIN_SUCCESS("Login realizado com sucesso!"),
  LOGIN_FAIL("Email ou senha incorretos!");

  private final String message;

  Message(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }

}
