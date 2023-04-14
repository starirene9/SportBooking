package sportsFacArea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportAreaRepository {

    static List<String> areaList;
    static SportsFacList sportList;
    static SelectedReserv reserv;
    private int areaListIndex;


    static {
        areaList = List.of("강남구", "강동구", "강북구", "강서구", "관악구", "구로구", "송파구", "마포구", "노원구", "종로구");
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

    public void showArea() {
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %d. %s\t\t", i + 1, areaList.get(i));
            System.out.printf(" %d. %s\n", i + 6, areaList.get(i + 4));
        }
    }

    public List<String> callListArea() {
        return areaList;
    }




}