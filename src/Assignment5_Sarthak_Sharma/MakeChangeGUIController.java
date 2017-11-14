/**
 * 
 * Sarthak Sharma
 * PROG24178 JAVA 2 Professor Johnathan Penava 
 * Summary: makeChange controller class that contains GUI and makeChange algorithm
 * Make change main simply calls makeChangeGUI
 */
package Assignment5_Sarthak_Sharma;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.util.regex.*;

/**
 * FXML Controller class
 *
 * @author SarthaksComp
 */
public class MakeChangeGUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
  
   /**
    * Flow plane to display the dollar bills
    */
    @FXML
    private FlowPane fp;
    /**
     * Flow plane to display the coin images
     */
    @FXML
    private FlowPane fp2;
    /*
    *Make change button that computes all the change
    */
    @FXML
    private Button makeChange;
    /*
    *Text area where the user enters the amount
    */
    @FXML
    private TextField tamount;
  
    /**
     * Label where an error message is displayed if the user enters an incorrect input
     */
    @FXML
    private Label label;
    /**
     * Takes the amount from the user a and displays the change in images
     * Amount is entered in a textfield called tamount
     * Various variables like fifty, twenty, ten count are declared
     * Change is calculated and stored in the variables
     * images printed using for loop
     * @param event 
     */
    @FXML
    private void makeChange(ActionEvent event) {
       
        
        //catch errors if a string is entered instead of integers or decimals
        String patter = "[0-9]";
                //+ //"[+a-z]";
        Pattern p = Pattern.compile(patter);
        Matcher m = p.matcher(tamount.getText());  
        if (!m.find())
        {
        label.setText("Please enter a valid amount");
        fp.getChildren().clear();
        fp2.getChildren().clear();
        }
        else
        {
        //Variables to count the bill change 
        double fiftyCount = 0;
        double twentyCount = 0;
        double tenCount = 0;
        double fiveCount = 0;
        //Variables to count the coin change
        double quarterCount = 0;
        double nickelCount = 0;
        double dimeCount = 0;
        double dollarCount = 0;
        double twonieCount = 0;
        double amount;
        
        amount = Double.parseDouble(tamount.getText());
            
        fp.getChildren().clear();
        fp2.getChildren().clear();
  
        int centsAmount = (int) (amount * 100);

        int dollars = centsAmount / 100;
        centsAmount = centsAmount % 100;
        int centsAmount2 = centsAmount;
        centsAmount = centsAmount % 10;
        
        if (dollars >= 99 || centsAmount2 >= 99) 
        {
            label.setText("Cannot make change!");
        }
    else 
    {
        if (centsAmount <= 2) 
        {
            centsAmount2 = centsAmount2 - centsAmount;
        }
        if (centsAmount >= 3 && centsAmount <= 7) 
        {
            centsAmount2 = centsAmount2 - centsAmount;
            centsAmount2 = centsAmount2 + 5;
        }
        if (centsAmount >= 8 && centsAmount <= 10) 
        {
            centsAmount2 = centsAmount2 - centsAmount;
            centsAmount2 = centsAmount2 + 10;
        }
        //cents2 is the final cents amount
        amount = amount * 100;

        if (dollars >= 99 || dollars == 100) 
        {
            System.out.println("Cannot make Change");
        }

        //calculate the dollars amount
        if (dollars >= 50) 
        {
            fiftyCount = dollars / 50;
            dollars = dollars % 50;
        }
        if (dollars >= 20) 
        {
            twentyCount = dollars / 20;
            dollars = dollars % 20;
        }
        if (dollars >= 10) 
        {
            tenCount = dollars / 10;
            dollars = dollars % 10;
        }
        if (dollars >= 5) 
        {
            fiveCount = dollars / 5;
            dollars = dollars % 5;
        }
        
        if (dollars >= 2) {
            twonieCount = dollars / 2;
            dollars = dollars % 2;
        }
        if (dollars >= 1) 
        {
            dollarCount = dollars / 1;
            dollars = dollars % 1;
        }
        //calculate the cents amount
        if (centsAmount2 >= 25) 
        {
            quarterCount = centsAmount2 / 25;
            centsAmount2 = centsAmount2 % 25;
        }
        if (centsAmount2 >= 10) 
        {
            dimeCount = centsAmount2 / 10;
            centsAmount2 = centsAmount2 % 10;
        }
        if (centsAmount2 <= 5) 
        {
            nickelCount = centsAmount2 / 5;
            centsAmount2 = centsAmount2 % 5;
        }
    }
         
        for (int i = 0; i < fiftyCount; i++) 
        {
        Image fiftyBill = new Image("image\\50Bill.jpg");
        ImageView fiftyBillView = new ImageView(fiftyBill);
        fiftyBillView.setFitHeight(80);
        fiftyBillView.setFitWidth(160);
        fp.getChildren().add(fiftyBillView);
        }
        
        for (int i = 0; i < twentyCount; i++) 
        {
        Image twentyBill = new Image ("image\\20Bill.jpg");
        ImageView twentyBillView = new ImageView(twentyBill);
        twentyBillView.setFitHeight(80);
        twentyBillView.setFitWidth(160);
        fp.getChildren().add(twentyBillView);
        }
        
        for (int i = 0; i < tenCount; i++) 
        {
        Image tenBill = new Image ("image\\10Bill.jpg");
        ImageView tenBillView = new ImageView(tenBill);
        tenBillView.setFitHeight(80);
        tenBillView.setFitWidth(160);
        fp.getChildren().add(tenBillView);
        }
        
        for (int i = 0; i < fiveCount; i++) 
        {
        Image fiveBill = new Image ("image\\5Bill.jpg");
        ImageView fiveBillView = new ImageView(fiveBill);
        fiveBillView.setFitHeight(80);
        fiveBillView.setFitWidth(160);
        fp.getChildren().add(fiveBillView);
        }
        
        for (int i = 0; i < dimeCount; i++) 
        {
        Image dimeImg = new Image("image\\Dime.jpg");
        ImageView dimeImageView = new ImageView(dimeImg);
        dimeImageView.setFitHeight(100);
        dimeImageView.setFitWidth(100);
        fp2.getChildren().add(dimeImageView);
        }
        
        for (int i = 0; i < dollarCount; i++) 
        {
        Image loonieImg = new Image("image\\Loonie.jpg");
        ImageView loonieImageView = new ImageView(loonieImg);
        loonieImageView.setFitHeight(100);
        loonieImageView.setFitWidth(100);
        fp2.getChildren().add(loonieImageView);
        }
        
        for (int i = 0; i < twonieCount; i++) 
        {
        Image twonieImg = new Image("image\\Twonie.jpg");
        ImageView twonieImageView = new ImageView(twonieImg);
        twonieImageView.setFitHeight(100);
        twonieImageView.setFitWidth(100);
        fp2.getChildren().add(twonieImageView);
        }
        
        for (int i = 0; i < nickelCount; i++) 
        {
        Image nickelImg = new Image("image\\Nicel.jpg");
        ImageView nickelImageView = new ImageView(nickelImg);
        nickelImageView.setFitHeight(100);
        nickelImageView.setFitWidth(100);
        fp2.getChildren().add(nickelImageView);
        }
               
        for (int i = 0; i < quarterCount; i++) 
        {
        Image quarterImage = new Image("image\\Quarter.png");
        ImageView quarterImageView = new ImageView(quarterImage);
        quarterImageView.setFitHeight(100);
        quarterImageView.setFitWidth(100);
        fp2.getChildren().add(quarterImageView);
        }
        
        }
        
    }
}

