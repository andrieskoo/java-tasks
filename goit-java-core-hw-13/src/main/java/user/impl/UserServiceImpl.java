package user.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import comments.CommentService;
import comments.dto.Comment;
import comments.impl.CommentServiceImpl;
import post.PostService;
import post.dto.Post;
import post.impl.PostServiceImpl;
import user.UserService;
import user.dto.User;
import utils.APIUtils;
import utils.FileUtils;
import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {
    private final APIUtils utils = new APIUtils();
    private PostService postService = new PostServiceImpl();
    private CommentService commentService = new CommentServiceImpl();
    @Override
    public List<User> getAllUsers() {
        String jsonString = utils.get("/users");
        Type type = TypeToken
                .getParameterized(List.class, User.class)
                .getType();
        return new Gson().fromJson(jsonString, type);
    }

    @Override
    public User getUserById(int id) {
        String jsonString = utils.get("/users/" + id);
        return new Gson().fromJson(jsonString, User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        String jsonString = utils.get("/users?username="+username);
        return new Gson().fromJson(jsonString, User.class);
    }

    @Override
    public User createUser(User user) {
        String body = new Gson().toJson(user, User.class);
        String response =  utils.post("/users", body);
        return new Gson().fromJson(response, User.class);
    }


    @Override
    public User updateUser(User user) {
        String body = new Gson().toJson(user, User.class);
        String response =  utils.patch("/users/5", body);
        return new Gson().fromJson(response, User.class);
    }

    @Override
    public int deleteUser(int userId) {
      return utils.delete("/users/"+userId);
    }

    @Override
    public void exportAllLastPostComments(int userId) {
        FileUtils fileUtils = new FileUtils();

        List<Post> postList = postService.getAllUserPosts(userId);
        int lastPostId = postList.stream()
                .mapToInt(post -> post.id)
                .max()
                .orElseThrow(NoSuchElementException::new);
        List<Comment> commentList = commentService.getAllPostComments(lastPostId);
        System.out.println("commentList = " + commentList);
        fileUtils.writeToFile("user-"+userId+"-post-"+lastPostId+"-comments", commentList);
    }

}
