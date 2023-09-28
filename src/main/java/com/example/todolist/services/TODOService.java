package com.example.todolist.services;

import com.example.todolist.dto.TODOItem;
import com.example.todolist.utilis.TODOStorageSingleton;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TODOService {


    public List<TODOItem> getItem(String username) {
        return TODOStorageSingleton.getInstance().getItem(username);

    }

    public Long saveItem(TODOItem item) {
        if (item.getTitle() == null) return null;
        if (item.getUsername() == null) return null;
        long id = TODOStorageSingleton.getInstance().getCurrentId();
        item.setId(id);
        TODOStorageSingleton.getInstance().addItem(item);
        return id;
    }

    public boolean updateItem(Long id,TODOItem todoItem) {
        List<TODOItem> ourTodo = TODOStorageSingleton.getInstance().getItem(todoItem.getUsername());
        for (TODOItem item : ourTodo) {
            if (!item.getId().equals(id)) continue;

            if (todoItem.getTitle() != null) item.setTitle(todoItem.getTitle());
            if (todoItem.isDone() != null) item.setDone(todoItem.isDone());

            return true;
        }
        return false;
    }


}