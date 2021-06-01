package UI;

import Model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response =0 ;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientLogged.getName());
            System.out.println("1.-Book an appointment");
            System.out.println("2.-My appointments");
            System.out.println("0.-Exit");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    showBookAppointmentsMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                case 0:
                    UIMenu.ShowMenu();
                    break;
            }
        }while(response == 0);



    }
    private static void showBookAppointmentsMenu () {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("::Book an appointment");
            System.out.println(":: Select date: ");
            //numeración de la lista de fechas
            //indice de selección de fechas
            //[doctor]
            Map<Integer, Map <Integer, Doctor>> doctors = new TreeMap<>();
            int k=0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointment();
                Map<Integer,Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ".-" + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate =0;
            Doctor doctorSelected = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc: doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();;
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName() +
                    "Date: " + doctorSelected.getAvailableAppointment().get(indexDate).getDate() +
                    "time: " + doctorSelected.getAvailableAppointment().get(indexDate).getTime());
            System.out.println("Confirm your appointment: ");
            System.out.println("1.- Yes");
            System.out.println("2.- Change Data");

            sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointment().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointment().get(indexDate).getTime()
                );
                showPatientMenu();
            }
            else {}

        }while (response !=0);
    }
    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            if (UIMenu.patientLogged.getAppointmentDoctors().size()==0){
                System.out.println("Do not have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i+1;
                System.out.println(j +".-" +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()

                );
                System.out.println("0.-Exit");
            }

        }while (response !=0);
    }
}
