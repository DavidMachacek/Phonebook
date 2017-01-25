/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.capgemini.phonebook.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author dmachace
 */
@XmlRootElement(name = "person")
public class Person {
    
        private String id;
        private String surname;
        private String name;
        private String phone;
        private String cellphone;

    public Person(String id, String surname, String name, String phone, String cellphone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.cellphone = cellphone;
    }
    
    public Person () {
        
    }
    
@XmlElement
    public String getId() {
        return id;
    }
@XmlElement
    public String getSurname() {
        return surname;
    }
@XmlElement
    public String getName() {
        return name;
    }
@XmlElement
    public String getPhone() {
        return phone;
    }
@XmlElement
    public String getCellphone() {
        return cellphone;
    }
    
}
