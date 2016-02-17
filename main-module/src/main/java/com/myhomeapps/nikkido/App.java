package com.myhomeapps.nikkido;

import com.myhomeapps.nikkido.users.*;
import org.apache.log4j.Logger;

/**
 * Created by vaba1010 on 19.01.2016.
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        /*UsersList users = UsersList.getInstance();
        User user = new UserImpl();
        ((AbstractUser) user).setLogin("TestLogin");
        ((AbstractUser) user).setPassword("TestPassword");
        CommonInfo commonInfo = new CommonInfo("Ololo", 777);
        ((UserImpl)user).setCommonInfo(commonInfo);
        user.register();
        if(user.login("TestLogin", "TestPassword")) {
            LOGGER.info("Login success!");
            users.printUsers();
        } else {
            LOGGER.error("Login failed!");
        }
        user.logoff();
        users.printUsers();*/
    }
}
