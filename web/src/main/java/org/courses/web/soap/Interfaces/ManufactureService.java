package org.courses.web.soap.Interfaces;

import org.courses.domain.hbm.Manufacture;
import org.courses.domain.hbm.Type;

import javax.jws.WebService;

import java.util.Collection;

@WebService
public
interface ManufactureService {
    boolean checkDB(String connectionString);
    void save(Collection<Manufacture> entity);
    Manufacture read(int id);
    Collection<Manufacture> readAll();
    Collection<Manufacture> find(String filter);
    void delete(int id);
}
