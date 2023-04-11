package login;

import java.util.Objects;

public class UserInfo {
    private String userId; // 로그인 아이디
    private String userPwd; // 로그인 비밀번호
    private String userName; // 이름
    private String userArea; // 지역
    private String userAge; // 나이
    private String userPhoneNum; // 전화번호

    public UserInfo() {
    }

    public UserInfo(String userId, String userPwd, String userName, String userArea, String userAge, String userPhoneNum) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(userId, userInfo.userId) && Objects.equals(userPwd, userInfo.userPwd) && Objects.equals(userName, userInfo.userName) && Objects.equals(userArea, userInfo.userArea) && Objects.equals(userAge, userInfo.userAge) && Objects.equals(userPhoneNum, userInfo.userPhoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPwd, userName, userArea, userAge, userPhoneNum);
    }

}
