package GUI;

public class Exit extends MenuOptionController {

    private String optionNumber = "[4]";
    private String optionName = "Exit";

    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }

}
