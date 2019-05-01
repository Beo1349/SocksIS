package org.courses.web.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Socks;
import org.courses.domain.hbm.Storage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Type;
import java.util.*;

@RestController
@RequestMapping("/storage")
public class StorageService {
    DAO<Storage, Integer> storageDao;
    public StorageService(DAO<Storage,Integer> storageDao){
        this.storageDao = storageDao;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET ,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get() {
        Gson gson = new Gson();

        return ResponseEntity.ok(gson.toJson(storageDao.readAll(), storageDao.readAll().getClass()));
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT )
    public void add(@RequestParam(value ="storage") String s) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Storage>>() {}.getType();
        storageDao.save(gson.fromJson(s, listType));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE )
    public void delete(@RequestParam(value ="storageDel") String s) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        List<Integer> listDel = gson.fromJson(s, listType);
        listDel.forEach(c -> storageDao.delete(c));
    }
}
