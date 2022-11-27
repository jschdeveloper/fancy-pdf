package js.service;

import js.model.User;

import java.util.UUID;

public class UserService {
    public User findById(String id) {
        return new User(id, UUID.randomUUID().toString());
    }
}
