package login;


import static login.Utility.input;

/*
    * 1. 로그인할지 회원가입할지 선택하기 (1, 2번)
    *           [1. 로그인화면]
    * 1. 로그인 화면 콘솔창에 띄우기, (아이디만 입력받기)
    * 2. 아이디 입력 성공시 (ID_SUCCESS)
    * 2-1. 비밀번호 입력받기
    * 3. 아이디 입력 실패시 (ID_FAIL)
    * 3-1. 다시 아이디 입력받기
    * 4. 로그인 성공시 (LOGIN_SUCCESS)
    *
    *           [2. 회원가입화면]
    * 1. 필드들 입력받기
    *  */
public class UserView {

    private static UserRepository repository;

    static {
        repository = new UserRepository();
    }


    public void start(){ // 모든 메서드 모아서 출력
        while (true){
            System.out.println("        [ 메 인 화 면 ]");
            System.out.println("1. 로그인하기");
            System.out.println("2. 회원가입하기");

            String mainNum = input("번호 입력 >> ");
            switch (mainNum){ // 입력 받은 숫자가 1번이면 로그인화면, 2번이면 회원가입 화면
                case "1":
                    loginStart();
                    break;
                case "2":
                    joinStart();
                    break;
                default:
                    System.out.println("메뉴 번호로 입력해주세요");
            }

        }

    }

    private void loginStart() { // 로그인 화면 출력하기
        String inputId = input("# 아이디 입력 : ");
        String inputPwd = input("# 비밀번호 입력 : ");
        String s = repository.loginValidate(inputId, inputPwd);

    }

    private void joinStart() { // 회원가입 화면 출력하기

    }





}

