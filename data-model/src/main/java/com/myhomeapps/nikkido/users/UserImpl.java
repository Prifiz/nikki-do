package com.myhomeapps.nikkido.users;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by vaba1010 on 04.02.2016.
 */
public class UserImpl extends AbstractUser implements User {

    private static final Logger LOGGER = Logger.getLogger(UserImpl.class);
    private boolean userLoggedIn = false;

    private CommonInfo commonInfo;

    @Override
    public boolean login(String login, String pass) {
        UsersList usersList = UsersList.getInstance();
        try {
            if (usersList.isPasswordCorrect(login, pass)) {
                userLoggedIn = true;
            } else {
                userLoggedIn = false;
            }
        } catch (IOException ex) {
            LOGGER.error("Login failed: " + ex.getMessage());
        } finally {
            return userLoggedIn;
        }
    }

    @Override
    public void logout() {
        userLoggedIn = false;
    }

    @Override
    public void register() {
        try {
            UsersList.getInstance().registerUser(this);
        } catch (IOException ex) {
            LOGGER.error("Cannot register user: " + ex.getMessage());
        }
    }

    @Override
    public void logoff() {
        userLoggedIn = false;
        try {
            UsersList.getInstance().removeUsers(this.getLogin());
        } catch (IOException ex) {
            LOGGER.error("Cannot remove user info: " + ex.getMessage());
        }
    }

    @Override
    public void setCommonInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }
}
