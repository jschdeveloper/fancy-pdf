package js.service;

import js.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {
    public User findById(String id) {
        return new User(id, UUID.randomUUID().toString());
    }
}
