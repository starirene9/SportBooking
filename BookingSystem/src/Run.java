import mypage.MyPageView;

import static login.UserView.loginView;

public class Run {
    public static void main(String[] args) {
        MyPageView mypage=new MyPageView();
        loginView.joinStart();
        mypage.viewUser();

    }
}
