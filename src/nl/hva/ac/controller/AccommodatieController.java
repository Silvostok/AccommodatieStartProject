package nl.hva.ac.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import nl.hva.ac.data.DataProvider;
import nl.hva.ac.model.Accommodatie;
import nl.hva.ac.util.AantalGastenComparator;
import nl.hva.ac.view.AccommodatiesPane;

/**
 * De AccommodatieController.
 *
 * @author Folkert Boonstra <F.K.Boonstra@hva.nl>
 */
public class AccommodatieController {

    private final AccommodatiesPane accommodatiesPane;

    public AccommodatieController(Pane accommodatiesPane) {
        if (accommodatiesPane instanceof AccommodatiesPane) {
            this.accommodatiesPane = (AccommodatiesPane) accommodatiesPane;
        } else {
            this.accommodatiesPane = null;
        }

        init();

    }

    //Voeg hier de acties toe aan de buttons in accommodatiesPane.
    private void init() {
        
        //TODO uncomment de code hieronder om je aangemaakte button te vinden
        Button btnSort = (Button) this.accommodatiesPane.lookup("#Sorteer");
        //TODO uncomment de code hieronder om je aangemaakte button te vinden
        Button btnSave = (Button) this.accommodatiesPane.lookup("#Opslaan");
        Button btnLezen = (Button) this.accommodatiesPane.lookup("#Lezen");
         
        //make a observable list
        
        btnSort.setOnAction(e -> {
            System.out.println("Btn SORTEREN is gedrukt en werkt!!");
            Collections.sort(accommodatiesPane.getAccommodatieItems(), new AantalGastenComparator());
        });

        
        btnSave.setOnAction(e -> {
            
           System.out.println("Btn SAVE is gedrukt en werkt!!");
            
           File accommodatieFile = new File("acconmmodaties.dat");
           
           
           
            try {
                ObjectOutputStream output;
           
                output = new ObjectOutputStream(new FileOutputStream(accommodatieFile));
                DataProvider provider = new DataProvider();
                output.writeObject(provider.getDummyAccommodatieData());
                
                } catch (IOException ex) {
                System.err.println(ex);
            }
            
            
        });
        
        
        btnLezen.setOnAction(e -> {
            System.out.println("Btn LEZEN is gedrukt en werkt!!");
            
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("acconmmodaties.dat"));
                List<Accommodatie> ac = (List)input.readObject();
                System.out.println(ac);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccommodatieController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.getStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccommodatieController.class.getName()).log(Level.SEVERE, null, ex);
            }          
        });
            
    }

   
    

    /**
     * Vraag de lijst met accommodaties op.
     * 
     * @return een observable lijst van accommodaties.
     */
    public ObservableList<Accommodatie> getAccommodatieData() {
        DataProvider dataProvider = new DataProvider();
        List accommList = dataProvider.getDummyAccommodatieData();
        ObservableList<Accommodatie> accommFXList = FXCollections.observableArrayList(accommList);
        return accommFXList;
    }

  
}
