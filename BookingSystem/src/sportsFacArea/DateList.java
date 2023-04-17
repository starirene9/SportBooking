package sportsFacArea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateList {
    private static Map<String, TimeList> dateList;

    static {

        dateList = new HashMap<>();

        dateList.put("1", new TimeList());
        dateList.put("2", new TimeList());
        dateList.put("3", new TimeList());
        dateList.put("4", new TimeList());
        dateList.put("5", new TimeList());
        dateList.put("6", new TimeList());
        dateList.put("7", new TimeList());
        dateList.put("8", new TimeList());
        dateList.put("9", new TimeList());
        dateList.put("10", new TimeList());
        dateList.put("11", new TimeList());
        dateList.put("12", new TimeList());
        dateList.put("13", new TimeList());
        dateList.put("14", new TimeList());
        dateList.put("15", new TimeList());
        dateList.put("16", new TimeList());
        dateList.put("17", new TimeList());
        dateList.put("18", new TimeList());
        dateList.put("19", new TimeList());
        dateList.put("20", new TimeList());
        dateList.put("21", new TimeList());
        dateList.put("22", new TimeList());
        dateList.put("23", new TimeList());
        dateList.put("24", new TimeList());
        dateList.put("25", new TimeList());
        dateList.put("26", new TimeList());
        dateList.put("27", new TimeList());
        dateList.put("28", new TimeList());
        dateList.put("29", new TimeList());
        dateList.put("30", new TimeList());
        dateList.put("31", new TimeList());

    }

    public DateList() {}

    public Map<String, TimeList> callMap(){
        return dateList;
    }



}

