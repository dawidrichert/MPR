package com.dawidrichert.service;

import com.dawidrichert.database.Database;
import com.dawidrichert.database.models.*;
import com.dawidrichert.database.repositories.*;
import com.dawidrichert.service.models.*;

public class UserService {

    private AddressRepository addressRepository;
    private PermissionRepository permissionRepository;
    private PermissionRoleRepository permissionRoleRepository;
    private PersonRepository personRepository;
    private RoleRepository roleRepository;
    private RoleUserRepository roleUserRepository;
    private UserRepository userRepository;

    public UserService() {
        Database database = new Database();
        initRepositories(database);
    }

    public void addUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Person person = user.getPerson();
        if(person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        long personId = personRepository.add(new DbPerson(person.getFirstName(), person.getLastName(), person.getPhoneNumber()));
        long userId = userRepository.add(new DbUser(personId, user.getLogin(), user.getPassword()));

        for(Address address : user.getAddresses()) {
            addressRepository.add(new DbAddress(userId, address.getStreet(), address.getCity(), address.getPostalCode(), address.getProvince(), address.getCountry()));
        }
        for(Role role : user.getRoles()) {
            long roleId = roleRepository.add(new DbRole(role.getName()));
            for(Permission permission : role.getPermissions()) {
                long permissionId = permissionRepository.add(new DbPermission(roleId, permission.getName()));
                permissionRoleRepository.add(new DbPermissionRole(roleId, permissionId));
            }
            roleUserRepository.add(new DbRoleUser(userId, roleId));
        }
    }

//    public User getUser(int id) {
//        DbUser user = userRepository.getById(id);
//        if(user != null) {
//            Collection<Address> addresses = addressRepository.getAll();
//
//            return new User(user.getId(), user.getLogin(), user.getPassword(),
//                    personRepository.getByUserId(user.getId()), xxx);
//        }
//        return null;
//    }

    private void initRepositories(Database database) {
        addressRepository = new AddressRepository(database);
        permissionRepository = new PermissionRepository(database);
        permissionRoleRepository = new PermissionRoleRepository(database);
        personRepository = new PersonRepository(database);
        roleRepository = new RoleRepository(database);
        roleUserRepository = new RoleUserRepository(database);
        userRepository = new UserRepository(database);
    }
}
