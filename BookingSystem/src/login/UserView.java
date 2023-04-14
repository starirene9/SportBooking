package login;

import memberShipUserSystem.MemberShipUserView;

import static login.Utility.*;

public class UserView {
    private static UserRepository repository;
    public static UserView loginView;

    static {
        loginView= new UserView();
        repository  = new UserRepository();

    }

    public  UserView() {
    }

    public void inputUserinfo() {
        while(true) {
            System.out.println("===========[ 메 인 화 면 ]===========");
            System.out.println("#1. 로그인하기");
            System.out.println("#2. 회원가입하기");
            String menuNum=input("번호 입력 >> ");
            System.out.println("");
            switch (menuNum) {
                case "1":
                    loginStart();
                    break;
                case "2":
                    MemberShipUserView.start();
                    break;
                default:
                    System.out.println("메뉴 번호로 입력해주세요");
            }
        }
    }

    public void loginStart() {
        System.out.println("===========[ 로 그 인 화 면 ]===========");
        String inputId = input("# 아이디 입력 : ");
        if(inputId.equals("")){
            System.out.println("값을 입력해주세요");
            loginStart();
        }
        String inputPwd = input("# 비밀번호 입력 : ");
        if(inputPwd.equals("")){
            System.out.println("값을 입력해주세요");
            loginStart();
        }

        repository.loginValidate(inputId,inputPwd);


    }

    public void joinStart() {

        repository.loadSaveFile();
        System.out.println("==========시작시 memberShipUserInfo.sav 에서 로드되는 데이터=====");
        for (Object o  : UserRepository.info) {
            System.out.println(o+"\n");
        }
        System.out.println("============================================================");
        System.out.println("");

        inputUserinfo();

    }

}
