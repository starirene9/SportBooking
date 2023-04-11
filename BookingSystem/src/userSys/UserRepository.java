package userSys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private static List<UserInfo> userInfo;

    static {
        userInfo = new ArrayList<>(
                Arrays.asList(new UserInfo("abcd", "1234", "짱구", "강남구", "990101", "01011111111"))
        );
    }

    /**
     * @param1 회원가입시 입력된 정보들의 객체
     * 회원가입시 입력된 정보들을 repository에 저장하는 함수
     */
    public void register(UserInfo userInfo) {
        this.userInfo.add(userInfo);
    }

    /**
     * @param1 회원가입시 입력한 아이디
     * @return true : 중복, false: 중복되지않는다.
     */
    public boolean isDuplicate(String userId) {
        for (UserInfo info : userInfo) {
            if (info.getUserId().equals(userId))
                return true;
        }
        return false;
    }

    // 현재 저장된 모든 객체의 정보를 보여주는 함수
    public void showList(){
        for (UserInfo info : userInfo) {
            System.out.println(info);
        }
    }


}
