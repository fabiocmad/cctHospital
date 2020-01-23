/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author Fabio Madeira SBA18010
 */
public class Status {

    static DataStore data = new DataStore();
    
    /**
     * skip line method;
     */
    public static void skipLine() {
        System.out.println();
    }

    /**
     * initiate day method;
     */
    public static void initiateDay() {
        System.out.println("Welcome to CCT Hospital.");
        skipLine();

        ArrayList<Beds> emergencyBeds = data.getEmergencyBeds();
        ArrayList<Beds> treatmentBeds = data.getTreatmentBeds();
        ArrayList<Patient> patientWaitlist = data.getPatientWaitlist();
        ArrayList<Medic> listOfMedics = data.getMedicListOfNames();

        for (int i = 0; i < data.getPatientList().size(); i++) { //For each patient on the list, a new patient object is created
            Patient patient = data.getPatientList().get(i);

            if (patient.getLevelOfCare().contains("Doctor")) {
                Optional<Beds> emergencyBed = emergencyBeds.stream().filter(bed -> bed.isAvailable()).findFirst();
                if (emergencyBed.isPresent()) {
                    emergencyBed.get().setPatient(patient);
                    emergencyBed.get().setAvailability(false);
                    patient.setAllocated(true);

                }
            }

            if (patient.getLevelOfCare().contains("Consultant")) {

                Optional<Beds> treatmentBed = treatmentBeds.stream().filter(bed -> bed.isAvailable()).findFirst();
                if (treatmentBed.isPresent()) {
                    treatmentBed.get().setPatient(patient);
                    treatmentBed.get().setAvailability(false);
                    patient.setAllocated(true);
                }

            }

            if (patient.allocated == false) { //If patient could not be allocated, add that patient to a waitlist.
                patientWaitlist.add(patient);
            }

        }

        Status.assignPatientsToMedic();

        System.out.println("List of patients, their conditions when arrived to the hospital and what kind of medic is required for their condition: ");
        System.out.println(data.getPatientList());
        skipLine();
        System.out.println("List of emergency beds with patients assigned:");
        System.out.println("\nEmergency Beds" + data.getEmergencyBeds());
        skipLine();
        System.out.println("List of treatment beds with patients assigned:");
        System.out.println("\nTreatment Beds" + data.getTreatmentBeds());
        skipLine();
        System.out.println("List of patients that could not be assigned to a bed and are now on a waitlist:");
        System.out.println("\nPatients on waitlist" + data.getPatientWaitlist());
        skipLine();
        System.out.println("List of medics - doctor or consultants - and their respective assigned patients:");
        System.out.println("\nMedic List" + data.getMedicListOfNames());

    }

    /**
     * assigning medics to patients that have been previously assigned to beds;
     */
    public static void assignPatientsToMedic() {

        ArrayList<Patient> patientsAssigned;

        for (int i = 0; i < data.getPatientList().size(); i++) {

            Patient patient = data.getPatientList().get(i);

            if (patient.getLevelOfCare().contentEquals("Doctor") && patient.isAllocated()) {

                for (int j = 0; j < data.getMedicListOfNames().size(); j++) {
                    Medic medic = data.getMedicListOfNames().get(j);
                    patientsAssigned = medic.getPatientsAssignedToMedic();

                    if (data.getMedicListOfNames().get(j).getLevel().contentEquals("Doctor") && medic.getAmtOfPat() < 3) {

                        if (!patientsAssigned.contains(patient)) {

                            patientsAssigned.add(patient);
                            medic.setPatientsAssignedToMedic(patientsAssigned);
                            medic.amtOfPat++;
                            break;
                        }
                        //NEED TO ADD A CONDITION TO MAKE SURE NO MORE THAN 2 SPECIALITIES IN 3 PATIENTS PER MEDIC
                    }
                }

            }

            if (patient.getLevelOfCare().contentEquals("Consultant") && patient.isAllocated()) {

                for (int j = 0; j < data.getMedicListOfNames().size(); j++) {
                    Medic medic = data.getMedicListOfNames().get(j);
                    patientsAssigned = medic.getPatientsAssignedToMedic();

                    if (data.getMedicListOfNames().get(j).getLevel().contentEquals("Consultant") && medic.getAmtOfPat() < 3) {

                        if (!patientsAssigned.contains(patient)) {
                            patientsAssigned.add(patient);
                            medic.setPatientsAssignedToMedic(patientsAssigned);
                            medic.amtOfPat++;
                            break;
                        }
                     //NEED TO ADD A CONDITION TO MAKE SURE NO MORE THAN 2 SPECIALITIES IN 3 PATIENTS PER MEDIC

                    }
                }

            }
        }
    }

    /**
     * after two days, patients on emergency are either discharged or transferred to treatment;
     */
    public static void afterTwoDays() {
        Random randomGenerator = new Random();
        for (int i = 0; i < data.getEmergencyBeds().size(); i++) {

            String[] situation = {"Discharged", "Transferred"};

            Beds bed = data.getEmergencyBeds().get(i);
            Beds bedT = data.getTreatmentBeds().get(i);
            String currentSituation = situation[(randomGenerator.nextInt(situation.length))];

            if (currentSituation.equals("Discharged")) {

                for (int j = 0; j < data.getPatientList().size(); j++) {

                    Patient pat = data.getPatientList().get(j);

                    if (pat.getPatNumb() == bed.getPatNumb()) {
                        data.getPatientsDischarged().add(pat);
                        bed.isAvailable();
                    }

                }

            }

            if (currentSituation.equals("Transferred")) {

                for (int j = 0; j < data.getPatientList().size(); j++) {

                    Patient pat = data.getPatientList().get(j);

                    if (pat.getPatNumb() == bed.getPatNumb()) {
                        data.getPatientsTransferred().add(pat);
                        data.getPatientWaitlist().add(pat);
                        bed.isAvailable();
                        
                    if(bed.isAvailable()){
                    data.getPatientWaitlist().set(j, pat);
                    bed.setAvailability(false);
                    data.getEmergencyBeds();
                    
                    
                    }    
                    }

                }
            }
        }

    }
    
    

}
