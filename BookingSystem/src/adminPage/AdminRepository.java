package adminPage;

import memberShipUserSystem.MemberShipUserInfo;
import sportsFacArea.SelectedReserv;

import java.io.*;
import java.util.List;

public class AdminRepository {
    List<SelectedReserv> userInfo;



    // 예약정보를 담은 save 파일을 로드하는 함수
    public List<SelectedReserv> loadReservationFile() {

        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/reservationInfo.txt")) {
            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
//             userInfo = (List<SelectedReserv>)ois.readObject();
//            ;
//            System.out.println(userInfo);
            System.out.println("여기");
            userInfo = (List<SelectedReserv>)ois.readObject();
            for (int i = 0; i < userInfo.size(); i++) {
                SelectedReserv userObj = userInfo.get(i);
                System.out.println(i+1+". "+userObj.info());
            }

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

    // 수락한 예약정보 객체를 save 하는 기능
    void saveAcceptReservation(){
        try(FileOutputStream oops=new FileOutputStream("BookingSystem/src/saveFile/acceptReservation.txt")){


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
