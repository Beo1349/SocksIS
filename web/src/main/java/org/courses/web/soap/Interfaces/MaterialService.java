package org.courses.web.soap.Interfaces;

import org.courses.domain.hbm.Material;
import org.courses.domain.hbm.Type;

import javax.jws.WebService;

import java.util.Collection;

@WebService
public
interface MaterialService {
    boolean checkDB(String connectionString);
    void save(Collection<Material> entity);
    Material read(int id);
    Collection<Material> readAll();
    Collection<Material> find(String filter);
    void delete(int id);
}