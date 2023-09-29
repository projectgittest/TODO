package com.example.todolist.controllers;
import com.example.todolist.dto.TODOItem;
import com.example.todolist.services.TODOService;
import com.example.todolist.utilis.TODOStorageSingleton;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todos/list")
public class TODOController {

    private final TODOService todoService;

    public TODOController(TODOService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("create")
    public ResponseEntity<Long>addItem(@RequestBody TODOItem item){
        Long id=todoService.saveItem(item);
        System.out.println("Create");
        if(id==null)return ResponseEntity.badRequest().body(-1L);
        return ResponseEntity.ok(id);
}

    @PatchMapping ("update/{id}")
    public ResponseEntity<String> updateItem(@RequestBody TODOItem item,@PathVariable long id){
        System.out.println("Update item");
        return todoService.updateItem(id,item)
                ? ResponseEntity.status(200).body("TODO updated")
                : ResponseEntity.status(404).body("TODOO not found!");
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<TODOItem>>getItem(@PathVariable String username) {
        System.out.println("Item");
            return ResponseEntity.status(200).body(todoService.getItem(username));

    }
}
