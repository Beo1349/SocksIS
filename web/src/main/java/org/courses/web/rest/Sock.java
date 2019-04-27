package org.courses.web.rest;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sock {
    private int Id;
    private String Name;

    public Sock(){
        Id = 1;
        Name = "test";

    }
    @XmlAttribute
    public int getId() {
        return Id;
    }
    @XmlAttribute
    public void setId(int id) {
        Id = id;
    }
    @XmlAttribute
    public String getName() {
        return Name;
    }
    @XmlAttribute
    public void setName(String name) {
        Name = name;
    }
}
