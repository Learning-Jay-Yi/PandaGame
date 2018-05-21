package gameView;

import gameController.NewController.NewProcessController;
import gameController.ProcessController;
import gameModel.Hero;
import gameModel.NewHero.NewHero;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 *
 * @author
 *
 */
public class ActionSelectWindow {

	private boolean bAction = false;
	private Stage action;
	private NewHero newHero;
	private HeroView heroView;
	private ArrayList<HeroView> heroViews;
	private TileView[][] tileArray;
	private NewProcessController processController;

	private Button abilityBtn = new Button("Ability");
	private Button attackBtn = new Button("Attack");
	private Button moveBtn = new Button("Move");


	public ActionSelectWindow(NewHero newHero, HeroView heroView, ArrayList<HeroView> heroViews, TileView[][] tileArray, NewProcessController processController){
		// try to figure out useful parameters
		this.newHero = newHero;
		this.heroView = heroView;
		this.heroViews = heroViews;
		this.tileArray = tileArray;
		this.processController = processController;
		//TODO
	}

	public void display(){
		//TODO
		action = new Stage();

		action.initModality(Modality.APPLICATION_MODAL);
		action.setTitle("Actions");

		Label label = new Label("which adction do you want choose?");

		HBox hBox = getActionWindow();

		GridPane pane = new GridPane();

		pane.add(label,0,0);
		pane.add(hBox,0,1);
		Scene scene = new Scene(pane);
		action.setScene(scene);
		action.showAndWait();





		//see TurnCheckerAlarm
	}


	private HBox getActionWindow(){
		HBox buttons = new HBox();

		setAbilityBtn();
		setAttackBtn();
		setMoveBtn();

		buttons.getChildren().add(abilityBtn);
		buttons.getChildren().add(attackBtn);
		buttons.getChildren().add(moveBtn);



		//TODO
		return buttons;
	}

	/******* at end of button, need to close ActionWindow: see TurnCheckerAlarm***********/
	private void setAbilityBtn(){
		abilityBtn.setOnAction(e->{
			//TODO
		});
	}

	private void setAttackBtn(){
		attackBtn.setOnAction(e->{
			//TODO
		});
	}

	private void setMoveBtn() {
		moveBtn.setOnAction(e -> {
			newHero.getPartsMove().CanMove(heroView.getLocX(), heroView.getLocY());

			int[] validX = newHero.getPartsMove().getValidX();
			int[] validY = newHero.getPartsMove().getValidY();
			int length = validX.length;

			for (int i = 0; i < length; i++) {
//				showValidTiles(tileArray,validX[i],validY[i]);
				int x = validX[i];
				int y = validY[i];
				tileArray[x][y].canMove();
			}

			processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(),
					heroView.getLocX(),heroView.getLocY());

			action.close();
		});
	}

}
