package org.courses.data.DAO.hbm;

import org.courses.domain.hbm.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class StorageDao extends BaseDao<Storage, Integer> {
    public StorageDao(SessionFactory factory) {
        super(factory, Storage.class);
    }

    @Override
    public Collection<Storage> find(String filter) {
        return null;
    }
}
