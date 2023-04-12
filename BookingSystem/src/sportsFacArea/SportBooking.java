package sportsFacArea;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SportBooking {

    private String bookingDay;
    private int timeIndex;
    private boolean isRent;
    private boolean isParking;

    static List<String> times;

    static {
        times = List.of(
                "10:00 ~ 12:00",
                "12:00 ~ 14:00",
                "14:00 ~ 16:00",
                "16:00 ~ 18:00",
                "18:00 ~ 20:00",
                "20:00 ~ 22:00"
        );
    }

    public SportBooking() {}

    public SportBooking(String bookingDay, int timeInterval, boolean isRent, boolean isParking) {
        this.bookingDay = bookingDay;
        this.timeIndex = timeInterval;
        this.isRent = isRent;
        this.isParking = isParking;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public int getTimeIndex() {
        return timeIndex;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    public void setTimeIndex(int timeIndex) {
        this.timeIndex = timeIndex;
    }

    public boolean isParking() {
        return isParking;
    }

    public void setParking(boolean parking) {
        isParking = parking;
    }


}