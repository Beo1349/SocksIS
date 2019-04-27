package org.courses.web.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Socks;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

@RestController
@RequestMapping("/dbtest")
public class SocksService {
    DAO<Socks, Integer> socksDao;
    private Socks sock;
    public SocksService(DAO<Socks,Integer> socksDao){
        this.socksDao = socksDao;
    }

    @RequestMapping(value = "/sock", method = RequestMethod.GET ,produces= MediaType.APPLICATION_JSON_VALUE)
   // @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity greeting() {
        //HttpStatus status = HttpStatus.OK ;
        Gson gson = new Gson();
        sock = new Socks();

        return ResponseEntity.ok(gson.toJson(socksDao.readAll(), socksDao.readAll().getClass()));
    }

    @RequestMapping(value = "/sock", method = RequestMethod.PUT )
    public void add(@RequestParam(value ="socks") String s) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Socks>>() {}.getType();
        socksDao.save(gson.fromJson(s, listType));
    }

    @RequestMapping(value = "/sock", method = RequestMethod.DELETE )
    public void delete(@RequestParam(value ="socksDel") String s) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        List<Integer> listDel = gson.fromJson(s, listType);
        listDel.forEach(c -> socksDao.delete(c));
    }


    public Socks getSock() {
        return sock;
    }

    public void setSock(Socks sock) {
        this.sock = sock;
    }
}
