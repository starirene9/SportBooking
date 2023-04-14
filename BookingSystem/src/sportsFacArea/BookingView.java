package sportsFacArea;

import login.UserInfo;
import memberShipUserSystem.MemberShipUserInfo;
import sportsFacArea.sportrentlist.BasketRentList;
import sportsFacArea.sportrentlist.SoccerRentList;
import sportsFacArea.sportrentlist.SwimRentList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static login.Utility.input;

public class BookingView {

    static SportAreaRepository repository;
    static SportBooking booking;
    static DateList date;
    static UserInfo info;
    static SelectedReserv reserv;
    static SoccerRentList soccerRentList;
    static BasketRentList basketRentList;
    static SwimRentList swimRentList;

    static MemberShipUserInfo myInfo;

    static {
        repository = new SportAreaRepository();
        booking = new SportBooking();
        date = new DateList();
        info = new UserInfo();
        reserv = new SelectedReserv();
        soccerRentList = new SoccerRentList();
        myInfo=new MemberShipUserInfo();
//        myInfo = new userSys.UserInfo();
        basketRentList = new BasketRentList();
        swimRentList = new SwimRentList();
    }

    public void areaStart() { // 지역 정하기
        System.out.println("\n        [ 지역 예약 ]");
        repository.showArea(); // 지역리스트 출력
        while (true) {
            try {
                int areaNum = Integer.parseInt(input("\n# 번호로 입력하세요>> "));
                repository.setAreaListIndex(areaNum);
                reserv.setUserPlace(repository.callListArea().get(areaNum - 1));
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다");
                areaStart();
//                e.printStackTrace();
            }
            sportStart();
        }
    }

    public void sportStart() { // 스포츠 종목 정하기
        System.out.println("\n        [ 구장 예약 ]");
        System.out.println("1. 축구장");
        System.out.println("2. 농구장");
        System.out.println("3. 수영장");
        String sportNum = input("\n# 예약할 구장 선택하기>> ");
        switch (sportNum) {
            case "1":
                reserv.setUserSport("축구장");
                bookingFac(); // 예약 날짜 정하기
                break;
            case "2":
                reserv.setUserSport("농구장");
                bookingFac(); // 예약 날짜 정하기
                break;
            case "3":
                reserv.setUserSport("수영장");
                bookingFac(); // 예약 날짜 정하기
                break;
            default:
                System.out.println("잘못된 입력입니다");
                sportStart();
        }
    }

