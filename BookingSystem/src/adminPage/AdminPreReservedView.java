package adminPage;

import sportsFacArea.SelectedReserv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static login.Utility.*;

public class AdminPreReservedView {
    AdminRepository arp;
    List<SelectedReserv> userInfo;


    public void showPreList() {
        userInfo = new AdminRepository().loadReservationFile();
        for (int i = 0; i < userInfo.size(); i++) {
            SelectedReserv userObj = userInfo.get(i);
            System.out.println(i + 1 + ". " + userObj.info());
        }
        System.out.println("예약 승인 하려는 번호를 입력하세요");
        int preListNum = Integer.parseInt(input(">>"));
        SelectedReserv selectedReserv = userInfo.get(preListNum - 1);
        List<SelectedReserv> selectedList = new ArrayList<>();
        // 리스트에 추가
        selectedList.add(selectedReserv);
        // save함수 호출
        makeSelectedListSave(selectedList);

    }

    // 확인받은 예약을 저장하는 함수
    public void makeSelectedListSave(List<SelectedReserv> selectedList) { // 예약 리스트를 save파일에 저장하는 메서드
        try (FileOutputStream fos
                     = new FileOutputStream(
                "BookingSystem/src/saveFile/approvedList.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(selectedList);
            System.out.println("성공");
            for (SelectedReserv selectedReserv1 : selectedList) {
                System.out.println(selectedReserv1 + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println("오류");
        }
    }


}



