package uz.b25.testing_system.server.service;

import uz.b25.testing_system.server.database.Database;
import uz.b25.testing_system.server.entity.User;

public class UserService {
    public static User getUserByPhoneNumber(String phoneNumber) {

        for (User user : Database.USERS) {
            if(user.getPhoneNumber().equals(phoneNumber)){
                return user;
            }
        }
        return null;
    }
}
