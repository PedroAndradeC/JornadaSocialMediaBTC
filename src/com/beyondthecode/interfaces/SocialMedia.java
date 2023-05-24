package com.beyondthecode.interfaces;

import com.beyondthecode.entities.User;

public interface SocialMedia {
    void createUser(User user);
    User login(String email, String password);
    void editUser(User user);
}
