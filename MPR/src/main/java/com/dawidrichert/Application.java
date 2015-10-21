package com.dawidrichert;

import com.dawidrichert.database.Database;
import com.dawidrichert.database.models.DbUser;
import com.dawidrichert.service.UserService;
import com.dawidrichert.service.models.*;
import com.dawidrichert.database.repositories.UserRepository;

import java.util.Arrays;

public class Application {

    public static void main(String args[]) {
//        DbUser user = new DbUser(1, "dawid", "secret");
//
//        Database hsqlDatabase = new Database();
//
//        UserRepository userRepository = new UserRepository(hsqlDatabase);
//        userRepository.add(user);
//
//        System.out.println(userRepository.getById(0).getLogin());



        UserService userService = new UserService();

        CreatingDemonstration(userService);
        //DisplayingDemonstration(userRepository);
    }

    public static void CreatingDemonstration(UserService userService) {

        // Declare permission
        Permission permAdd = new Permission("Add");
        Permission permEdit = new Permission("Edit");
        Permission permDelete = new Permission("Delete");
        Permission permReadOnly = new Permission("ReadOnly");
        Permission permRestore = new Permission("Restore");

        // Declare roles
        Role roleAdmin = new Role("Admin", Arrays.asList(permAdd, permEdit, permDelete, permReadOnly, permRestore));
        Role roleTeacher = new Role("Teacher", Arrays.asList(permAdd, permEdit, permDelete, permReadOnly));
        Role roleStudent = new Role("Student", Arrays.asList(permAdd, permEdit, permReadOnly));

        // Declare users
        User user1 = new User("dawidr", "pass123", new Person("Dawid", "Richert", "111-222-333"),
                Arrays.asList(new Address("Kurczaka 5", "Kartuzy", "83-300", "Pomorenian", "Poland")),
                Arrays.asList(roleAdmin));

        User user2 = new User("adamn", "pass222", new Person("Adam", "Nowak", "999-888-777"),
                Arrays.asList(new Address("Hipopotama 2", "Gdansk", "80-000", "Pomeranian", "Poland")),
                Arrays.asList(roleStudent, roleTeacher));

        // Insert data to database
        userService.addUser(user1);
        userService.addUser(user2);
    }
//
//    public static void DisplayingDemonstration(UserRepository userRepository) {
//        System.out.println("Users retrieved from database: ");
//        for(User user : userRepository.getAll()) {
//            System.out.println("Login:\t" + user.getLogin());
//            System.out.println("Name:\t" + user.getPerson().getFirstName() + " " + user.getPerson().getLastName());
//        }
//    }
}
