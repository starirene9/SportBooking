package adminPage;

import userSys.UserInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class AdminRepository {



    public static void loadSaveFile() {
        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/reservationInfo.txt")) {
            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<UserInfo> userInfo = (List<UserInfo>) ois.readObject();
            for (UserInfo userObj : userInfo) {
//                info.add(userObj);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
