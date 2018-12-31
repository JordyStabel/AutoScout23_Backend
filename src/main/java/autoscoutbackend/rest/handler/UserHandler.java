package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.UserEntityRepository;
import autoscoutbackend.models.User;

import java.util.List;

public class UserHandler {

    private UserEntityRepository userEntityRepository = new UserEntityRepository();

    public void AddNewUser(User user){
        userEntityRepository.save(user);
    }

    public List<User> GetAllUsers(){
        return userEntityRepository.findAll();
    }

    public User GetById(int id) {
        return userEntityRepository.findOne(id);
    }
}