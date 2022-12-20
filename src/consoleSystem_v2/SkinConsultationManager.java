package consoleSystem_v2;

import java.util.ArrayList;

public interface SkinConsultationManager {

    public void addNewDoctor();
    public void deleteDoctor();
    public void printDoctorsList();
    public void saveFile();
    public void openGUI();
    public ArrayList<Doctor> getDoctors();
}
