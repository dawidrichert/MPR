package com.dawidrichert;

import com.dawidrichert.database.Database;
import com.dawidrichert.models.User;
import com.dawidrichert.repositories.UserRepository;

public class Application {

    public static void main(String args[])
    {
        User user = new User("dawid", "secret", null, null, null);

        Database hsqlDatabase = new Database();

        UserRepository userRepository = new UserRepository(hsqlDatabase);
        userRepository.add(user);

        System.out.println(userRepository.getById(1).getLogin());
    }
}
