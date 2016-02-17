package com.myhomeapps.nikkido.users;


import org.apache.log4j.Logger;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.*;

/**
 * Created by vaba1010 on 04.02.2016.
 */
public class UsersList {

    private static final Logger LOGGER = Logger.getLogger(UsersList.class);
    private static final UsersList INSTANCE = new UsersList();

    public static UsersList getInstance() {
        return INSTANCE;
    }

    public List<User> getUsers() {
        return users;
    }

    private List<User> users;

    private UsersList() {
        users = new ArrayList<>();
    }
    private LoginValidator loginValidator = new LoginValidator();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUsers(String login) throws IOException {
        loginValidator.validateLogin(login);
        for(Iterator it = users.iterator(); it.hasNext();) {
            User user = (User) it.next();
            if(login.equals(((AbstractUser)user).getLogin())) {
                it.remove();
            }
        }
    }

    public boolean isLoginExists(String login) throws IOException {
        boolean result = false;
        loginValidator.validateLogin(login);
        for(User user : users) {
            if(login.equals(((AbstractUser)user).getLogin())) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(User user) throws IOException {
        if(isLoginExists(((AbstractUser)user).getLogin())) {
            throw new IOException("User with specified login already exists");
        } else {
            //TODO if( <password specified and valid> )
            addUser(user);
        }
    }

    private User getByLogin(String login) {
        User result = new NullUser();
        for(User user : users) {
            if(login.equals(((AbstractUser)user).getLogin())) {
                return user;
            }
        }
        return result;
    }

    public boolean isPasswordCorrect(String login, String password) throws IOException {
        boolean result = false;
        if (isLoginExists(login)) {
            User user = getByLogin(login);
            //TODO if( <password specified and valid> )
            if(password.equals(((AbstractUser)user).getPassword())) {
                return true;
            } else {
                return false;
            }
        }
        return result;
    }

    public void printUsers() {
        LOGGER.info("USERS LIST:\n==================");
        for(User currentUser : users) {
            LOGGER.info(((AbstractUser)currentUser).getLogin());
        }
    }
}
