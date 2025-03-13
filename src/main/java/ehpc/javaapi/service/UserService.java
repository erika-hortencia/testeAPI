package ehpc.javaapi.service;

import ehpc.javaapi.model.User;

public interface UserService {
    User findById(long id);

    User create(User userToCreate);

}
