package sportsFacArea;

import java.util.ArrayList;
import java.util.List;

public class SportAreaRepository {

    static List<String> areaList;
    static SportsFacList sportList;
    private int areaListIndex;



    static {
        areaList = List.of("강동구", "강서구","강남구","강북구");
        sportList = new SportsFacList();
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


}