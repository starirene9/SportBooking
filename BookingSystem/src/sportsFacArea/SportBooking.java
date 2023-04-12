package sportsFacArea;

public class SportBooking {

    private int bookingDay;
    private int timeInterval;
    private boolean isRent;
    private boolean isParking;

    public SportBooking() {
    }

    public SportBooking(int bookingDay, int timeInterval, boolean isRent, boolean isParking) {
        this.bookingDay = bookingDay;
        this.timeInterval = timeInterval;
        this.isRent = isRent;
        this.isParking = isParking;
    }

    public int getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(int bookingDay) {
        this.bookingDay = bookingDay;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public boolean isParking() {
        return isParking;
    }

    public void setParking(boolean parking) {
        isParking = parking;
    }
}
