import comments.CommentService;
import comments.impl.CommentServiceImpl;
import post.PostService;
import post.impl.PostServiceImpl;
import todo.ToDoService;
import todo.impl.ToDoServiceImpl;
import user.UserService;
import user.dto.User;
import user.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        ToDoService toDoService = new ToDoServiceImpl();

        User user = userService.getUserById(5);
        System.out.println("user.username = " + user.username);
        System.out.println("userService.getAllUsers() = " + userService.getAllUsers());

        User user1 = new User();
        user1.username = "Vasja";
        System.out.println("userService.createUser(user1) = " + userService.createUser(user1));

        user.username = "Peeetro";
        System.out.println("userService.updateUser(user) = " + userService.updateUser(user));

        System.out.println("userService.updateUser(user) = " + userService.deleteUser(5));
        System.out.println("postService.getAllUserPosts() = " + postService.getAllUserPosts(5));
        System.out.println("postService.getAllUserPosts() = " + commentService.getAllPostComments(5));
        System.out.println("EXPORT ALL COMMENTS");
        userService.exportAllLastPostComments(5);

        System.out.println("toDoService.getAllOpenUserToDo(5) = " + toDoService.getAllOpenUserToDo(5));

    }


}
