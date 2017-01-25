/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.capgemini.phonebook.dao;

import cz.capgemini.phonebook.domain.Person;
import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mpohoral
 */
public class PhoneBookDaoXLSTest {
    
    public PhoneBookDaoXLSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testParse() throws IOException, InvalidFormatException {
        PhoneBookDaoXLS dao = new PhoneBookDaoXLS();
        List<Person> list = dao.getPersonsList();
        
     //   assertNotNull(list);
    }
}
