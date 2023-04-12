package mypage;

import login.UserInfo;
import login.UserRepository;
import login.Utility;
import sportsFacArea.SportAreaRepository;
import sportsFacArea.SportBooking;

import static login.Utility.*;

public class MyPageView {

    private static userSys.UserRepository ur; // 회원정보
    private static SportAreaRepository sr; // 예약내역

    static {
        ur = new userSys.UserRepository();
        sr = new SportAreaRepository();
    }

    public static void start() {

        while (true) {
            showMainScreen();
            selectMenu();
        }
    }

    private static void showMainScreen() {
        System.out.println("=====회원정보 수정=====");
        System.out.println("1. 회원 정보 수정");
        System.out.println("2. 예약 내역 보기");
        makeLine();
    }


    private static void selectMenu() {
        String menuNum = input(">> ");

        switch (menuNum) {
            case "1":
                showMyInfo(); // 나의 정보 조회
                changeMyInfo(); // 나의 정보 수정
                break;

            case "2":
                seeMyBooking(); // 예약 내역 보기
                break;

            default:
                System.out.println("\n# 번호를 똑바로 입력해주세요.");
        }
    }

    private static void showMyInfo() {
        System.out.println("\n# ====기존 회원 정보====");
        //회원 정보 보여주기
    }

    private static void changeMyInfo() {
        System.out.println("\n# 수정할 정보를 입력하세요.");
        String changeInfo = input(">> ");

        //회원에게 수정할 정보 입력받기
        System.out.printf(changeInfo + "변경을 선택하셨습니다.\n변경 할 내용을 입력하세요.");
        String changedInfo = input(">> ");
        System.out.printf("%s님의 %s가 %s로 변경되었습니다. \n", , changeInfo, changedInfo);

        //저장하기 :

    }

    private static void seeMyBooking() {
        System.out.println("\n# 예약 내역 보기를 선택하셨습니다.");
        //예약 내역 불러오기
        System.out.printf("\n=====%s님의 예약 내역=====", );
        myPageExit(); //화면 나가기

    }

    private static void myPageExit() {
        System.out.println("\n# 화면을 나가시겠습니까?[y/n]");
        String answer = input(">> ");

        switch (answer.toLowerCase().charAt(0)) {
            case 'y':
            case 'ㅛ':
                System.out.println("종료합니다.");
                break;
            case 'n':
            case 'ㅜ':
                System.out.println("예약 내역 정보로 돌아갑니다.");
                seeMyBooking();
                break;
        }

    }

    public userInfo loginInfo(userInfo user) { // 객체로 넘겨 받아서 get해서 쓰면 됨
        return userInfo=user;
    }


}
