package todo.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import todo.ToDoService;
import todo.dto.ToDo;
import utils.APIUtils;
import java.lang.reflect.Type;
import java.util.List;


public class ToDoServiceImpl implements ToDoService {
    private final APIUtils utils = new APIUtils();

    @Override
    public List<ToDo> getAllUserToDo(int userId) {
        String jsonString = utils.get("/users/" +userId+"/todos");
        Type type = TypeToken
                .getParameterized(List.class, ToDo.class)
                .getType();
        return new Gson().fromJson(jsonString, type);
    }

    @Override
    public List<ToDo> getAllOpenUserToDo(int userId) {
        return getAllUserToDo(userId).stream()
                .filter(toDo -> !toDo.completed)
                .toList();
    }
}
