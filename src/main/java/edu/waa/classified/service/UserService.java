package edu.waa.classified.service;

import java.util.List;

import edu.waa.classified.model.User;

public interface UserService {
    public boolean saveUser(User user);

    public List<User> findAllUsers();

    public User findUserById(int id);

    public User findByUserNameAndPassword(String userName, String password);

    public User findByUserName(String userName);

    public boolean updateUser(User user);

    public void deleteUser(int id);

    public List<User> findUserByRoleName(String roleName);


}

