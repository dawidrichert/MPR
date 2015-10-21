package com.dawidrichert.service;

import com.dawidrichert.database.Database;
import com.dawidrichert.database.models.*;
import com.dawidrichert.database.repositories.*;
import com.dawidrichert.service.models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            long roleId;
            DbRole dbRole = roleRepository.getByName(role.getName());
            if(dbRole == null) {
                roleId = roleRepository.add(new DbRole(role.getName()));
            } else {
                roleId = dbRole.getId();
            }

            for(Permission permission : role.getPermissions()) {
                long permissionId;
                DbPermission dbPermission = permissionRepository.getByName(permission.getName());
                if(dbPermission == null) {
                    permissionId = permissionRepository.add(new DbPermission(roleId, permission.getName()));
                } else {
                    permissionId = dbPermission.getId();
                }

                permissionRoleRepository.add(new DbPermissionRole(roleId, permissionId));
            }
            roleUserRepository.add(new DbRoleUser(userId, roleId));
        }
    }

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
