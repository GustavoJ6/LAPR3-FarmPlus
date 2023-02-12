import UI.MainMenuUI;

public class ConsoleMode {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //Utils.filesBootstrapBig();
        //Utils.filesBootstrapSmall();
        MainMenuUI mainMenuUI = new MainMenuUI();
        mainMenuUI.run();
    }

}
