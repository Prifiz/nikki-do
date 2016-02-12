package com.myhomeapps.nikkido.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vaba1010 on 04.02.2016.
 */
public class UsersList {
    private List<User> users;

    public UsersList() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    


}
