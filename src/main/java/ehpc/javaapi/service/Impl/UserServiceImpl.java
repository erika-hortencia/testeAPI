package ehpc.javaapi.service.Impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import ehpc.javaapi.model.User;
import ehpc.javaapi.model.repository.UserRepository;
import ehpc.javaapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsById(userToCreate.getId())){
            throw  new IllegalArgumentException("User ID already exists");

        }
        return userRepository.save(userToCreate);
    }

}
