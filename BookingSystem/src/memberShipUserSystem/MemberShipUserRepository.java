package memberShipUserSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberShipUserRepository implements Serializable {
    static List<MemberShipUserInfo> userInfo;

    static {
        userInfo = new ArrayList<>(
                Arrays.asList(new MemberShipUserInfo("admin", "admin", "관리자", "", "", ""))
        );
    }

    /**
     * @param userInfo 회원가입시 입력된 정보들의 객체
     *                 회원가입시 입력된 정보들을 repository에 저장하는 함수
     */
    void register(MemberShipUserInfo userInfo) {
        MemberShipUserRepository.userInfo.add(userInfo);
    }


    /**
     * @param userId 회원가입시 입력한 아이디
     * @return true : 중복, false: 중복되지않는다.
     */
    boolean isDuplicate(String userId) {
        for (MemberShipUserInfo info : userInfo) {
            if (info.getUserId().equals(userId))
                return true;
        }
        return false;
    }

    // 현재 저장된 모든 객체의 정보를 보여주는 함수
    public void showList() {
        for (MemberShipUserInfo info : userInfo) {
            System.out.println(info);
        }
    }


    // userInfo save 파일 생성 함수
    public static void makeSaveFile() {

        try (FileOutputStream fos
                     = new FileOutputStream(
                "BookingSystem/src/saveFile/memberShipUserInfo.sav")) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userInfo);
//            System.out.println("save 성공");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
