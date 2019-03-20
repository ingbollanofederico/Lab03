package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellchecher.model.Dictionary;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//FXMLLOADER
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SpellChecker.fxml")); //SI USA LOADER perchè lavora con SceneBuilder. Prende il file xml e crea per noi tutti i nodi
			
			
			
			//VIEW
			BorderPane root = (BorderPane)loader.load(); //nodoradice
			Scene scene = new Scene(root);//creazione scena
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			
			//MODEL
			Dictionary model = new Dictionary();//CREAZIONE DEL MODELLO
			
			
			
			//CONTROLLER
			SpellCheckerController controller = (SpellCheckerController)loader.getController();
			controller.setModel(model);
			
			
			
			//display view
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
