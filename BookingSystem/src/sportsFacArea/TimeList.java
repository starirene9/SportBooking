package sportsFacArea;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class TimeList extends ArrayList<TimeList> {

    public List<String> dateList;

    public TimeList() {
        dateList = new ArrayList<>();
                 dateList.add("10:00 ~ 12:00");
                 dateList.add("12:00 ~ 14:00");
                 dateList.add("14:00 ~ 16:00");
                 dateList.add("16:00 ~ 18:00");
                 dateList.add("18:00 ~ 20:00");
                 dateList.add("20:00 ~ 22:00");

    }



    public void inform() {
        for (int i = 0; i < dateList.size(); i++) {
            System.out.printf("%d. [ %s ]\n", i + 1, dateList.get(i));
        }


    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public Stream<TimeList> stream() {
        return super.stream();
    }

    @Override
    public Stream<TimeList> parallelStream() {
        return super.parallelStream();
    }
}

