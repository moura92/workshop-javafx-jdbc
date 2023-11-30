package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

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
		loadView("/gui/DepartmentList.fxml",(DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();

		});
	}

	@FXML
	public void OnMenuItemAboutAction() { // trata os eventos do menu
		loadView("/gui/About.fxml", x -> {
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	private synchronized <T> void loadView(String absolutName, Consumer<T> initializingAction) { // synchronized garante
																									// que o
																									// processamento não
																									// seja
		// interrompido.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); // pega o primeiro elemento da
																					// View(ScrollPane)

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading View", e.getMessage(), AlertType.ERROR);
		}
	}
}
