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
import java.util.Stack;

public class Main extends Application {

    Stage window;
    Scene scene;
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("MEA");

        TreeItem<String> root, bucky, megan;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("item1", bucky);
        makeBranch("item2", bucky);
        makeBranch("item3", bucky);

        //Megan
        megan = makeBranch("Megan", root);
        makeBranch("item4", megan);
        makeBranch("item5", megan);

        //Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null)
                System.out.println(newValue.getValue());
        });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        scene= new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
