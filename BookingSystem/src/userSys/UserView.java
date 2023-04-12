package userSys;

import java.text.SimpleDateFormat;

import static userSys.Utility.*;

public class UserView {
    public static UserView uv;
    UserInfo userInfo;
    private static UserRepository urp;


    static {
        uv = new UserView();
        urp = new UserRepository();
    }

    private void joinMemberShip() {
        System.out.println("==========[ 회 원 가 입 ]==========");

        // 아이디 입력
        String userId;
        while (true) {
            userId = input("# 아이디 : ");

            // 아이디 중복검사
            if (urp.isDuplicate(userId)) {
                System.out.println("아이디 중복입니다. 다시 입력해주세요");
            } else {
                if (!userId.equals("")) {
                    System.out.println("입력 가능한 아이디 입니다.");
                    break;
                } else {
                    System.out.println("값을 입력해주세요");
                }
            }
        }

        // 비밀번호 입력
        String userPwd;
        while (true) {
            userPwd = input("# 비밀번호 : ");
            // 비밀번호 글자수 10이하로 제한
            if (stringLength(userPwd, 10)) {
                break;
            } else {
                System.out.println("비밀번호가 너무 깁니다. 10이하로 적어주세요");
            }
        }
        // 이름 입력
        String userName = input("# 이름 : ");

        // 거주지 입력
        System.out.println("거주지를 입력하세요");
        System.out.println("강남구 // 강동구 // 강서구 // 광진구 // 구로구 // 동대문구 // 동작구 //\n해당 구에 거주하시는 분은 혜택을 받으실수있습니다.");
        String userArea = input("# 거주지 입력(ex 서울특별시 강남구): ");

        // 전화번호 입력
        String userPhoneNum;
        while (true) {
            userPhoneNum = input("# 핸드폰 번호 : ");
            // 올바른 값 확인 && 글자수 제한
            if (isIntNum(userPhoneNum) && stringLength(userPhoneNum, 11)) {
                break;
            }
        }

        //생년월일 입력
        String userAge;

        while (true) {
            userAge = input("생년월일(6자리) : ");
            // 올바른 값 확인 && 글자수 제한
            if (checkDate(userAge)) {
                break;
            } else {
                System.out.println("올바른값을 입력해주세요(6자리)");
            }
        }


        // 객체생성
        userInfo = new UserInfo(userId, userPwd, userName, userArea, userPhoneNum, userAge);

        // UserRepository 에저장
        urp.register(userInfo);

    }

    /**
     * String 을 int 로 치환하는 함수
     *
     * @param userAge 확인하고싶은 String값
     * @return true 모두 숫자이다.
     * false 숫자로 바꿀수 없는 값이 있다.
     */
    boolean isIntNum(String userAge) {

        try {
            int num = Integer.parseInt(userAge);
            return true;
        } catch (NumberFormatException ex) {
            ex.getStackTrace();
            System.out.println("올바른 값을 입력해주세요");
            return false;
        }

    }

    /**
     * 글자수를 제한하는 함수
     *
     * @param s      : String 타입 변수
     * @param length : 제한하고 싶은 글자수
     * @return 글자수가 제한글자수를 초과할시 false;
     * 글자수가 제한글자수보다 작을시 true;
     */
    boolean stringLength(String s, int length) {
        if (s.length() > length) {
            System.out.printf("%d 자리 이하로 입력해주세요\n", length);
            return false;
        }
        return true;
    }

    void start() {

        joinMemberShip();
        urp.showList();
    }

    /**
     * 올바른 생년월일 인지 검사하는 기능
     *
     * @param age 정수로 변환될수있는 String
     * @return true 알맞은 생년월일
     * false 부정확한 생년월일
     * @param1 정수로 변환될수있는 6자리 String
     */

    public static boolean checkDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyMMdd");
            dateFormatParser.setLenient(false);
            dateFormatParser.parse(checkDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
