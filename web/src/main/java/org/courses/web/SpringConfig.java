package org.courses.web;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Manufacture;
import org.courses.domain.hbm.Material;
import org.courses.domain.hbm.Type;
import org.courses.web.soap.SoapClasses.ManufactureServiceImpl;
import org.courses.web.soap.SoapClasses.MaterialServiceImpl;
import org.courses.web.soap.SoapClasses.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.xml.ws.Endpoint;

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
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), ManufactureService());
        endpoint.publish("/manufactureservice");
        return endpoint;
    }

    @Bean
    public Endpoint endpoint1() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), TypeService());
        endpoint.publish("/typeservice");
        return endpoint;
    }
    @Bean
    public Endpoint endpoint2() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), MaterialService());
        endpoint.publish("/materialservice");
        return endpoint;
    }

    @Bean
    public org.courses.web.rest.TestService restTestService() {
        return new org.courses.web.rest.TestService();
    }
}
