/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import javax.sound.midi.SysexMessage;

/**
 *
 * @author Fabio Madeira SBA18010
 */
public class Patient {
    

    static boolean contains(String doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int patNumb;
    private String patName;
    private String condition; //Headache, Appendicitis, Diziness
    private String levelOfCare; // 0 for Doctor or 1 for Consultant 
    public boolean allocated;
   

    //Constructors

    /**
     *
     * @param patNumb
     * @param patName
     * @param condition
     * @param levelOfCare
     */
        public Patient(int patNumb, String patName, String condition, String levelOfCare) {
        this.patNumb = patNumb;
        this.patName = patName;
        this.condition = condition;
        this.levelOfCare = levelOfCare;
    }

    /**
     *
     */
    public Patient() {
    }

    
    //Getters

    /**
     *
     * @return
     */
        public int getPatNumb() {
        return patNumb;
    }

    /**
     *
     * @return
     */
    public String getPatName() {
        return patName;
    }

    /**
     *
     * @return
     */
    public String getCondition() {
        return condition;
    }

    /**
     *
     * @return
     */
    public String getLevelOfCare() {
        return levelOfCare;
    }   
 
    /**
     *
     * @return
     */
    public boolean isAllocated() {
        return allocated;
    }

    /**
     *
     * @param allocated
     */
    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }
    
    /**
     *
     * @param levelOfCare
     */
    public void setLevelOfCare(String levelOfCare) {
        this.levelOfCare = levelOfCare;
    }
    //To string

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        
        return "\n" + "Patient Name: " + patName + " Patient Number: " + patNumb +" Patient Condition: " + condition + " Patient Level Of Care: " + levelOfCare + '}';
    }

       
    
}
