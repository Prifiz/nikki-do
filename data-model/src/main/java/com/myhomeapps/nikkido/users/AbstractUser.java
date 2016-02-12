package com.myhomeapps.nikkido.users;

/**
 * Created by vaba1010 on 04.02.2016.
 */
public abstract class AbstractUser {
    private String login;
    private String password;

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
