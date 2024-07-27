package post.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import post.PostService;
import post.dto.Post;
import utils.APIUtils;

import java.lang.reflect.Type;
import java.util.List;

public class PostServiceImpl implements PostService {
    private final APIUtils utils = new APIUtils();

    @Override
    public List<Post> getAllUserPosts(int userId) {
        String jsonString = utils.get("/users/"+userId+"/posts");
        Type type = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();
        return new Gson().fromJson(jsonString, type);
    }
}
