/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.ac.util;

import nl.hva.ac.model.Accommodatie;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cobra
 */
public class AantalGastenComparatorTest {
    
    public AantalGastenComparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of compare method, of class AantalGastenComparator.
     */
    @Test
    public void testCompare() {
         AantalGastenComparator instance = new AantalGastenComparator();
         int expResult;
         int result;
        
        //test 1
        Accommodatie a1 = new Accommodatie("je moeder", 30.00, 2, 1);
        Accommodatie a2 = new Accommodatie("je vader", 40.00, 3, 1);
        expResult = -1;
        result = instance.compare(a1, a2);
        assertEquals(expResult, result);
        
        
        //test 2
        Accommodatie a3 = new Accommodatie("je moeder2", 30.00, 2, 1);
        Accommodatie a4 = new Accommodatie("je vader2", 40.00, 2, 1);
        expResult = 0;
        result = instance.compare(a3, a4);
        assertEquals(expResult, result);
        
        
        //test 3
        Accommodatie a5 = new Accommodatie("je moeder3", 30.00, 3, 1);
        Accommodatie a6 = new Accommodatie("je vader3", 40.00, 2, 1);
        expResult = 1;
        result = instance.compare(a5, a6);
        assertEquals(expResult, result);
    }
    
}
