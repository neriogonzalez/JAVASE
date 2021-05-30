package Model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributos

    private String speciality;

    public Doctor(String name, String email) {
        super(name, email);
        this.speciality = speciality;
        System.out.println("Contruyendo Model.Doctor " + name);
    }
    //Comportamientos
       ArrayList<AvailableAppointment> availableAppointment = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointment.add(new AvailableAppointment (date, time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointment(){
        return availableAppointment;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + " Speciality: " + speciality +
                "\nAvailable: " + availableAppointment.toString()   ;
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Verde.");
        System.out.println("Departamento: Oncología.");
    }

    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        //Available appointment

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointment \nDate: " + getDate() + "\nTime: " + getTime();
        }
    }
}
