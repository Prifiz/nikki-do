package com.myhomeapps.nikkido.users;

/**
 * Created by vaba1010 on 04.02.2016.
 */
public interface User {
    public boolean login(String login, String pass);
    public void logout();
    public void register();
    public void logoff();
}
