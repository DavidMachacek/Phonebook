/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.capgemini.phonebook.engine;

import cz.capgemini.phonebook.dao.PhoneBookDaoXLS;
import cz.capgemini.phonebook.domain.Person;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dmachace
 */
@Path("/resource")
public class PhoneBookEngine {

    private final PhoneBookDaoXLS phoneBookDaoXLS;

    public PhoneBookEngine() {
        this.phoneBookDaoXLS = new PhoneBookDaoXLS();
    }
    
   @BadgerFish
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_XML)
    public List<Person> getPersonsList() {

        return this.phoneBookDaoXLS.getPersonsList();
    }
}
