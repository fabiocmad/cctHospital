/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Fabio Madeira SBA18010
 */
public class DataStore {
   
    private ArrayList<String>    names                 = new ArrayList<>();
    private ArrayList<Patient>   patientList           = new ArrayList<>();
    private ArrayList<Medic>     medicListOfNames      = new ArrayList<>();
    private ArrayList<Beds>      numberOfBedsEmerg     = new ArrayList<>();
    private ArrayList<Beds>      numberOfBedsTreat     = new ArrayList<>();
    private ArrayList<Patient>   patientWaitlist       = new ArrayList<>();
    private ArrayList<Patient>   patientsDischarged    = new ArrayList<>();
    private ArrayList<Patient>   patientsTransferred   = new ArrayList<>();

    /**
     *
     * @return list of patients discharged after 2 days on the emergency department;
     */
    public ArrayList<Patient> getPatientsDischarged() {
        return patientsDischarged;
    }

    /**
     *
     * @param patientsDischarged
     */
    public void setPatientsDischarged(ArrayList<Patient> patientsDischarged) {
        this.patientsDischarged = patientsDischarged;
    }

    /**
     *
     * @return list of patients transferred from emergency department;
     */
    public ArrayList<Patient> getPatientsTransferred() {
        return patientsTransferred;
    }

    /**
     *
     * @param patientsTransferred
     */
    public void setPatientsTransferred(ArrayList<Patient> patientsTransferred) {
        this.patientsTransferred = patientsTransferred;
    }

    /**
     *
     * @return waitlist of patients that could not be assigned to a bed to be treated;
     */
    public ArrayList<Patient> getPatientWaitlist() {
        return patientWaitlist;
    }

    /**
     *
     * @param patientWaitlist
     */
    public void setPatientWaitlist(ArrayList<Patient> patientWaitlist) {
        this.patientWaitlist = patientWaitlist;
    }

    /**
     *
     * @return patient list before a first run on the code;
     */
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    /**
     *
     * @return list of medics (doctors and consultants);
     */
    public ArrayList<Medic> getMedicListOfNames() {
        return medicListOfNames;
    }

    /**
     *
     * @return list of emergency beds and which patients are on them;
     */
    public ArrayList<Beds> getEmergencyBeds() {
        return numberOfBedsEmerg;
    }

    /**
     *
     * @return
     */
    public ArrayList<Beds> getTreatmentBeds() {
        return numberOfBedsTreat;
    }
     
    
    //Methods  

    /**
     *
     * @param amtPat
     */
        public void createPatList(int amtPat)
    {
        Random randomGenerator = new Random();
        String[] listOfCondition = {"Headache", "Appendicitis", "Diziness"};
        String[] listLevelOfCare = {"Doctor", "Consultant"};
        
        for(int i=0; i<amtPat; i++)
        {
            int patNumb = ((patientList.size()) + 1);            
            String patName = names.get(randomGenerator.nextInt(names.size())); 
            String condition = listOfCondition[(randomGenerator.nextInt(listOfCondition.length))];
            String level = listLevelOfCare[(randomGenerator.nextInt(listLevelOfCare.length))];
            patientList.add(new Patient (patNumb, patName, condition, level));
        }
    }
    
    /**
     *
     * @param amtMedic
     */
    public void createMedicList(int amtMedic)
    {
             
       Random rGen = new Random();
       String[] listOfSpeciality = {"Headache", "Appendicitis", "Diziness"};
       String[] listLevelOfCare = {"Doctor", "Consultant"};
       int amtOfPat = 0;
       boolean availability = true;
        
        for(int i=0; i<amtMedic; i++)
        {
            String medicName = names.get(rGen.nextInt(names.size())); 
            int medicNumb = ((medicListOfNames.size()) + 1);
            String speciality1 = listOfSpeciality[(rGen.nextInt(listOfSpeciality.length))];
            String speciality2 = listOfSpeciality[(rGen.nextInt(listOfSpeciality.length))];       
            String level = listLevelOfCare[(rGen.nextInt(listLevelOfCare.length))];
            Medic m = new Medic (medicName,medicNumb,amtOfPat, speciality1, speciality2, availability, level);
            medicListOfNames.add(m);
            
             if(speciality1.equals(speciality2)){
            medicListOfNames.get(i).speciality2 = listOfSpeciality[(rGen.nextInt(listOfSpeciality.length))];
            }
        }
        
    }
    
    /**
     *
     * @param amt
     */
    public void createEmergBedList(int amt)
    {
       
        boolean availability = true;
        
        for(int i=0; i<amt; i++)
        {
            int bedNumb = ((numberOfBedsEmerg.size()) + 1);            
            Beds e = new Beds (bedNumb, availability);
            numberOfBedsEmerg.add(e);
        } 
    }
    
    /**
     *
     * @param amt
     */
    public void createTreatBedList(int amt)
    {
              
        boolean availability = true;
        
        for(int i=0; i<amt; i++)
        {
            int bedNumb = ((numberOfBedsTreat.size()) + 1);            
            Beds e = new Beds (bedNumb, availability);
            numberOfBedsTreat.add(e);
        }   
    }
    
    
    
    private void fillNamesFile()
    {   
        File fileNameList =  new File("Names.txt");
        ArrayList<String> filled = new ArrayList<>();
        
        try 
        {
            Scanner scan = new Scanner(fileNameList);
            while(scan.hasNextLine())
            {
                filled.add(scan.nextLine());
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        names.addAll(filled);
    }
  
    
    

    //Constructor

    /**
     *
     */
    
    public DataStore() 
    {
        fillNamesFile();
        createPatList(100);
        createMedicList(35);
        createEmergBedList(30);
        createTreatBedList(50);
        
    }
    
}

