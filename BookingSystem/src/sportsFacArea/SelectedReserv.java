package sportsFacArea;

import java.io.Serializable;

public class SelectedReserv implements Serializable {

    private String userName;
    private String userSport;
    private String userPlace;
    private String userDate;
    private String userTime;
    private int userTimeIndex;
    private int userTotal;
    private boolean isRent;
    private boolean isParking;

    public SelectedReserv() {}

    public SelectedReserv(String userName, String userSport, String userPlace, String userDate, String userTime, int userTimeIndex, int userTotal, boolean isRent, boolean isParking) {
        this.userName = userName;
        this.userSport = userSport;
        this.userPlace = userPlace;
        this.userDate = userDate;
        this.userTime = userTime;
        this.userTimeIndex = userTimeIndex;
        this.userTotal = userTotal;
        this.isRent = isRent;
        this.isParking = isParking;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSport() {
        return userSport;
    }

    public void setUserSport(String userSport) {
        this.userSport = userSport;
    }

    public String getUserPlace() {
        return userPlace;
    }

    public void setUserPlace(String userPlace) {
        this.userPlace = userPlace;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public int getUserTimeIndex() {
        return userTimeIndex;
    }

    public void setUserTimeIndex(int userTimeIndex) {
        this.userTimeIndex = userTimeIndex;
    }

    public int getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    public boolean isParking() {
        return isParking;
    }

    public void setParking(boolean parking) {
        isParking = parking;
    }

    @Override
    public String toString() {
        return "SelectedReserv[ " +
                "userName : '" + userName + '\'' +
                ", userSport : '" + userSport + '\'' +
                ", userPlace : '" + userPlace + '\'' +
                ", userDate : '" + userDate + '\'' +
                ", userTime : '" + userTime + '\'' +
                ", userTimeIndex : " + userTimeIndex +
                ", userTotal : " + userTotal +
                ", isRent : " + isRent +
                ", isParking : " + isParking +
                " ]";
    }
    public String info(){
        return String.format("회원이름 : %s\t| 지역 : 서울시 %s\t| 체육시설 : %s\t| 예약날짜 : 5월 %s일\t| 예약시간 : %s (2시간)\t| 총 결제 금액 : %d원"
                , userName,userPlace,userSport,userDate,userTime,userTotal);
    }

}
