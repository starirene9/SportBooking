package userSys;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository implements Serializable {
    public static List<UserInfo> userInfo;

    static {
        userInfo = new ArrayList<>(
                Arrays.asList(new UserInfo("admin", "admin", "관리자", "", "", ""))
        );
    }

    /**
     * @param userInfo 회원가입시 입력된 정보들의 객체
     *                 회원가입시 입력된 정보들을 repository에 저장하는 함수
     */
    public void register(UserInfo userInfo) {
        UserRepository.userInfo.add(userInfo);
    }

    /**
     * @param userId 회원가입시 입력한 아이디
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
    public void showList() {
        for (UserInfo info : userInfo) {
            System.out.println(info);
        }
    }


    // userInfo save 파일 생성 함수
    public static void makeSaveFile() {

        try (FileOutputStream fos
                     = new FileOutputStream(
                "C:\\Study\\SportBooking2\\BookingSystem\\src\\saveFile" + "/userInfo.sav")) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userInfo);
//            System.out.println("save 성공");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
