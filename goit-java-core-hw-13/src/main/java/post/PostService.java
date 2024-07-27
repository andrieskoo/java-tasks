package post;

import post.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllUserPosts(int userId);

//    Post getLastPost();
}
