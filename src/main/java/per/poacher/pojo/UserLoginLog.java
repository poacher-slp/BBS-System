package per.poacher.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author poacher
 * @create 2021-12-19-12:42
 */
public class UserLoginLog implements Serializable {

    private Integer loginLogId;
    private String userName;
    private String loginIp;
    private Timestamp loginDateTime;
    private User user;

    public UserLoginLog() {
    }

    public UserLoginLog(Integer loginLogId, String userName, String loginIp, Timestamp loginDateTime, User user) {
        this.loginLogId = loginLogId;
        this.userName = userName;
        this.loginIp = loginIp;
        this.loginDateTime = loginDateTime;
        this.user = user;
    }

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Timestamp getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Timestamp loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoginLogService{" +
                "loginLogId=" + loginLogId +
                ", userName='" + userName + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDateTime=" + loginDateTime +
                ", user=" + user +
                '}';
    }
}
