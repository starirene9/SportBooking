package sportsFacArea;

import java.util.HashMap;
import java.util.Map;

public class SportsFacList {

    static Map<String, Map<String,TimeList>> sportList;
    static DateList dateList;

    static {
        dateList = new DateList();
        sportList = new HashMap<>();
        sportList.put("축구장",dateList.callMap());
        sportList.put("농구장",dateList.callMap());
        sportList.put("수영장",dateList.callMap());
    }

    public Map<String,Map<String,TimeList>> callMapSport(){
        return sportList;
    }

}
