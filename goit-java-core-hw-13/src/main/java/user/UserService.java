package user;

import org.apache.http.HttpStatus;
import user.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByUsername(String username);

    User createUser(User user);

    User updateUser(User user);

    int deleteUser(int userId);

    void exportAllLastPostComments(int userId);
}
