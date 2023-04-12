package login;

public class UserRepository {

    public String loginValidate(String inputId, String inputPwd) throws LoginValidateException {
        //아이디가 같고
        if(UserInfo.getUserId().equals(inputId)) {
            //패스워드도 같으면
            if(UserInfo.getUserPwd().equals(inputPwd)) {
                return "로그인에 성공하셨습니다.";
            } else {
                throw new LoginValidateException("아이디 혹은 비밀번호를 다시 입력하세요");
            }
        }  else {
            throw new LoginValidateException("회원 가입을 진행하세요.");
        }
    }
}
