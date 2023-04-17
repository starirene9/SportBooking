package memberShipUserSystem;

import java.io.Serializable;

public class MemberShipUserInfo implements Serializable {
    private String userId; // 로그인 아이디
    private String userPwd; // 로그인 비밀번호
    private  String userName; // 사용자 이름
    private  String userArea; // 사용자 거주 지역
    private  String userAge; //생년월일(6자리)
    private  String userPhoneNum; // 사용자 전화번호

    public MemberShipUserInfo() {
    }

    public MemberShipUserInfo(String userId, String userPwd, String userName, String userArea, String userAge, String userPhoneNum) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userArea = userArea;
        this.userAge = userAge;
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userArea='" + userArea + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userPhoneNum='" + userPhoneNum + '\'' +
                '}';
    }

}
