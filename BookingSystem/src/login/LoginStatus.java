package login;

public enum LoginStatus {
    ID_SUCCESS, // 아이디 입력 성공
    ID_FAIL, // 아이디 입력 실패
    PWD_FAIL, // 비밀번호 틀림, 틀려도 아이디 입력받지 않음
    LOGIN_SUCCESS, // 아이디, 비밀번호 성공
}
