package login;

public class UserRepository {
    RegisteredUserInfo info = new RegisteredUserInfo("abc", "1234");

    public UserRepository() {
    }

    public String loginValidate(String inputId, String inputPwd) throws LoginValidateException {
        if (this.info.getUserAccount().equals(inputId)) {
            if (this.info.getUserPassword().equals(inputPwd)) {
                return "로그인에 성공하셨습니다";
            } else {
                throw new LoginValidateException("아이디 혹은 비밀번호를 다시 입력하세요");
            }
        } else {
            throw new LoginValidateException("회원 가입을 진행하세요.");
        }
    }
}
