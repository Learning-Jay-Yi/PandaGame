package gameController.NewController;

import java.util.ArrayList;

import gameController.Controller.ProcessController;
import gameModel.MoveBlock;
import gameModel.HeroModel.Hero;
import gameModel.HeroModel.HeroType;
import gameView.HeroView.HeroView;
import gameView.MainView.TileView;
import gameView.PopUpView.ActionSelectWindow;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 20/05/208
 *
 */
public class ActionButtonController {

//	private boolean bAction = false;
	private ActionSelectWindow action;
	private Hero hero;
	private HeroView heroView;
	private ArrayList<HeroView> heroViews;
	private TileView[][] tileArray;
	private ProcessController processController;
	private boolean useSkill;
	private int skillNum;

	private Button abilityBtn;
	private Button attackBtn;
	private Button moveBtn;


	public ActionButtonController(Hero hero, HeroView heroView, ArrayList<HeroView> heroViews, TileView[][] tileArray, ProcessController processController, ActionSelectWindow action){
		this.hero = hero;
		this.heroView = heroView;
		this.heroViews = heroViews;
		this.tileArray = tileArray;
		this.processController = processController;
		this.abilityBtn = action.getAbilityBtn();
		this.attackBtn = action.getAttackBtn();
		this.moveBtn = action.getMoveBtn();
		this.action = action;
		setAttackBtn();
		setMoveBtn();
		setAbilityBtn();

	}

	private void setAbilityBtn(){
		abilityBtn.setOnAction(e->{
			skillNum = hero.getPartsSkills().getSkillType();
			String skillName = "";
			switch (skillNum){
				case 1: skillName = "Skill for attack";
					break;
				case 2: skillName = "Skill for move";
					break;
				case 3: skillName = "Skill for dodge";
			}
			useSkill = hero.getPartsSkills().usedSkill();
			if(skillNum == 3){
				System.out.println(hero.getPartsBody().getRoleType()+" now you use "+skillName+" did't work.");

				// invincible
			}else {
				if(!useSkill){
					// if never use the skill then can use it
					useSkill = true;
					System.out.println(hero.getPartsBody().getRoleType()+" now you use "+skillName);
					hero.getPartsSkills().setUsedSkill(useSkill);
				}
			}
			abilityBtn.setDisable(true);
		});
	}

	private void setAttackBtn(){
		attackBtn.setOnAction(e->{

			int[] validX, validY;
			int length;

			if(useSkill){
				if(skillNum == 1){
					// skill for attack
					HeroType heroType = hero.getPartsBody().getRoleType();
					hero.getPartsSkills().skill(heroView.getLocX(),heroView.getLocY(), heroType);
					validX = hero.getPartsSkills().getValidX();
					validY = hero.getPartsSkills().getValidY();
					length = validX.length;
				}else {
					// no use skill
					hero.getPartsAttack().CanAttack(heroView.getLocX(),heroView.getLocY());
					validX = hero.getPartsAttack().getValidX();
					validY = hero.getPartsAttack().getValidY();
					length = validX.length;
				}
			}else{
				// not use skill
				hero.getPartsAttack().CanAttack(heroView.getLocX(),heroView.getLocY());
				validX = hero.getPartsAttack().getValidX();
				validY = hero.getPartsAttack().getValidY();
				length = validX.length;
			}

			if (length != 0){
				for (int i = 0; i < length; i++) {
					int x = validX[i];
					int y = validY[i];
					tileArray[x][y].canAttack();
					//if there have a hero then can attack;
					if (tileArray[x][y].getHeroView() != null)
						heroView.setStatus(true);
				}
			}

			processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(), hero,
					heroView.getLocX(),heroView.getLocY());
			action.getWindow().close();
		});
	}

	private void setMoveBtn() {
		moveBtn.setOnAction(e -> {

			int[] validX = null ,validY = null ;
			int length = 0;

			if (useSkill){
				if (skillNum == 2){
					HeroType heroType = hero.getPartsBody().getRoleType();
					hero.getPartsSkills().skill(heroView.getLocX(), heroView.getLocY(), heroType);
					validX = hero.getPartsSkills().getValidX();
					validY = hero.getPartsSkills().getValidY();
					length = validX.length;
				}else {
					hero.getPartsMove().CanMove(heroView.getLocX(), heroView.getLocY());
					validX = hero.getPartsMove().getValidX();
					validY = hero.getPartsMove().getValidY();
					length = validX.length;
				}
			}else {
				hero.getPartsMove().CanMove(heroView.getLocX(), heroView.getLocY());
				validX = hero.getPartsMove().getValidX();
				validY = hero.getPartsMove().getValidY();
				length = validX.length;
			}

			MoveBlock block = new MoveBlock(validX, validY, tileArray, heroView);

			validX = block.getValidX();
			validY = block.getValidY();

			for (int i = 0; i < length; i++) {

				int x = validX[i];
				int y = validY[i];
				tileArray[x][y].canMove();
			}

			processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(), hero,
					heroView.getLocX(),heroView.getLocY());

			action.getWindow().close();
		});
	}

}