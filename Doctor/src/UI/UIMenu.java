package UI;

import Model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre","Noviembre", "Diciembre"};

    public static void ShowMenu(){
        System.out.println("Welcome to appointments");
        System.out.println("Seleccione la opción que desea: ");
        int response = 0;
        do {
            System.out.println("1.-Model.Doctor");
            System.out.println("2.-Model.Patient");
            System.out.println("0.-Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Model.Doctor");
                    response = 0;
                    break;
                case 2:
                    response = 0;
                    ShowPatientMenu();
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
        //userType = 1  Doctor
        //UserType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Nerio Enrique", "neriogonzalez@gmail.com"));
    }
}
