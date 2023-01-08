import consoleSystem_v2.WestminsterSkinConsultationManager;

public class Main {

    public static void main(String[] args) {

        WestminsterSkinConsultationManager WSCM = new WestminsterSkinConsultationManager();
        WSCM.reloadData();

        do{
            int menuNumber = WSCM.mainMenu();
            switch (menuNumber){
                case -1:
                    break;
                case 1:
                    WSCM.addNewDoctor();
                    break;
                case 2:
                    WSCM.deleteDoctor();
                    break;
                case 3:
                    WSCM.printDoctorsList();
                    break;
                case 4:
                    WSCM.saveFile();
                    break;
                case 5:
                    WSCM.openGUI();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid Value .....!\n");
            }
        }while(true);
    }
}
