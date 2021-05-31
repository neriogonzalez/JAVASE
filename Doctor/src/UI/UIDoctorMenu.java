package UI;

import Model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();
    public static void ShowDoctorMenu(){
        int response ;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome Doctor: "+UIMenu.doctorLogged.getName());
            System.out.println("1.-Add available appointment");
            System.out.println("2.-My scheduled appointmets");
            System.out.println("0.-Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.ShowMenu();
                    break;
            }
        }while(response!=0);
    }
    private static void showAvailableAppointmentsMenu(){
        int response;
        do {
            System.out.println("\n\n");
            System.out.println("::Add Available Appointments");
            System.out.println("::Select a month: ");
            for (int i = 0; i < 3; i++) {
                int j = i+1;
                System.out.println(j + ".-" + UIMenu.MONTHS[i]);

            }
            System.out.println("0.- Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if (response > 0 && response < 4) {
                //1,2,3
                int monthSelected = response;
                System.out.println("Estas en el mes de " + UIMenu.MONTHS[monthSelected-1]);
                System.out.println("Insert date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                //Fecha
                System.out.println("Your Date is: " + date + "\n1.-Correct. \n2.-Change date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                //Hora

                int responseTime = 0;
                String time ="";
                do {
                    System.out.println("Insert the time available for date: " + date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time  is: " + time + "\n1.-Correct. \n2.-Change time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime ==2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointment(UIMenu.doctorLogged);



            }else  if (response ==0) {
                ShowDoctorMenu();
            }
            
        }while(response !=0);

    }

    private static void checkDoctorAvailableAppointment(Doctor doctor){
        if (doctor.getAvailableAppointment().size()>0
        && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
