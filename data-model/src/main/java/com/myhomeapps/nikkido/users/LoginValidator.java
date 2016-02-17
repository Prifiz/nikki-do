package com.myhomeapps.nikkido.users;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by vaba1010 on 17.02.2016.
 */
public class LoginValidator {

    public String getErrorMessage() {
        return errorMessage;
    }

    private String errorMessage;

    public boolean isLoginValid(String login) {
        boolean result = false;
        if(StringUtils.isBlank(login)) {
            errorMessage = "Login shouldn't be blank!";
            return false;
        }
        if(login.contains(" ")) {
            errorMessage = "Login shouldn't contain spaces!";
            return false;
        }
        return true;
    }

    public void validateLogin(String login) throws IOException {
        if(!isLoginValid(login)) {
            throw new IOException(errorMessage);
        }
    }
}
