package org.payroll.hr;

import java.util.ArrayList;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    public AuthenticationService(ArrayList users){
        this.users = users;
    }

    @Override
    public User signUp(String username, String password) {
        for (User user : users) {
            if (user.getUsername() == username){
                return null;
            }
        }
        users.add(new User(username, password));

        return users.getLast();
    }

    @Override
    public User logIn(String username, String password) {
        for (User user : users){
            if(Objects.equals(user.getUsername(), username) && Objects.equals(user.getPassword(), password)){
                return user;
            }
        }

        return null;
    }
}
