package com.example.todolist.utilis;

import com.example.todolist.dto.TODOItem;

import java.util.*;

public class TODOStorageSingleton {

    private  static TODOStorageSingleton instance;

    private Map<String, List<TODOItem>> storage;

    private long currentId;

    private TODOStorageSingleton(){}

    public static TODOStorageSingleton getInstance(){
        if(instance==null){
            instance=new TODOStorageSingleton();
            instance.storage=new HashMap<>();
            instance.currentId=0;
        }
        return  instance;
    }

    public long getCurrentId() {
        currentId++;
        return currentId;
    }

    public void addItem(TODOItem item){
        if(!storage.containsKey(item.getUsername())) {
            storage.put(item.getUsername(), new ArrayList<TODOItem>(){{add(item);}});
            return;
        }
        storage.put(item.getUsername(), new ArrayList<TODOItem>(){{add(item);}});
    }

    public void removeItem(String username, Long itemId) {
        List<TODOItem> lst = getItem(username);
        for (int i = 0; i < lst.size()-1; i++) {
            if(itemId != lst.get(i).getId()) continue;
            lst.remove(i);
        }
    }

    public List<TODOItem> getItem(String username){
        if (!storage.containsKey(username)) return new ArrayList<>();
        return storage.get(username);
    }

}
