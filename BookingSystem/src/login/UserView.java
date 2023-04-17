package login;

import memberShipUserSystem.MemberShipUserView;

import static login.Utility.*;

public class UserView {
    private static UserRepository repository;
    public static UserView loginView;
    MemberShipUserView msuv;

    static {
        loginView= new UserView();
        repository  = new UserRepository();

    }

    public  UserView() {
    }
    public void showOpening(){
        String s = "*****SEOUL 체육 시설 통합 예약 시스템에 오신걸 환영합니다*****";
        System.out.println("\n\n\n");
        try {
            dottedPrint(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void dottedPrint(String s) throws InterruptedException {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            Thread.sleep(100);
        }
        System.out.println();
    }



    public void inputUserinfo() {
        showOpening();
        System.out.println("");
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
                    msuv=new MemberShipUserView();
                    msuv.start();
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
//        System.out.println("==========시작시 memberShipUserInfo.sav 에서 로드되는 데이터=====");
//        for (Object o  : UserRepository.info) {
//            System.out.println(o+"\n");
//        }
//        System.out.println("============================================================");
//        System.out.println("");

        inputUserinfo();

    }

}
