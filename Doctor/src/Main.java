import Model.Doctor;
import Model.Patient;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        //ShowMenu();
        Doctor doc = new Doctor("nerio", "email@elVergatario.com");
        doc.addAvailableAppointment(new Date(), "4pm");
        doc.addAvailableAppointment(new Date(), "10am");
        doc.addAvailableAppointment(new Date(), "1pm");
        System.out.println(doc);
        //System.out.println(doc.getAvailableAppointment());
     /*   for (Model.Doctor.AvailableAppointment a: doc.getAvailableAppointment()
             ) {
            System.out.println(a.getDate() + " " + a.getTime());

        }*/
        Patient paciente = new Patient("Paciente_Nerio", "pacientenerio@email.com");
        System.out.println(paciente);
    }
}
