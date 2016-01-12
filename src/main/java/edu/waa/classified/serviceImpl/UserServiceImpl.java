package edu.waa.classified.serviceImpl;

import edu.waa.classified.model.User;
import edu.waa.classified.repostiory.UserRepository;
import edu.waa.classified.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRespository;

    @Override
    public boolean saveUser(User user) {
        if (userRespository.save(user) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        return userRespository.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userRespository.findOne(id);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return userRespository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public boolean updateUser(User user) {
        if (userRespository.save(user) != null) {
            return true;
        }

        return false;
    }

    @Override
    public void deleteUser(int id) {
        userRespository.delete(id);
    }

    @Override
    public List<User> findUserByRoleName(String roleName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return userRespository.findByUserName(userName);
    }


}
