package gameView;

import gameController.NewController.NewProcessController;
import gameModel.NewHero.NewHero;
import gameModel.RoleType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	boolean useSkill;

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

	}

	public void display(){
		action = new Stage();

		action.initModality(Modality.APPLICATION_MODAL);
		action.setTitle("Actions");

		Label label = new Label("which action do you want choose?");

		HBox hBox = getActionWindow();

		GridPane pane = new GridPane();

		pane.add(label,0,0);
		pane.add(hBox,0,1);
		Scene scene = new Scene(pane);
		action.setScene(scene);
		action.showAndWait();
	}

	public Stage getWindow(){
		return action;
	}
	private HBox getActionWindow(){
		boolean useSkill = false;

		HBox buttons = new HBox();

		setAttackBtn();
		setMoveBtn();
		setAbilityBtn();

		buttons.getChildren().add(abilityBtn);
		buttons.getChildren().add(attackBtn);
		buttons.getChildren().add(moveBtn);
		return buttons;
	}

	/******* at end of button, need to close ActionWindow: see TurnCheckerAlarm***********/
	private void setAbilityBtn(){
		abilityBtn.setOnAction(e->{
			System.out.println("Skill used");
			int skillNum = newHero.getPartsSkills().getSkillType();
			String skillName = "";
			switch (skillNum){
				case 1: skillName = "Skill for move";
					break;
				case 2: skillName = "Skill for attack";
					break;
				case 3: skillName = "Skill for dodge";
			}
			useSkill = newHero.getPartsSkills().usedSkill();
			if(skillNum == 3){
				// invincible
			}else {
				if(!useSkill){
					useSkill = true;
					System.out.println("now you use "+skillName);
					newHero.getPartsSkills().setUsedSkill(useSkill);
				}
//				else {
//					// may be not need to use here
//					System.out.println("now you use the skill");
//					abilityBtn.setDisable(true);
//				}
			}
			abilityBtn.setDisable(true);
		});
	}

	private void setAttackBtn(){
		attackBtn.setOnAction(e->{

			int[] validX = null ,validY = null ;
			int length = 0;

			if(useSkill){
				newHero.getPartsSkills().skill(heroView.getLocX(),heroView.getLocY());
				validX = newHero.getPartsSkills().getValidX();
				validY = newHero.getPartsSkills().getValidY();
				length = validX.length;
			}else{
				newHero.getPartsAttack().CanAttack(heroView.getLocX(),heroView.getLocY());
				validX = newHero.getPartsAttack().getValidX();
				validY = newHero.getPartsAttack().getValidY();
				length = validX.length;
			}

			if (length != 0){
				for (int i = 0; i < length; i++) {
//				showValidTiles(tileArray,validX[i],validY[i]);
					int x = validX[i];
					int y = validY[i];
					tileArray[x][y].canAttack();
					//if there have a hero then can attack;
					heroView.setStatus(true);
				}
			}

			processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(),
					heroView.getLocX(),heroView.getLocY());
			action.close();
//			abilityBtn.setDisable(true);
		});
	}

	private void setMoveBtn() {
		moveBtn.setOnAction(e -> {

			int[] validX = null ,validY = null ;
			int length = 0;

			if (useSkill){
				newHero.getPartsSkills().skill(heroView.getLocX(), heroView.getLocY());
				validX = newHero.getPartsSkills().getValidX();
				validY = newHero.getPartsSkills().getValidY();
				length = validX.length;
			}else {
				newHero.getPartsMove().CanMove(heroView.getLocX(), heroView.getLocY());
				validX = newHero.getPartsMove().getValidX();
				validY = newHero.getPartsMove().getValidY();
				length = validX.length;
			}





			int oldX = heroView.getLocX();
			int oldY = heroView.getLocY();

			checkMoveEffect(validX, validY, tileArray, heroView);

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

	public Button getMoveBtn(){
		return moveBtn;
	}


	private void checkMoveEffect(int[] validX, int[] validY, TileView[][] tileArray, HeroView heroView){
		int oldX = heroView.getLocX();
		int oldY = heroView.getLocY();

		for(int i = 0; i < validX.length; i++){
			if(oldX == validX[i]){
				if(oldY - validY[i] > 0){
					for(int y = oldY - 1; y > validY[i]; y--){
						if(tileArray[oldX][y].getEffectValue() == 1){
							validY[i] = y + 1;
						}
					}
				}else{
					for(int y = oldY + 1; y < validY[i]; y++){
						if(tileArray[oldX][y].getEffectValue() == 1){
							validY[i] = y - 1;
						}
					}
				}
			}else if(oldY == validY[i]){
				if(oldX - validX[i] > 0){
					for(int x = oldX - 1; x > validX[i]; x--){
						if(tileArray[x][oldY].getEffectValue() == 1){
							validX[i] = x + 1;
						}
					}
				}else{
					for(int x = oldX + 1; x < validX[i]; x++){
						if(tileArray[x][oldY].getEffectValue() == 1){
							validX[i] = x - 1;
						}
					}
				}
			}else{
				if(oldX - validX[i] > 0){
					if(oldY - validY[i] > 0){
						for(int x = oldX - 1, y = oldY - 1; x > validX[i]; x--, y--){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x + 1;
								validY[i] = y + 1;
							}
						}
					}else{
						for(int x = oldX - 1, y = oldY + 1; x > validX[i]; x--, y++){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x + 1;
								validY[i] = y - 1;
							}
						}
					}
				}else{
					if(oldY - validY[i] > 0){
						if(oldY - validY[i] > 0){
							for(int x = oldX + 1, y = oldY - 1; x < validX[i]; x++, y--){
								if(tileArray[x][y].getEffectValue() == 1){
									validX[i] = x - 1;
									validY[i] = y + 1;
								}
							}
						}
					}else{
						for(int x = oldX + 1, y = oldY + 1; x < validX[i]; x++, y++){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x - 1;
								validY[i] = y - 1;
							}
						}
					}
				}
			}
		}
	}
}
