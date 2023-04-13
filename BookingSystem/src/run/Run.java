package run;

import mypage.MyPageView;

import static login.UserView.loginView;

public class Run {
    public static void main(String[] args) {
        MyPageView mypage=new MyPageView();
        loginView.joinStart();

        // 객체 이동 확인용 메소드
        mypage.viewUser();
    }
}
