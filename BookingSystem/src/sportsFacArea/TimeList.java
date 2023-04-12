package sportsFacArea;

import java.util.ArrayList;
import java.util.List;

public class TimeList {

    public List<String> dateList;

    public TimeList() {
        dateList = new ArrayList<>(
                List.of("10:00 ~ 12:00",
                        "12:00 ~ 14:00",
                        "14:00 ~ 16:00",
                        "16:00 ~ 18:00",
                        "18:00 ~ 20:00",
                        "20:00 ~ 22:00"));
    }


    public void inform() {
        for (int i = 0; i < dateList.size(); i++) {
            System.out.printf("%d. [ %s ]\n", i + 1, dateList.get(i));
        }


    }

}

