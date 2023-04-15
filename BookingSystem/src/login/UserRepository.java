package login;

import adminPage.AdminView;
import mypage.MyPageView;
import sportsFacArea.BookingView;
import memberShipUserSystem.MemberShipUserInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static memberShipUserSystem.Utility.input;

public class UserRepository {
    public static List<MemberShipUserInfo> info;
    UserView uv;
    AdminView adminView;
    UserView userview;
    MemberShipUserInfo userInfo;

    static {
//        info = new ArrayList<>();
    }

    // userInfo load 함수
    public  List<MemberShipUserInfo> loadSaveFile() {
        info = new ArrayList<>();
        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/memberShipUserInfo.sav")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<MemberShipUserInfo> userInfo = (List<MemberShipUserInfo>) ois.readObject();
            for (MemberShipUserInfo userObj : userInfo) {
                info.add(userObj);

            }
            System.out.println(info + "불러옴");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return info;
        }
    }

    /**
     * 로그인시 입력한 값이 save 파일의 정보와 비교하여
     * 알맞은 회원정보인지 확인하고 맞을 경우 다른 페이지로
     * 정보와 함께 이동시키는 기능
     *
     * @param inputId  입력한 아이디
     * @param inputPwd 입력한 비밀번호
     */
    public void loginValidate(String inputId, String inputPwd) {
        loadSaveFile();
//        List<MemberShipUserInfo> collect = info.stream().distinct().collect(Collectors.toList());
//        info=collect;
        try {

            userInfo = info.stream().filter(obj -> obj.getUserId().equals(inputId)).collect(Collectors.toList()).get(0);

            System.out.println("======로그인 하는 사람의 계정====");
            System.out.println(userInfo);
            System.out.println("===========================\n");

            uv = new UserView();
            if (userInfo.getUserId().equals("admin") && userInfo.getUserPwd().equals("admin")) {
                System.out.println("관리자 계정으로 로그인 하였습니다.");
                System.out.println("");
                adminView = new AdminView();
                adminView.adminMenu();
            } else if (userInfo.getUserId().equals(inputId) && userInfo.getUserPwd().equals(inputPwd)) {
                System.out.println("");
                System.out.printf("[%s]님 환영합니다!!!\n", userInfo.getUserName());
                // 로그인한 계정의 정보를 객체화
                userInfo = new MemberShipUserInfo(userInfo.getUserId(), userInfo.getUserPwd(), userInfo.getUserName(), userInfo.getUserArea(), userInfo.getUserAge(), userInfo.getUserPhoneNum());

                //  MyPageView 클래스로 객체정보를 넘김
                MyPageView.loginInfo(userInfo);

//                // 객체 이동 확인용 메소드
//                MyPageView mv = new MyPageView();
//                mv.viewUser();

                //  BookingView 클래스로 객체정보를 넘김
                BookingView bookingView = new BookingView();
                bookingView.loginInfo(userInfo);

                // mypage로 이동하는 기능
                MyPageView mypage = new MyPageView();
                mypage.start();

            } else {
                System.out.println("아이디 비밀번호를 다시 입력하세요");
                // 로그인 실패시 다시 로그인 화면을 띄어주는 기능
                uv.loginStart();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("존재하는 회원정보가 없습니다.");
            whileloop:
            while (true) {
                String back = input("처음화면으로 돌아가시겠습니까?[Y/N]");
                uv = new UserView();
                switch (back.toUpperCase().charAt(0)) {
                    case 'Y':
                        uv.inputUserinfo();
                        break whileloop;
                    case 'N':
                        uv.loginStart();
                        break whileloop;
                    default:
                        System.out.println("정확한 값을 입력해주세요");
                }
            }
            userview = new UserView();
            // 로그인 실패시 다시 로그인 화면을 띄어주는 기능
            userview.loginStart();
        }


    }


}
