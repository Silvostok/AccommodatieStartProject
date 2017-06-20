/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.ac.util;

import java.util.Comparator;
import nl.hva.ac.model.Accommodatie;

/**
 *
 * @author Cobra
 */
public class AantalGastenComparator implements Comparator<Accommodatie>{
    
    @Override
    public int compare(Accommodatie a1, Accommodatie a2) {
//        if (a1.getAantalGasten() == a2.getAantalGasten()) {
//            return 0;
//        } else if (a1.getAantalGasten() > a2.getAantalGasten()) {
//            return 1;
//        } else {
//            return -1;
//        }
        
        
        return a1.getAantalGasten() - a2.getAantalGasten();
    }

}

    
   
