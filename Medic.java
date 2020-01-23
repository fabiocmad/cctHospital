/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import static hospital.Status.skipLine;
import java.util.ArrayList;

/**
 *
 * @author Fabio Madeira SBA18010
 */
public class Medic {

    
    
    ArrayList<Patient> patientsAssignedToMedic = new ArrayList<>();

    /**
     *
     */
    public int medicNumb;

    /**
     *
     */
    public String medicName;

    /**
     *
     */
    public int amtOfPat; //Max of 3 patients per medic, with max of 2 conditions

    /**
     *
     */
    public String speciality1;

    /**
     *
     */
    public String speciality2;

    /**
     *
     */
    public String level;
    //Headache, Appendicitis, Diziness //Created an array with the specialities
    /// no need for availability as I will have a condition to set the max amount of patients

    /**
     *
     * @return
     */
    public String getLevel() {
        return level;
    }
    

    //Constructors

    /**
     *
     * @param medicName
     * @param medicNumb
     * @param amtOfPat
     * @param speciality1
     * @param speciality2
     * @param availability
     * @param level
     */
        public Medic(String medicName, int medicNumb, int amtOfPat, String speciality1,String speciality2, boolean availability, String level) {
        this.medicName = medicName;
        this.medicNumb = medicNumb;
        this.amtOfPat = amtOfPat;
        this.speciality1 = speciality1;
        this.speciality2 = speciality2;
        this.level = level;
        
        
    }


   //Getters and Setters
   
    /**
     *
     * @return
     */
       
    public int getMedicNumb() {
        return medicNumb;
    }

    /**
     *
     * @param medicNumb
     */
    public void setMedicNumb(int medicNumb) {
        this.medicNumb = medicNumb;
    }

    /**
     *
     * @return
     */
    public String getMedicName() {
        return medicName;
    }

    /**
     *
     * @param medicName
     */
    public void setMedicName(String medicName) {
        this.medicName = medicName;
    }

    /**
     *
     * @return
     */
    public int getAmtOfPat() {
        return amtOfPat;
    }

    /**
     *
     * @param amtOfPat
     */
    public void setAmtOfPat(int amtOfPat) {
        this.amtOfPat = amtOfPat;
    }
    
    /**
     *
     * @return
     */
    public String getSpeciality1() {
        return speciality1;
    }

    /**
     *
     * @param speciality1
     */
    public void setSpeciality1(String speciality1) {
        this.speciality1 = speciality1;
    }

    /**
     *
     * @return
     */
    public String getSpeciality2() {
        return speciality2;
    }

    /**
     *
     * @param speciality2
     */
    public void setSpeciality2(String speciality2) {
        this.speciality2 = speciality2;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Patient> getPatientsAssignedToMedic() {
        return patientsAssignedToMedic;
    }

    /**
     *
     * @param patientsAssignedToMedic
     */
    public void setPatientsAssignedToMedic(ArrayList<Patient> patientsAssignedToMedic) {
        this.patientsAssignedToMedic = patientsAssignedToMedic;
    }
  
   
    //To string

    /**
     *
     * @return
     */
    
    @Override
    public String toString() {
        return "\nMedic" + "\nPatient Number: " + patientsAssignedToMedic + " Medic Number: " + medicNumb + " Amount of Patients: " + amtOfPat + " Speciality 1: " + speciality1 + " Speciality 2: " + speciality2 + '}';
        
    }

    
}
