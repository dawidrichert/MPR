package com.dawidrichert.service;

import com.dawidrichert.database.Database;
import com.dawidrichert.database.models.DbUser;
import com.dawidrichert.service.models.User;
import com.dawidrichert.database.repositories.UserRepository;

public class UserService {

//    UserRepository userRepository;
//    PersonRepository personRepository;
//
//    public UserService() {
//        database = new Database();
//        initRepositories(database);
//    }
//
////    public void addUser(User user) {
////        userRepository.add(user);
////    }
//
//    public User getUser(int id) {
//        DbUser user = userRepository.getById(id);
//        if(user != null) {
//            return new User(user.getId(), user.getLogin(), user.getPassword(),
//                    personRepository.getByUserId(user.getId()), xxx);
//        }
//    }
//
//    private initRepositories(Database database) {
//        userRepository = new UserRepository(database);
//        personRepository = new PersonRepository(database);
//    }
}
