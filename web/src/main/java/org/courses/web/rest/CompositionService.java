package org.courses.web.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Composition;
import org.courses.domain.hbm.Socks;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

@RestController
@RequestMapping("/composition")
public class CompositionService {
    DAO<Composition, Integer> compositionDao;
    public CompositionService(DAO<Composition,Integer> compositionDao){
        this.compositionDao = compositionDao;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET ,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get() {
        Gson gson = new Gson();

        return ResponseEntity.ok(gson.toJson(compositionDao.readAll(), compositionDao.readAll().getClass()));
    }
    @RequestMapping(value = "/add", method = RequestMethod.PUT )
    public void add(@RequestParam(value ="compositions") String s) {
        Gson gson = new Gson();
        System.out.println(s);
        Type listType = new TypeToken<List<Composition>>() {}.getType();
        compositionDao.save(gson.fromJson(s, listType));
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE )
    public void delete(@RequestParam(value ="compositionDel") String s) {
        Gson gson = new Gson();
        System.out.println(s);
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        List<Integer> listDel = gson.fromJson(s, listType);
        listDel.forEach(c -> compositionDao.delete(c));
    }

}
