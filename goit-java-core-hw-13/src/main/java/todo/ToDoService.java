package todo;

import todo.dto.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllUserToDo(int userId);

    List<ToDo> getAllOpenUserToDo(int userId);
}
