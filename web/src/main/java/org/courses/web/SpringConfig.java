package org.courses.web;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.*;
import org.courses.web.soap.SoapClasses.ManufactureServiceImpl;
import org.courses.web.soap.SoapClasses.MaterialServiceImpl;
import org.courses.web.soap.SoapClasses.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.ws.Endpoint;

@EnableWebMvc
@Configuration
@Import(org.courses.data.SpringConfig.class)
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class SpringConfig {
    @Autowired
    DAO<Type, Integer> typeDao;
    @Autowired
    DAO<Material, Integer> materialDao;
    @Autowired
    DAO<Manufacture, Integer> manufactureDao;
    @Autowired
    DAO<Socks, Integer> socksDao;
    @Autowired
    DAO<Composition, Integer> compositionDao;
    @Autowired
    DAO<Storage, Integer> storageDao;

    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public TypeServiceImpl TypeService() {
        return new TypeServiceImpl(typeDao);
    }
    @Bean
    public MaterialServiceImpl MaterialService() {
        return new MaterialServiceImpl(materialDao);
    }
    @Bean
    public ManufactureServiceImpl ManufactureService() {
        return new ManufactureServiceImpl(manufactureDao);
    }

    @Bean
    public Endpoint ManufactureEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), ManufactureService());
        endpoint.publish("/manufactureservice");
        return endpoint;
    }

    @Bean
    public Endpoint TypeEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), TypeService());
        endpoint.publish("/typeservice");
        return endpoint;
    }
    @Bean
    public Endpoint MaterialEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), MaterialService());
        endpoint.publish("/materialservice");
        return endpoint;
    }

    @Bean
    public org.courses.web.rest.SocksService restSocksService() {
        return new org.courses.web.rest.SocksService(socksDao);
    }

    @Bean
    public org.courses.web.rest.CompositionService restCompositionService() {
        return new org.courses.web.rest.CompositionService(compositionDao);
    }
    @Bean
    public org.courses.web.rest.StorageService restStorageService() {
        return new org.courses.web.rest.StorageService(storageDao);
    }
}
