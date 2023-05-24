package entities;

public enum CheckLogin {

    CHECK_LOGIN ("Email e/ou password inválido(s)!");

    private String checkLogin;

    CheckLogin (String checkLogin) {
        this.checkLogin = checkLogin;
    }

    public String getCheckLogin() {
        return checkLogin;
    }
}
