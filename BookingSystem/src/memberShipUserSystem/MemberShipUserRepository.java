package memberShipUserSystem;



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberShipUserRepository implements Serializable {
    static List<MemberShipUserInfo> userInfo;

    static {
        userInfo = new ArrayList<>(
                Arrays.asList(new MemberShipUserInfo("admin", "admin", "관리자", "", "", ""))
        );
    }



    public static void upDateInfo(MemberShipUserInfo myInfo) {

        MemberShipUserInfo upDateInfo = userInfo.stream().filter(t -> t.getUserId().equals(myInfo.getUserId())).collect(Collectors.toList()).get(0);


        System.out.println(upDateInfo);
        System.out.println("2222");
        // id가 중복되는 객체를 지운다.
        userInfo.remove(upDateInfo);
        System.out.println("객체를 지운 후 ");
        System.out.println(userInfo);
        // 그리고 이객체를넣는다.
        userInfo.add(myInfo);
        System.out.println("객체를 넣고난 후");
        System.out.println(userInfo);
        // 그리고 세이브

        // 로드하여 확인


    }

    /**
     * @param userInfo 회원가입시 입력된 정보들의 객체
     *                 회원가입시 입력된 정보들을 repository에 저장하는 함수
     */
    void register(MemberShipUserInfo userInfo) {
//        List<MemberShipUserInfo> beforeList = loadMemberShipFile();
//        System.out.println(beforeList);
//        beforeList.add(userInfo);

//        MemberShipUserRepository.userInfo.add(userInfo);
//        System.out.println(beforeList);
        newLoad(userInfo);

    }



// 이전 계정들을 로드하는 기능
    public List<MemberShipUserInfo> loadMemberShipFile() {

        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/memberShipUserInfo.sav")) {
            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
//             userInfo = (List<SelectedReserv>)ois.readObject();
//            ;
//            System.out.println(userInfo);

            userInfo = (List<MemberShipUserInfo>)ois.readObject();

        } catch (FileNotFoundException ex) {
            System.out.println("파일이 존재하지 않습니다.");
            ex.printStackTrace();
        } catch (IOException e) {
            System.out.println("에러1");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("에러2");
            e.printStackTrace();
        }
        return userInfo;
    }









    // 수정되기전 객체를 userInfo 에서 찾아서 지우는 기능
    public void deleteUserInfo(MemberShipUserInfo myInfo) {
        loadMemberShipFile();
        for (int i =  userInfo.size()-1; i >=0; i--) {
            if(userInfo.get(i).getUserId().equals(myInfo.getUserId())){
                userInfo.remove(userInfo.get(i));
            }
        }
        userInfo.add(myInfo);

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
        makeSaveFile();

    }





    // 수정후 객체를 userInfo 에 추가하는 기능
    public void newLoad(MemberShipUserInfo myInfo) {
        loadMemberShipFile();
        userInfo.add(myInfo);
//        for (MemberShipUserInfo memberShipUserInfo : userInfo) {
//            System.out.println(memberShipUserInfo);
//        }

        makeSaveFile();
    }

    /**
     * @param userId 회원가입시 입력한 아이디
     * @return true : 중복, false: 중복되지않는다.
     */
    boolean isDuplicate(String userId) {
       loadMemberShipFile();
//        System.out.println(userInfo);
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
    public  void makeSaveFile() {

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
