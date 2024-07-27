package comments.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import comments.CommentService;
import comments.dto.Comment;
import post.dto.Post;
import utils.APIUtils;

import java.lang.reflect.Type;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private final APIUtils utils = new APIUtils();

    @Override
    public List<Comment> getAllPostComments(int postId) {
        String jsonString = utils.get("/posts/"+postId+"/comments");
        Type type = TypeToken
                .getParameterized(List.class, Comment.class)
                .getType();
        return new Gson().fromJson(jsonString, type);
    }
}
