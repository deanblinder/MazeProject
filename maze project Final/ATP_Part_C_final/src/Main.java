import Model.*;
import Server.Configurations;
import View.MyViewController;
import ViewModel.MyViewModel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
//import jdk.nashorn.internal.runtime.options.Options;
//import sun.net.dns.ResolverConfiguration;

import java.util.Optional;

public class Main extends Application {
//    static Stage window;
//    static MyViewController MainController;
//    public static MyViewController getMainController(){
//        return MainController;
//    }
//    public static Stage getWindow(){
//        return window;
//    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
        Configurations.setConfiguration("generator","SimpleMazeGenerator");
        Configurations.setConfiguration("searchAlgo","BestFirstSearch");
        MyModel model = new MyModel();
        model.startServers();
        MyViewModel myViewModel = new MyViewModel(model);
        model.addObserver(myViewModel);

        //--------------
        primaryStage.setTitle("My Application!");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("View/MyView.fxml").openStream());
        Scene scene = new Scene(root, 800, 700);
        scene.getStylesheets().add(getClass().getResource("View/View.css").toExternalForm());
        primaryStage.setScene(scene);

        //--------------
        MyViewController view = fxmlLoader.getController();
        view.setStage(primaryStage);
        view.setResizeEvent(scene);
        view.setMyViewModel(myViewModel);
        myViewModel.addObserver(view);
        //--------------

        SetStageCloseEvent(primaryStage);
        primaryStage.show();

    }

    private void SetStageCloseEvent(Stage primaryStage) {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to exit?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    // Close program
                } else {
                    // ... user chose CANCEL or closed the dialog
                    windowEvent.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
