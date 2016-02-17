package com.myhomeapps.nikkido.users;

/**
 * Created by vaba1010 on 17.02.2016.
 */
public class NullUser extends AbstractUser implements User {


    @Override
    public boolean login(String login, String pass) {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public void register() {

    }

    @Override
    public void logoff() {

    }

    @Override
    public void setCommonInfo(CommonInfo commonInfo) {

    }
}
