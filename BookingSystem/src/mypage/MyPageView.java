package mypage;

import login.Utility;
import sportsFacArea.BookingView;
import sportsFacArea.SelectedReserv;
import sportsFacArea.SportAreaRepository;
import memberShipUserSystem.MemberShipUserRepository;
import memberShipUserSystem.MemberShipUserInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static login.Utility.*;
import static memberShipUserSystem.MemberShipUserView.checkPhoneNum;
import static memberShipUserSystem.MemberShipUserView.stringLength;
import static memberShipUserSystem.Utility.input;

public class MyPageView {

    private static MemberShipUserRepository ur; // 회원정보
    private static SportAreaRepository sr; // 예약내역
    private static MemberShipUserInfo myInfo; // 회원 정보 객체
    static List<String> areaList = List.of("강남구", "강동구", "강북구", "강서구", "관악구", "구로구", "송파구", "마포구", "노원구", "종로구");

    static List<SelectedReserv> approved;

    static {
        ur = new MemberShipUserRepository();
        sr = new SportAreaRepository();
        myInfo = new MemberShipUserInfo();
    }

    public void start() {
        while (true) {
            showLoginSuccess();
            selectMenu();
        }
    }

    /*
     * 로그인 성공 후 보여지는 메인 화면
     */

    public void showLoginSuccess() {
        System.out.println("==========[Menu]==========");
        System.out.println("#1 시설 예약하기");
        System.out.println("#2 Mypage로 이동");
        System.out.println("#0. 로그아웃");
        makeLine();
        String num;
        num = input(">>");
        switch (num) {
            case "1":
                BookingView bookingView = new BookingView();
                bookingView.areaStart();
                break;
            case "2":
                selectMenu();
                break;
            case "0":
                login.UserView userView = new login.UserView();
                userView.inputUserinfo();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                showLoginSuccess();
        }
    }


    /*
     * 마이페이지 선택 메뉴
     */
    private void selectMenu() {
        System.out.println("=====[ My Page ]=====");
        System.out.println("1. 회원 정보 수정");
        System.out.println("2. 예약 내역 보기");
        makeLine();
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
                System.out.println("\n# 잘못된 입력입니다. ");
                selectMenu();
        }
    }

    /*
     * 수정 전 보여지는 기존 회원 정보
     */
    private static void showMyInfo() {
        System.out.println("\n# ====회원 정보====");

        System.out.println("아이디 : " + myInfo.getUserId());
        System.out.println("비밀번호 : " + myInfo.getUserPwd());
        System.out.println("이름 : " + myInfo.getUserName());
        System.out.println("생년월일 : " + myInfo.getUserAge());
        System.out.println("거주지 : " + myInfo.getUserArea());
        System.out.println("전화번호 : " + myInfo.getUserPhoneNum());


    }


    /*
     * 개인 정보 수정 받는 화면 : 아이디, 이름, 생년월일 제외한 비번, 전화번호,거주지
     */
    private static void changeMyInfo() {
        System.out.println("\n#수정할 정보의 번호를 입력하세요.\n1. 비밀번호 2. 거주지 3. 전화번호");
        String choice = input(">> ");

        //회원에게 수정할 정보 입력 받고 변경 하는 기능
        switch (choice) {
            case "1":
                System.out.println("새로운 비밀번호를 입력하세요.");
                String newPwd;
                while (true) {
                    newPwd = input("# 비밀번호(8자리 이상) : ");
                    // 비밀번호 글자수 13이하로 제한
                    if (stringLength(newPwd, 7,20)) {
                        break;
                    } else {
                        System.out.println("8자리 이상 입력해주세요");
                    }
                }
                myInfo.setUserPwd(newPwd);
//                System.out.println("========수정후 객체정보======");
//                System.out.println(myInfo + "/n");
//                System.out.println("===========================");
                //userInfo에저장된 객체를 지우는 기능
                ur.deleteUserInfo(myInfo);
                System.out.println("비밀번호가 변경되었습니다.");
                showMyInfo();
                break;
            case "2":
                System.out.println("새로운 거주지를 입력하세요.(1번~10번)");
                showArea();
//                String newPlace = input(">> ");
                int areaNum = Integer.parseInt(Utility.input("\n# 번호로 입력하세요>> "));
                String userArea = callListArea().get(areaNum - 1);



                myInfo.setUserArea(userArea );
//                System.out.println("========수정후 객체정보======");
//                System.out.println(myInfo + "/n");
//                System.out.println("===========================");
                //userInfo에저장된 객체를 지우는 기능
                ur.deleteUserInfo(myInfo);
                System.out.println("거주지가 변경되었습니다.");
                showMyInfo();
                break;
            case "3":
                System.out.println("새로운 전화번호를 입력하세요.");
                String newPhone;

                while (true) {
                    newPhone = input("# 핸드폰 번호(-포함) : ");
                    // 올바른 값 확인
                    if (checkPhoneNum(newPhone)) {
                        break;
                    }
                }
                myInfo.setUserPhoneNum(newPhone);

//                System.out.println("========수정후 객체정보======");
//                System.out.println(myInfo + "/n");
//                System.out.println("===========================");

                //userInfo 에저장된 객체를 지우는 기능
                ur.deleteUserInfo(myInfo);
                System.out.println("전화번호가 변경되었습니다.");
                showMyInfo();
                break;
            default:
                System.out.println("\n# 잘못된 입력입니다.");
                changeMyInfo();
        }

    }

    public static void showArea() {
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %d. %s\t\t", i + 1, areaList.get(i));
            System.out.printf(" %d. %s\n", i + 6, areaList.get(i + 5));
        }
    }

    public static List<String> callListArea() {
        return areaList;
    }


    /*
     * 예약 내역 보기
     */

    private void seeMyBooking() {
        System.out.println("\n# 예약 내역 보기를 선택하셨습니다.");
//        stop();
        //예약 내역 불러오기
        System.out.printf("=======[%s]님의 예약 완료 내역=======\n", myInfo.getUserName());
        List<SelectedReserv> approvedList = loadApprovedList();
//        System.out.println(approvedList);
        for (SelectedReserv app : approvedList) {
            if(app.getUserName().equals(myInfo.getUserName())){
                System.out.println(app.info());

            }
        }


//        for (SelectedReserv app : loadApprovedList()) {
//            System.out.println(app.info());
//        }
        myPageExit(); //화면 나가기

    }


    public List<SelectedReserv> loadApprovedList() {
        List<SelectedReserv> userInfo = new ArrayList<>();
        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/approvedList.txt")) {
            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
//             userInfo = (List<SelectedReserv>)ois.readObject();
//            ;
//            System.out.println(userInfo);
//            System.out.println("여기");
            userInfo = (List<SelectedReserv>)ois.readObject();

        } catch (FileNotFoundException ex) {
//            System.out.println("파일이 존재하지 않습니다.");
//            ex.printStackTrace();
        } catch (IOException e) {
//            System.out.println("에러1");
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
//            System.out.println("에러2");
//            e.printStackTrace();
        }
        return userInfo;
    }

    /*
     * 메뉴 화면으로 돌아가기 혹은 마이페이지 선택지에 머무르는 화면
     */

    private void myPageExit() {
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
                seeMyBooking();
                break;
            default:
                System.out.println("올바른 값을 입력해주세요");
                myPageExit();
        }

    }

    public static void loginInfo(MemberShipUserInfo userInfo) {
        myInfo = userInfo;
    }


}
