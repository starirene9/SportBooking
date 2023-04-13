package adminPage;

import sportsFacArea.SelectedReserv;
import userSys.UserInfo;

import java.io.*;
import java.util.List;

public class AdminRepository {
    List<SelectedReserv> userInfo;



    // 예약정보를 담은 save 파일을 로드하는 함수
    public void loadReservationFile() {
        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/reservationInfo.txt")) {
            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
             userInfo = (List<SelectedReserv>) ois.readObject();
            System.out.println(userInfo);

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // 수락한 예약정보 객체를 save 하는 기능
    void saveAcceptReservation(){
        try(FileOutputStream oops=new FileOutputStream("BookingSystem/src/saveFile/acceptReservation.txt")){


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
