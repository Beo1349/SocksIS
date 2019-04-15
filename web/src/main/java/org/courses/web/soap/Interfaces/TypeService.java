package org.courses.web.soap.Interfaces;

import org.courses.domain.hbm.Type;

import javax.jws.WebService;

import java.util.Collection;

@WebService
public
interface TypeService {
    boolean checkDB(String connectionString);
    void save(Collection<Type> entity);
    Type read(int id);
    Collection<Type> readAll();
    Collection<Type> find(String filter);
    void delete(int id);
}