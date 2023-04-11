package userSys;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository implements Serializable {
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
        UserRepository.userInfo.add(userInfo);
    }

    /**
     * @return true : 중복, false: 중복되지않는다.
     * @param1 회원가입시 입력한 아이디
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
    /** save파일 생성
     *
     */
    public static void makeSaveFile(){

      try(FileOutputStream fos
                  = new FileOutputStream(
              "C:\\Study\\SportBooking2\\BookingSystem\\src\\saveFile"+ "/snack.sav"))
      {   ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(userInfo);
          System.out.println("save 성공");
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    }
    public static void loadSaveFile(){
        try (FileInputStream fis
                     = new FileInputStream(
                "C:\\Study\\SportBooking2\\BookingSystem\\src\\saveFile"+ "/snack.sav")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<UserInfo> object = (List<UserInfo>) ois.readObject();
            userInfo = object;
            System.out.println("로드 성공");
            System.out.println(userInfo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
