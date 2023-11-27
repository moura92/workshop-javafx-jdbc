package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartament;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void OnMenuItemSellerAction() { // trata os eventos do menu
		System.out.println("OnMenuItemSellerAction");
	}

	@FXML
	public void OnMenuItemDepartmentAction() { // trata os eventos do menu
		System.out.println("OnMenuItemDepartmentAction");
	}

	@FXML
	public void OnMenuItemAboutAction() { // trata os eventos do menu
		System.out.println("OnMenuItemAboutAction");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
