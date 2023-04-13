package sportsFacArea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SportAreaRepository {

    static List<String> areaList;
    static SportsFacList sportList;
    static SelectedReserv reserv;
    private int areaListIndex;



    static {
        areaList = List.of("강동구", "강서구","강남구","강북구");
        sportList = new SportsFacList();
        reserv = new SelectedReserv();
    }



    public SportAreaRepository() {
    }

    public SportAreaRepository(int areaListIndex) {
        this.areaListIndex = areaListIndex;
    }

    public int getAreaListIndex() {
        return areaListIndex;
    }

    public void setAreaListIndex(int areaListIndex) {
        this.areaListIndex = areaListIndex;
    }

    public void showArea(){ // 지역구 리스트 출력하기
        for (int i = 0; i < areaList.size(); i++) {
            System.out.printf("%d. %s\n",i+1,areaList.get(i));
        }
    }
    public List<String> callListArea(){
        return areaList;
    }

    public void makeSaveFile() { // 예약 리스트를 save파일에 저장하는 메서드
        try (FileOutputStream fos
                     = new FileOutputStream(
                "BookingSystem/src/saveFile/reservationInfo.txt")) {
            List<SelectedReserv> list = new ArrayList<>();
            list.add(reserv);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("성공");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (RuntimeException e){
            System.out.println("오류");
        }
    }


}