    public void bookingFac() { // 예약 날짜 정하기 메서드
        System.out.println("# 이용기간 5월");
        String inputDay = input("[ 1일 ~ 31일 ] 입력 >> ");
        try {
            if (Integer.parseInt(inputDay) > 31 || Integer.parseInt(inputDay) < 1) {
                System.out.println("다시 입력하세요");
                bookingFac();
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다");
            bookingFac();
        }

        int inputTime = timeInterval(inputDay);

        boolean isRent = rentStuff();
        boolean isParking = parkCoupon();

        booking = new SportBooking(inputDay, inputTime, isRent, isParking);

        insertWaitList(inputDay, inputTime, isRent, isParking); // 예약 정보들 리스트에 담아두는 메서드
        reservationInfo(); // 예약 정보 출력
//        System.out.println(reserv); // 테스트용 예약 대기리스트
        confirmRes(); // 마지막으로 예약 할 것인지 물어보는 메서드


    }

    private void insertWaitList(String inputDay, int inputTime, boolean isRent, boolean isParking) { // 예약 대기리스트에 담는 메서드
        reserv.setUserDate(inputDay);
        reserv.setUserTimeIndex(inputTime);
        reserv.setRent(isRent);
        reserv.setParking(isParking);
        reserv.setUserTime(date.callMap().get(booking.getBookingDay()).dateList.get(booking.getTimeIndex() - 1));
    }

    private void confirmRes() { // 마지막으로 예약을 할 것인지 물어보는 메서드
        String inputRes = input("예약 하시겠습니까? [y/n] ");
        switch (inputRes.toUpperCase().charAt(0)) {
            case 'Y':
                repository.makeSaveFile();
                break;
            case 'N':
                break;
            default:
                System.out.println("잘못된 입력입니다");
                confirmRes();
        }

    }

    public int ageDisCount(){
        if (Integer.parseInt(myInfo.getUserAge().substring(0,2)) < 25) return 10;
        return 0;
    }
    public int placeDisCount(){
        if (myInfo.getUserArea().equals(reserv.getUserPlace())) return 10;
        return 0;
    }

    public void reservationInfo() { // 예약 정보들 출력 메서드
        System.out.println("\n      [ 예약 정보 확인 ]");
        reserv.setUserName(myInfo.getUserName());
        System.out.println(reserv.info());
        int ageDiscount = ageDisCount();
        int placeDiscount = placeDisCount();
        int count = 0;
        int allTotal = 0;
        switch (reserv.getUserSport()) {
            case "축구장":
                count = soccerRentList.rentCount(); // 대여한 물품의 개수 출력 메서드
                allTotal = soccerRentList.rentTotal(); // 대여한 물품들의 가격 계산 메서드
                break;
            case "농구장":
                count = basketRentList.rentCount(); // 대여한 물품의 개수 출력 메서드
                allTotal = basketRentList.rentTotal(); // 대여한 물품들의 가격 계산 메서드
                break;
            case "수영장":
                count = swimRentList.rentCount(); // 대여한 물품의 개수 출력 메서드
                allTotal = swimRentList.rentTotal(); // 대여한 물품들의 가격 계산 메서드
                break;
        }
//        int total = allTotal - (allTotal / ageDiscount) + allTotal - (allTotal / placeDiscount);
        ageDiscount=5;
        placeDiscount=5;
        int total = (allTotal - (allTotal / ageDiscount)) + (allTotal - (allTotal / placeDiscount));
        System.out.println(total);
        reserv.setUserTotal(total);
        System.out.printf("총 대여한 물품의 개수 : %d개\n", count);
        System.out.printf("총 대여한 물품의 가격 : %d원\n", allTotal);
        System.out.printf("총 금액 : %d원\n", reserv.getUserTotal());
    }

    public int timeInterval(String inputDay) { // 예약 시간 정하기 메서드
        System.out.println("\n5월 " + inputDay + "일 운영시간 [ 10:00 ~ 22:00 ] 2시간 단위");
        Map<String, TimeList> timeListMap = date.callMap();
        TimeList timeList = timeListMap.get(inputDay);
        timeList.inform(); // 예약 가능한 시간대 출력
        int inputTime = 0;
        try {
            inputTime = Integer.parseInt(input("\n# 예약할 시간을 번호로 입력 >> "));
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다");
            timeInterval(inputDay);
        }
        return inputTime;
    }

    public boolean rentStuff() { // 대여물품 렌트 여부
        String inputRent = input("# 대여물품을 선택하시겠습니까? [y/n] ");
        boolean isRent = false;
        switch (inputRent.toUpperCase().charAt(0)) {
            case 'Y':
                isRent = true;
                if (reserv.getUserSport().equals("축구장"))
                    soccerRentList.soccerRentList(); // 축구장 렌트 물품 보여주는 메서드
                else if (reserv.getUserSport().equals("농구장"))
                    basketRentList.basketRentList(); // 축구장 렌트 물품 보여주는 메서드
                else if (reserv.getUserSport().equals("수영장"))
                    swimRentList.swimRentList(); // 수영장 렌트 물품 보여주는 메서드
                break;
            case 'N':
                break;
            default:
                System.out.println("잘못된 입력입니다");
                rentStuff();
        }
        return isRent;
    }

//    private void soccerRentList() { // 축구장 렌트할 물건 보여주고 입력받기
//        System.out.println("1. 축구 유니폼 [개당 1000원]");
//        System.out.println("2. 축구화 [개당 2000원]");
//        System.out.println("3. 축구공 [개당 1000원]");
//        System.out.println("4. 종료");
//
//        String inputRentNum = input("# 빌릴 물건을 번호로 입력하세요 >> ");
//        try {
//            switch (inputRentNum){
//                case "1":
//                    soccerRentList.setSoccerUniform(Integer.parseInt(input("빌릴 유니폼의 갯수를 입력하세요 >> ")));
//                    soccerRentList();
//                    break;
//                case "2":
//                    soccerRentList.setSoccerShoes(Integer.parseInt(input("빌릴 축구화 갯수를 입력하세요 >> ")));
//                    soccerRentList();
//                    break;
//                case "3":
//                    soccerRentList.setSoccerBall(Integer.parseInt(input("빌릴 축구공 갯수를 입력하세요 >> ")));
//                    soccerRentList();
//                    break;
//                case "4":
//                    break;
//                default:
//                    System.out.println("잘못된 입력입니다");
//                    soccerRentList();
//            }
//        }catch (NumberFormatException e){
//            System.out.println("잘못된 입력입니다");
//            soccerRentList();
//        }
//
//    }

    public boolean parkCoupon() { // 주차 유무 확인 후 쿠폰 지금
        String inputParking = input("# 주차 쿠폰을 발행하시겠습니까? [y/n] ");
        boolean isParking = false;
        switch (inputParking.toUpperCase().charAt(0)) {
            case 'Y':
                isParking = true;
                break;
            case 'N':
                break;
            default:
                System.out.println("잘못된 입력입니다");
                parkCoupon();
        }
        return isParking;
    }


    public static void loadSaveFile() {
        try (FileInputStream fis
                     = new FileInputStream(
                "BookingSystem/src/saveFile/reservationInfo.txt")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<MemberShipUserInfo> object = (List<MemberShipUserInfo>) ois.readObject();
//            userInfo = object;
//            System.out.println("로드 성공");
//            System.out.println(userInfo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void loginInfo(MemberShipUserInfo userInfo) {
        myInfo=userInfo;
    }

    public void viewUser() {
        System.out.println(myInfo);
        System.out.println("값 넘어갔습니다. kh");
    }


}


