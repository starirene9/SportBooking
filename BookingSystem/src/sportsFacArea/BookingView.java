package sportsFacArea;

import static login.Utility.input;

public class BookingView {

    static SportAreaRepository repository;
    static SportBooking booking;

    static {
        repository = new SportAreaRepository();
        booking = new SportBooking();
    }

    public void areaStart(){ // 지역 정하기
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

    public void sportStart(){ // 스포츠 종목 정하기
        System.out.println("1. 축구장");
        System.out.println("2. 농구장");
        System.out.println("3. 수영장");

        String sportNum = input("\n# 예약할 구장 선택하기>> ");
        switch (sportNum){
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
        System.out.println("# 이용기간 4월");
        int inputDay = Integer.parseInt(input("[ 1일 ~ 30일 ] 입력 >> "));
        int inputTime = timeInterval();
        String inputRent = input("# 대여물품을 선택하시겠습니까? [y/n] ");
        boolean isRent = inputRent.toUpperCase().charAt(0) == 'Y';
        String inputParking = input("# 주차 쿠폰을 발행하시겠습니까? [y/n] ");
        boolean isParking = inputParking.toUpperCase().charAt(0) == 'Y';

        booking = new SportBooking(inputDay, inputTime,isRent,isParking);
//        System.out.println(inputDay+" "+inputTime+" "+inputRent+" "+inputParking);
    }
    public int timeInterval(){ // 예약 시간 정하기 메서드
        System.out.println("운영시간 [ 10:00 ~ 22:00 ] 2시간 단위");
        System.out.println("1. [ 10:00 ~ 12:00]");
        System.out.println("2. [ 12:00 ~ 14:00]");
        System.out.println("3. [ 14:00 ~ 16:00]");
        System.out.println("4. [ 16:00 ~ 18:00]");
        System.out.println("5. [ 18:00 ~ 20:00]");
        System.out.println("6. [ 20:00 ~ 22:00]");

        return Integer.parseInt(input("\n# 예약할 시간을 번호로 입력 >> "));
    }

}
