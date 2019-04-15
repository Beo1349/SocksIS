package org.courses.web.soap.SoapClasses;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Type;
import org.courses.web.soap.Interfaces.TypeService;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.Interfaces.TypeService",
        serviceName = "TypeService"
)
public class TypeServiceImpl implements TypeService {

    @Override
    public boolean checkDB(String connectionString) {
        return false;
    }


    DAO<Type, Integer> dao;
    public TypeServiceImpl(DAO<Type, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void save(Collection<Type> entity) {
        dao.save(entity);
    }

    @Override
    public Type read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Type> readAll() {
        return dao.readAll();
    }

    @Override
    public Collection<Type> find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
