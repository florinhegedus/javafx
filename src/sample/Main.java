package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.awt.*;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("MEA");

        //Button
        button = new Button("Order Now");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button);

        scene= new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked(){
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String m: movies){
            message += m + " ";
        }

        System.out.println(message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
