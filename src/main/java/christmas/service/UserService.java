package christmas.service;

import christmas.domain.model.User;

public class UserService {

    public User createUser(String date, String menu) {
        return User.create(date, menu);
    }
}
