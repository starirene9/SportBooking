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

    // 수정되기전 객체를 userInfo 에서 찾아서 지우는 기능
    public void deleteUserInfo(MemberShipUserInfo myInfo) {
        for (int i =  userInfo.toArray().length-1; i >=0; i--) {
            if(userInfo.get(i).getUserId().equals(myInfo.getUserId())){
                userInfo.remove(userInfo.get(i));
            }
        }

//        for (MemberShipUserInfo checkInfo : userInfo) {
//            if(checkInfo.getUserId().equals(myInfo.getUserId())){
//                userInfo.remove(checkInfo);
//            }
//        }
        System.out.println("=============지운후 리스트의 정보============");
        for (MemberShipUserInfo memberShipUserInfo : userInfo) {
            System.out.println(memberShipUserInfo + "\n");
        }
        System.out.println("==========================================");

    }

    // 수정후 객체를 userInfo 에 추가하는 기능
    public void newLoad(MemberShipUserInfo myInfo) {
        userInfo.add(myInfo);
        for (MemberShipUserInfo memberShipUserInfo : userInfo) {
            System.out.println(memberShipUserInfo);
        }

        makeSaveFile();
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
            System.out.println(info+"\n");
        }
    }


    // userInfo save 파일 생성 함수
    public static void makeSaveFile() {

        try (FileOutputStream fos
                     = new FileOutputStream(
                "BookingSystem/src/saveFile/memberShipUserInfo.sav")) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userInfo);
            System.out.println("=============save 후 리스트의 정보============");
            for (MemberShipUserInfo memberShipUserInfo : userInfo) {
                System.out.println(memberShipUserInfo + "\n");
            }
            System.out.println("==========================================");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
