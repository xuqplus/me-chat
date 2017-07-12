package cn.xuqplus.domain;

/**
 * Created by qqx on 2017/7/10.
 */
public class User {
    private Integer id;
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private String account_state;
    private String login_state;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setAccount_state(String account_state) {
        this.account_state = account_state;
    }

    public void setLogin_state(String login_state) {
        this.login_state = login_state;
    }

    public Integer getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getAccount_state() {
        return account_state;
    }

    public String getLogin_state() {
        return login_state;
    }

    public User(Integer id, String user_id, String user_name, String user_email, String user_password, String account_state, String login_state) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.account_state = account_state;
        this.login_state = login_state;
    }
}
