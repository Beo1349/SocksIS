package org.courses.web.soap.SoapClasses;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Material;
import org.courses.web.soap.Interfaces.MaterialService;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.Interfaces.MaterialService",
        serviceName = "MaterialService"
)
public class MaterialServiceImpl implements MaterialService {

    @Override
    public boolean checkDB(String connectionString) {
        return false;
    }


    DAO<Material, Integer> dao;
    public MaterialServiceImpl(DAO<Material, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void save(Collection<Material> entity) {
        dao.save(entity);
    }

    @Override
    public Material read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Material> readAll() {
        return dao.readAll();
    }

    @Override
    public Collection<Material> find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
