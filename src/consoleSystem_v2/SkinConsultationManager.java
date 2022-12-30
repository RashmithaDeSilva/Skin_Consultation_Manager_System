package consoleSystem_v2;

import java.util.ArrayList;

public interface SkinConsultationManager {

    public void addNewDoctor();
    public void deleteDoctor();
    public void printDoctorsList();
    public void saveFile();
    public void reloadData();
    public void openGUI();
    public Doctor getDoctor(int position);
    public ArrayList<Doctor> getDoctors();
    public void openGUIWithOption(int GUI_MenuOptionPosition);
    public void setPatient(Patient patient);
    public ArrayList<Patient> getPatients();
    public Patient getPatient(int position);
}
