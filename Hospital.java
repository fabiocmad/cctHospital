/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author Fabio Madeira SBA18010
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       
        Status.initiateDay();
        Menu.userMenu(Status.data);
        
              
    }
    
    
    
     
        
}
