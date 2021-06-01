package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributos

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointment = new ArrayList<>();

    public Doctor(String name, String email) {
        super(name, email);
        //this.speciality = speciality;
        //System.out.println("Contruyendo Model.Doctor " + name);
    }
    //Comportamientos

    public void addAvailableAppointment(String date, String time){

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

        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        //Available appointment

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate( String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
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
