/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import static hospital.Status.skipLine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fabio Madeira SBA18010
 */
public class Menu {
   
    /**
     *
     * @param data
     */
    public static void userMenu(DataStore data)
    {
        int exit = 0;
        int choice;
        Scanner kb = new Scanner(System.in);
        Scanner keyBoard = new Scanner(System.in);        
        while (exit == 0)
        {
        System.out.println("\n Please choose an option from below: \n"
                + "((1)) - Show list of patients that came in on the first day. \n"
                + "((2)) - Show list of beds in emergency and their assigned patients. \n"
                + "((3)) - Show list of beds in treatment and their assigned patients. \n"
                + "((4)) - Show list of medics and their assigned patients. \n"
                + "((5)) - Show waitlist of patients. \n" 
                + "((6)) - Show list of patients discharged and transferred after 2 days. \n"
                + "((0)) - exit. \n");
        
        System.out.print("Insert the option number: ");
        choice = kb.nextInt();
        
            switch (choice)
            {
                case 1: //1- Show list of patients that came in on the first day.
                        {
                            
                            System.out.println(data.getPatientList());                            
                            System.out.println("\nPress enter to continue.");
                            keyBoard.nextLine();
                         
                        }
                        break;
                        
                case 2: //2 - Show list of beds in emergency and their assigned patients.
                        {
                            System.out.println(data.getEmergencyBeds());
                            System.out.print("\nPress enter to continue.");
                            keyBoard.nextLine();                            
                        }
                        break;
                        
                case 3: //3 - Show list of beds in treatment and their assigned patients.
                        {
                            System.out.println(data.getTreatmentBeds());
                            System.out.print("\nPress enter to continue.");
                            keyBoard.nextLine();                            
                        }
                        break;
                        
                case 4: //4 - Show list of medics and their assigned patients.
                        {
                            System.out.println(data.getMedicListOfNames());
                            System.out.print("\nPress enter to continue.");
                            keyBoard.nextLine();                            
                        }
                        break;
                        
                case 5: //5 - Show waitlist of patients.
                         {
                            System.out.println(data.getPatientWaitlist());
                            System.out.print("\nPress enter to continue.");
                            keyBoard.nextLine();                            
                        }
                        break;
                    
                case 6: //6 - Show list of patients discharged or transferred after 2 days.
                         {
                            Status.afterTwoDays();
                            System.out.println("Patients Discharded: ");
                            System.out.println(data.getPatientsDischarged());
                            skipLine();
                            System.out.println("Patients Transferred to Treatment: ");
                            System.out.println(data.getPatientsTransferred());
                            System.out.print("\nPress enter to continue.");
                            keyBoard.nextLine();                            
                        }
                        break;
                    
                                       
                case 0: //0 - Exit.
                        {
                            System.out.print("\nSee You!");
                            exit = 1;
                            
                        }
                        break;
                default:
                        {
                            System.out.println("\nPlease select a valid option. \n \n");
                        }
            }  
        }
    }
}
