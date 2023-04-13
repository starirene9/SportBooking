package mypage;

import login.Utility;
import sportsFacArea.BookingView;
import sportsFacArea.SelectedReserv;
import sportsFacArea.SportAreaRepository;
import userSys.UserInfo;

import static login.Utility.*;

public class MyPageView {

    private static userSys.UserRepository ur; // 회원정보
    private static SportAreaRepository sr; // 예약내역
    private static UserInfo myInfo; // 회원 정보 객체

    static {
        ur = new userSys.UserRepository();
        sr = new SportAreaRepository();
    }

    public static void start() {
        while (true) {
            showLoginSuccess();
            showMyPageMain();
            selectMenu();
        }
    }

    /*
    * 로그인 성공 후 보여지는 메인 화면
     */

    private static void showLoginSuccess(){
        System.out.println("==========[Menu]==========");
        System.out.println("#1 시설 예약하기");
        System.out.println("#2 Mypage로 이동");
        System.out.println("#0. 로그아웃");
        makeLine();

        String num;
        num=input(">>");
        switch (num){
            case "1":
                BookingView bookingView=new BookingView();
                bookingView.areaStart();
                break;
            case "2":
                myPageStart();
                break;
            case "0":
                login.UserView userView= new login.UserView();
                userView.inputUserinfo();
                break;
            default:
                System.out.println("번호를 정확하게 입력해주세요.");
                showLoginSuccess();
        }
    }

    /*
     * 마이페이지 스타트 구간
     */
    private static void myPageStart() {
        showMyPageMain();
        selectMenu();
    }

    /*
     * 마이페이지 메인 화면
     */
    private static void showMyPageMain() {
        System.out.println("=====[ My Page ]=====");
        System.out.println("1. 회원 정보 수정");
        System.out.println("2. 예약 내역 보기");
        makeLine();
    }

    /*
     * 마이페이지 선택 메뉴
     */
    private static void selectMenu() {
        String menuNum = input(">> ");

        switch (menuNum) {
            case "1":
                showMyInfo(); // 나의 정보 조회
                changeMyInfo(); // 나의 정보 수정
                myPageExit(); // 페이지 나가기
                break;

            case "2":
                seeMyBooking();
                break;

            default:
                System.out.println("\n# 올바른 번호를 입력해주세요.");
                selectMenu();
        }
    }

    /*
     * 수정 전 보여지는 기존 회원 정보
     */
    private static void showMyInfo() {
        System.out.println("\n# ====기존 회원 정보====");
        try {
            System.out.println("아이디 : "+ myInfo.getUserId());
            System.out.println("패스워드 : "+ myInfo.getUserPwd());
            System.out.println("이름 : "+ myInfo.getUserName());
            System.out.println("나이 : "+ myInfo.getUserAge());
            System.out.println("거주지 : "+ myInfo.getUserArea());
            System.out.println("전화번호 : "+ myInfo.getUserPhoneNum());
        } catch (Exception e) {
            System.out.println("기존 회원 정보가 없습니다.");
            e.printStackTrace();
        }

    }
    /*
     * 개인 정보 수정 받는 화면 : 아이디, 이름, 생년월일 제외한 비번, 전화번호,거주지
     */
    private static void changeMyInfo() {
        System.out.println("\n# 수정할 정보를 입력하세요.");
        String changeInfo = input(">> ");

        //회원에게 수정할 정보 입력받기
        System.out.printf(changeInfo + "변경을 선택하셨습니다.\n변경할 내용을 입력하세요.\n");
        String changedInfo = input(">> ");
        System.out.printf("%s님의 %s가 %s로 변경되었습니다. \n",myInfo.getUserName(),changeInfo, changedInfo);

        //저장하기

        //취소하기

    }

    /*
     * 예약 내역 보기
     */

    private static void seeMyBooking() {
        System.out.println("\n# 예약 내역 보기를 선택하셨습니다.");
        stop();
        //예약 내역 불러오기
        System.out.printf("=====[%s]님의 예약 내역=====", myInfo.getUserName());
        SelectedReserv selectedReserv=new SelectedReserv();
        selectedReserv.info();
        myPageExit(); //화면 나가기

    }

    /*
     * 메뉴 화면으로 돌아가기 혹은 마이페이지 선택지에 머무르는 화면
     */

    private static void myPageExit() {
        System.out.println("\n# 마이페이지를 나가시겠습니까? [ y/n ]");
        String answer = input(">> ");

        switch (answer.toLowerCase().charAt(0)) {
            case 'y':
            case 'ㅛ':
                System.out.println("메뉴 화면으로 돌아갑니다.");
                Utility.stop();
                showLoginSuccess();
                break;
            case 'n':
            case 'ㅜ':
                break;
        }

    }

    public static void loginInfo(UserInfo userInfo) {
        myInfo=userInfo;
    }

    public void viewUser(){
        System.out.println(myInfo);
        System.out.println("값 넘어갔습니다.");
    }



}
