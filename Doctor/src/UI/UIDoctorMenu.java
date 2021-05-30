package UI;

import java.util.Scanner;

public class UIDoctorMenu {
    public static void ShowDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Wellcome Doctor: "+UIMenu.doctorLogged.getName());
            System.out.println("1.-Add available appointment");
            System.out.println("2.-My scheduled appointmets");
            System.out.println("0.-Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
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
        int response = 0;
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
                System.out.println("Estas en el mes de " + UIMenu.MONTHS[monthSelected]);
                System.out.println("Insert date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your Date is: " + date + "\n1.-Correct. \n2.-Change date");
                //hasta aquí

            }else  if (response ==0) {
                ShowDoctorMenu();
            }
            
        }while(response !=0);

    }
}
