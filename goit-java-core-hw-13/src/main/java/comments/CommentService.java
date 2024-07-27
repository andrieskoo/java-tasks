package comments;


import comments.dto.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllPostComments(int postId);
}
