package sportsFacArea;

import java.util.List;

public class AreaList {
    static List<String> area;

    static {
        SportsFacList sportsFacilityList = new SportsFacList("축구장","농구장","수영장");

//        area=new HashMap<>();

    }

    public static void main(String[] args) {

        System.out.println(area.toString());
    }
}
