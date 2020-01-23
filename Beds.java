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
public class Beds {
    
    private int patNumb;
    private int bedNumb;
    private boolean availability; //Bed is free or not
    // bedTimer

    /**
     *
     * @return patient number;
     */
    public int getPatNumb() {
        return patNumb;
    }

    /**
     *
     * @param patNumb
     */
    public void setPatNumb(int patNumb) {
        this.patNumb = patNumb;
    }

    /**
     *
     * @return bed number;
     */
    public int getBedNumb() {
        return bedNumb;
    }

    /**
     *
     * @param bedNumb
     */
    public void setBedNumb(int bedNumb) {
        this.bedNumb = bedNumb;
    }

    /**
     *
     * @return availability;
     */
    public boolean isAvailable() {
        return availability;
    }

    /**
     *
     * @param availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.setPatNumb(patient.getPatNumb());
        this.setAvailability(false);
        patient.setAllocated(true);
    }

    //Contructors:

    /**
     *
     * @param bedNumb
     * @param availability
     */
        public Beds(int bedNumb, boolean availability) {
   
        this.bedNumb = bedNumb;
        this.availability = availability;
    }
    
    
    //To string

    /**
     *
     * @return string;
     */
    
    @Override
    public String toString() {
        return "\n Beds{" + "Patient Number: " + patNumb + ", Bed Number: " + bedNumb + ", Bed is Available: " + availability + '}';
    }
    
    
}
