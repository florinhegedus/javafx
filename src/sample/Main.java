package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("MEA");

        //Checkboxes
        CheckBox box1 = new CheckBox("Rock");
        CheckBox box2 = new CheckBox("Jazz");
        box2.setSelected(true);

        //Button
        button = new Button("Order Now");
        button.setOnAction(e -> handleOptions(box1, box2));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(box1, box2, button);

        scene= new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "Users preferred genres: ";
        if(box1.isSelected())
            message += "rock ";
        if(box2.isSelected())
            message += "jazz ";
        System.out.println(message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
