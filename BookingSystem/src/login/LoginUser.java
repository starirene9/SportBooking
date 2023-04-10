package login;

public class LoginUser {
    private String userId; // 로그인 아이디
    private String userPwd; // 로그인 비밀번호

    public LoginUser() {}

    public LoginUser(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "LoginUser[" +
                "userId : '" + userId + '\'' +
                ", userPwd : '" + userPwd + '\'' +
                ']';
    }
}
