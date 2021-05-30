package UI;

import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre","Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void ShowMenu(){
        System.out.println("Welcome to appointments");
        System.out.println("Seleccione la opción que desea: ");
        int response = 0;
        do {
            System.out.println("1.-Doctor");
            System.out.println("2.-Patient");
            System.out.println("0.-Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    response=0;
                    System.out.println("Doctor");
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    System.out.println("Doctor");
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Gracias por visitarnos");
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
            }
        }while (response !=0);
    }
    public static void ShowPatientMenu(){
        System.out.println("\n\n");
        System.out.println("Model.Patient Menu");
        int response = 0;
        do {
            System.out.println("1.-Book and appointment");
            System.out.println("2.-My appointments");
            System.out.println("0.-Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i+".-" + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");

                    break;
                case 0:
                    ShowMenu();
                    break;

            }
        }while (response !=0);
    }
    private static void authUser(int userType){
        //userType = 1 Doctor
        //UserType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Doctor 1", "doctor1@gmail.com"));
        doctors.add(new Doctor("Doctor 2", "doctor2@gmail.com"));
        doctors.add(new Doctor("Doctor 3", "doctor3@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Paciente 1", "pciente1@gmail.com"));
        patients.add(new Patient("Paciente 2", "pciente2@gmail.com"));
        patients.add(new Patient("Paciente 3", "pciente3@gmail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Inserta el email");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1){
                for (Doctor d: doctors) {
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener los datos del usuario
                        doctorLogged = d;
                        UIDoctorMenu.ShowDoctorMenu();
                    }
                }

            }
            if (userType==2){
                for (Patient p: patients) {
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener los datos del usuario
                        patientLogged = p;
                        //ShowPatientMenu();
                    }
                }
            }
        }while (!emailCorrect);
    }
}

