package com.myhomeapps.nikkido.users;

/**
 * Created by vaba1010 on 04.02.2016.
 */
public abstract class AbstractUser {
    private String login;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public abstract void setCommonInfo(CommonInfo commonInfo);

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstractUser)) return false;

        AbstractUser that = (AbstractUser) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        if(login.equals(that.login)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
