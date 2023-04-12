package sportsFacArea;

import userSys.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class SportAreaRepository {

    static List<String> areaList;
    static SportsFacList sportList;
    private int areaListIndex;



    static {
        areaList = new ArrayList<>();
        areaList.add("강동구");
        areaList.add("강서구");
        areaList.add("강남구");
        areaList.add("강북구");
        sportList = new SportsFacList();
    }

    public void showArea(){
        for (int i = 0; i < areaList.size(); i++) {
            System.out.printf("%d. %s\n",i+1,areaList.get(i));
        }
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



}
