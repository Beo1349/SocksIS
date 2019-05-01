package org.courses.web.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Socks;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Type;
import java.util.*;

@RestController
@RequestMapping("/socks")
public class SocksService {
    DAO<Socks, Integer> socksDao;
    public SocksService(DAO<Socks,Integer> socksDao){
        this.socksDao = socksDao;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET ,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get() {
        Gson gson = new Gson();

        return ResponseEntity.ok(gson.toJson(socksDao.readAll(), socksDao.readAll().getClass()));
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT )
    public void add(@RequestParam(value ="socks") String s) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Socks>>() {}.getType();
        socksDao.save(gson.fromJson(s, listType));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE )
    public void delete(@RequestParam(value ="socksDel") String s) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        List<Integer> listDel = gson.fromJson(s, listType);
        listDel.forEach(c -> socksDao.delete(c));
    }
}
