package sportsFacArea;

import login.UserInfo;

import java.util.Map;

import static login.Utility.input;

public class BookingView {

    static SportAreaRepository repository;
    static SportBooking booking;
    static DateList date;
    static UserInfo info;

    static {
        repository = new SportAreaRepository();
        booking = new SportBooking();
        date = new DateList();
        info = new UserInfo();
    }

    public void areaStart() { // 지역 정하기
        repository.showArea(); // 지역리스트 출력
        while (true) {
            try {
                int areaNum = Integer.parseInt(input("\n# 번호로 입력하세요>> "));
                repository.setAreaListIndex(areaNum);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다");
                continue;
//                e.printStackTrace();
            }
            sportStart();
        }
    }

    public void sportStart() { // 스포츠 종목 정하기
        System.out.println("1. 축구장");
        System.out.println("2. 농구장");
        System.out.println("3. 수영장");

        String sportNum = input("\n# 예약할 구장 선택하기>> ");
        switch (sportNum) {
            case "1":
                bookingFac(); // 예약 날짜 정하기
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                System.out.println("잘못된 입력입니다");
        }
    }

    public void bookingFac() { // 예약 날짜 정하기 메서드
        System.out.println("# 이용기간 5월");
        String inputDay = input("[ 1일 ~ 31일 ] 입력 >> ");
        if (Integer.parseInt(inputDay) > 31 || Integer.parseInt(inputDay) < 1){
            System.out.println("다시 입력하세요");
            bookingFac();
        }
        int inputTime = timeInterval(inputDay);

        boolean isRent = rentStuff();
        boolean isParking = parkCoupon();

        booking = new SportBooking(inputDay, inputTime, isRent, isParking);
        reservationInfo();

        confirmRes();


    }

    private void confirmRes() {
        String inputRes = input("예약 하시겠습니까? [y/n]");
        switch (inputRes.toUpperCase().charAt(0)){
            case 'Y':
                break;
            case 'N':
                break;
            default:
                System.out.println("잘못된 입력입니다");
                confirmRes();
        }

    }

    public void reservationInfo() {
        System.out.println("\n      [ 예약 정보 확인 ]");
        System.out.println("회원 이름 : "+info.getUserName());
        System.out.println("날짜 : 5월 "+booking.getBookingDay()+"일");
        System.out.println("예약한 시간 : "+date.callMap().get(booking.getBookingDay()).dateList.get(booking.getTimeIndex()-1));
        System.out.println("대여한 물품 유무 : "+booking.isRent());
        System.out.println("주차 쿠폰 유무 : "+booking.isParking());
    }

    public int timeInterval(String inputDay) { // 예약 시간 정하기 메서드
        System.out.println("\n5월 "+inputDay+"일 운영시간 [ 10:00 ~ 22:00 ] 2시간 단위");
        Map<String, TimeList> timeListMap = date.callMap();
        TimeList timeList = timeListMap.get(inputDay);
        timeList.inform(); // 예약 가능한 시간대 출력


        return Integer.parseInt(input("\n# 예약할 시간을 번호로 입력 >> "));
    }

    public boolean rentStuff() { // 대여물품 렌트 여부
        String inputRent = input("# 대여물품을 선택하시겠습니까? [y/n] ");
        boolean isRent = false;
        switch (inputRent.toUpperCase().charAt(0)) {
            case 'Y':
                isRent = true;
                break;
            case 'N':
                break;
            default :
                System.out.println("잘못된 입력입니다");
                rentStuff();
        }
        return isRent;
    }

    public boolean parkCoupon() { // 주차 유무 확인 후 쿠폰 지금
        String inputParking = input("# 주차 쿠폰을 발행하시겠습니까? [y/n] ");
        boolean isParking = false;
        switch (inputParking.toUpperCase().charAt(0)) {
            case 'Y' :
                isParking = true;
                break;
            case 'N' : break;
            default :
                System.out.println("잘못된 입력입니다");
                parkCoupon();
        }
        return isParking;
    }


}


