package brickGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The {@code Main} class serves as the entry point for the JavaFX application.
 * It extends {@link javafx.application.Application} and provides the main method
 * to launch and start the graphical user interface (GUI) of the game.
 *
 * <p>The class includes the {@link #start(Stage)} method, where the primary stage
 * and the game components are initialized and displayed.
 *
 * @author [Wong Yu Le]
 * @version 1.0
 */
public class Main extends Application {

    private static GameInitializer gameInitializer;
    private static UIController uiController;
    private static BackgroundMusic backgroundMusic;
    public static String savePath    = "D:/save/save.mdds";
    String mediaPath = "src/main/resources/GameMusic.mp3";
    public static Scene scene;
    /**
     * Loads an FXML file and returns the root element of the corresponding scene graph.
     *
     * @param fxml The name of the FXML file (without the file extension) to be loaded.
     * @return The root element of the scene graph loaded from the specified FXML file.
     * @throws IOException If an I/O error occurs during the loading of the FXML file.
     */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    /**
     * Overrides the start method of the Application class.
     * Initializes various components such as UIController, GameInitializer,
     * BackgroundMusic. Starts background music if it is not playing,
     * and initializes the UI through UIController.
     *
     * @param primaryStage The primary stage for the JavaFX application.
     * @throws Exception If an exception occurs during the initialization or execution of the start method.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize UIController if not already initialized
        if (uiController == null) {
            uiController = new UIController(this, primaryStage);
        }

        // Initialize GameInitializer if not already initialized
        if (gameInitializer == null) {
            gameInitializer = new GameInitializer();
        }

        // Initialize BackgroundMusic if not already initialized
        if (backgroundMusic == null) {
            backgroundMusic = new BackgroundMusic(mediaPath);
        }

        // Start playing background music if it is not already playing
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.play();
        }

        // Initialize the UI through UIController
        uiController.initializeUI();
    }

    /**
     * The main entry point for the JavaFX application.
     *
     * @param args Command-line arguments passed to the application (not used in this example).
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    /**
     * Retrieves the UIController instance associated with the application.
     *
     * @return The UIController instance.
     */
    public static UIController getUiController() {
        return uiController;
    }

    /**
     * Retrieves the GameInitializer instance associated with the application.
     *
     * @return The GameInitializer instance.
     */
    public static GameInitializer getGameInitializer() {
        return gameInitializer;
    }

    /**
     * Retrieves the BackgroundMusic instance associated with the application.
     *
     * @return The BackgroundMusic instance.
     */
    public static BackgroundMusic getBackgroundMusic() {
        return backgroundMusic;
    }

}