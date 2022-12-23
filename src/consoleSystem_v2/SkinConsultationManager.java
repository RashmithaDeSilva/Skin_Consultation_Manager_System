package consoleSystem_v2;

import java.util.ArrayList;

public interface SkinConsultationManager {

    public void addNewDoctor();
    public void deleteDoctor();
    public void printDoctorsList();
    public void saveFile();
    public void openGUI();
    public Doctor getDoctor(int position);
    public ArrayList<Doctor> getDoctors();
    public void openGUIWithOption(int GUI_MenuOptionPosition);
    public void setAllPatientID(String ID);
    public String getAllPatientID(int position);
    public ArrayList<String> getAllPatientIDs();
}
