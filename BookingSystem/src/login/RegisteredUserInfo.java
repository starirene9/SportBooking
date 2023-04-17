package login;
// 등록된 유저들의 로그인 아이디 비번 확인용

public class RegisteredUserInfo {
    String userAccount;
    String userPassword;

    public RegisteredUserInfo(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

