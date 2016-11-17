package br.edu.utfpr.auditoria.cripto.View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXML;

public class MainController implements Initializable{
	
	@FXML
	private ComboBox cbTipo;
	@FXML
	private ComboBox cbTamanhoMsg;
	@FXML
	private ComboBox cbComprimentoChave;
	@FXML
	private Label lbTempo;
	
	public MainController(){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Option 1",
			        "Option 2",
			        "Option 3"
			    );
		this.cbTipo = new ComboBox (options);
	}

}
