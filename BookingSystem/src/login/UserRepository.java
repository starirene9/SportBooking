package login;

import adminPage.AdminView;
import mypage.MyPageView;
import sportsFacArea.BookingView;
import userSys.UserInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private static List<UserInfo> info;
    UserView uv;
    public AdminView adminView;

    static {
        info = new ArrayList<>();
    }

    // userInfo load 함수

    public static void loadSaveFile() {
        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/userInfo.sav")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<userSys.UserInfo> userInfo = (List<UserInfo>) ois.readObject();
            for (UserInfo userObj : userInfo) {
                info.add(userObj);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void loginValidate(String inputId, String inputPwd) {

        UserInfo userInfo;
        try {
            userInfo = info.stream().filter(obj -> obj.getUserId().equals(inputId)).collect(Collectors.toList()).get(0);
            uv = new UserView();
            if (userInfo.getUserId().equals("admin") && userInfo.getUserPwd().equals("admin")) {
                System.out.println("관리자 계정으로 로그인 하였습니다.");
                adminView=new AdminView();
                adminView.adminMenu();
            } else if (userInfo.getUserId().equals(inputId) && userInfo.getUserPwd().equals(inputPwd)) {
                System.out.println("로그인이 완료되었습니다2.");
                userInfo = new UserInfo(userInfo.getUserId(), userInfo.getUserPwd(), userInfo.getUserName(), userInfo.getUserArea(), userInfo.getUserAge(), userInfo.getUserPhoneNum());
                MyPageView.loginInfo(userInfo);
                MyPageView mv = new MyPageView();
                mv.viewUser();
                MyPageView mypage = new MyPageView();
                BookingView bookingView=new BookingView();
                bookingView.loginInfo(userInfo);
                mypage.start();

            } else {
                System.out.println("아이디 비밀번호를 다시 입력하세요");
                uv.loginStart();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("존재하는 회원정보가 없습니다.");
        }


    }


}
