package login;

import java.util.Objects;

public class UserInfo {
    private String userId;
    private String userPwd;
    private String userName;
    private String userArea;
    private String userAge;
    private String userPhoneNum;

    public UserInfo() {
    }

    public UserInfo(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
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
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return this.userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserArea() {
        return this.userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserAge() {
        return this.userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoneNum() {
        return this.userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String toString() {
        return "UserInfo{userId='" + this.userId + "', userPwd='" + this.userPwd + "', userName='" + this.userName + "', userArea='" + this.userArea + "', userAge='" + this.userAge + "', userPhoneNum='" + this.userPhoneNum + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            UserInfo userInfo = (UserInfo)o;
            return Objects.equals(this.userId, userInfo.userId) && Objects.equals(this.userPwd, userInfo.userPwd) && Objects.equals(this.userName, userInfo.userName) && Objects.equals(this.userArea, userInfo.userArea) && Objects.equals(this.userAge, userInfo.userAge) && Objects.equals(this.userPhoneNum, userInfo.userPhoneNum);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, this.userPwd, this.userName, this.userArea, this.userAge, this.userPhoneNum});
    }
}
