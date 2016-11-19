package br.edu.utfpr.auditoria.cripto.View;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import br.edu.utfpr.auditoria.cripto.AES;
import br.edu.utfpr.auditoria.cripto.RSA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class MainController implements Initializable{
	
	@FXML
	private ComboBox<Text> cbTipo;
	@FXML
	private ComboBox<Text> cbTamanhoMsg;
	@FXML
	private ComboBox<Text> cbComprimentoChave;
	
	@FXML
	private Label tcripto;
	@FXML
	private Label tdecripto;
	@FXML
	private Label lbUncript;	
	@FXML
	private Button btStart;	
	
	private Collection<Text> tipos = new ArrayList<>();
	private Collection<Text> tamanhos = new ArrayList<>();
	private Collection<Text> comprimentoAES = new ArrayList<>();	
	private Collection<Text> comprimentoRSA = new ArrayList<>();
	
	public String texto = "teste-";
    public String texto2M = "teste-teste-";
    public String texto4M = "teste-teste-teste-teste-";
    public String texto8M = "teste-teste-teste-teste-teste-teste-teste-teste-";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tipos.add(new Text("RSA"));
		tipos.add(new Text("AES"));
		
		tamanhos.add(new Text("M"));
		tamanhos.add(new Text("2M"));
		tamanhos.add(new Text("4M"));
		tamanhos.add(new Text("8M"));
		
		comprimentoAES.add(new Text("128 bits"));
		comprimentoAES.add(new Text("256 bits"));
		
		comprimentoRSA.add(new Text("512"));
		comprimentoRSA.add(new Text("1024"));
		
		// TODO Auto-generated method stub
		cbTipo.getItems().removeAll(cbTipo.getItems());		
		cbTipo.getItems().addAll(tipos);
		cbTipo.setOnAction(onTipo);
		
		btStart.setOnAction(onStart);
		
		cbTamanhoMsg.getItems().addAll(tamanhos);
	}
	
	EventHandler<ActionEvent> onTipo = new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if (cbTipo.getValue().getText().equals("RSA")){
				cbComprimentoChave.setDisable(false);
				cbComprimentoChave.getItems().removeAll(cbComprimentoChave.getItems());	
				cbComprimentoChave.getItems().addAll(comprimentoRSA);
			}
			else if (cbTipo.getValue().getText().equals("AES")){
				cbComprimentoChave.setDisable(true);
				//cbComprimentoChave.getItems().removeAll(cbComprimentoChave.getItems());
				//cbComprimentoChave.getItems().addAll(comprimentoAES);
			}
		}		
	};
	
	EventHandler<ActionEvent> onStart = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			long start = 0;
			long elapsed = 0;
			long total = 0;
			// TODO Auto-generated method stub		
			if (cbTipo.getValue().getText().equals("AES")){
				try {
					String choiced = textSizeChoiced(cbTamanhoMsg.getValue().getText().toString());
					start = System.currentTimeMillis();
					byte[] textoencriptado = AES.encriptar(choiced, AES.chaveencriptacao);
					elapsed = System.currentTimeMillis();
					total = elapsed - start;
					tcripto.setText(total + " ms");					
					total = 0;
					start = System.currentTimeMillis();
					String textodecriptado = AES.decriptar(textoencriptado, AES.chaveencriptacao);
					elapsed = System.currentTimeMillis();
					total = elapsed - start;
					tdecripto.setText(total + " ms");
					lbUncript.setText(textodecriptado);
					total = 0;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			
			if (cbTipo.getValue().getText().equals("RSA")){
				try {
					RSA rsa = new RSA(Integer.parseInt(cbComprimentoChave.getValue().getText()));
					
					String choiced = textSizeChoiced(cbTamanhoMsg.getValue().getText().toString());
					start = System.currentTimeMillis();
					byte[] textoencriptado = rsa.encriptPublic(choiced);
					elapsed = System.currentTimeMillis();
					total = elapsed - start;
					tcripto.setText(total + " ms");
					
					total = 0;
					
					start = System.currentTimeMillis();
					String textodecriptado = rsa.descriptPrivate(textoencriptado);
					elapsed = System.currentTimeMillis();
					total = elapsed - start;
					tdecripto.setText(total + " ms");
					lbUncript.setText(textodecriptado);
					total = 0;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
		}		
	};
	
	public String textSizeChoiced(String choiced){
		if (choiced.equals("M")){
			return this.texto;
		}
		else if (choiced.equals("2M")){
			return this.texto2M;
		}
		else if (choiced.equals("4M")){
			return this.texto4M;
		}
		else if (choiced.equals("8M")){
			return this.texto8M;
		}
		return null;
	}
}
