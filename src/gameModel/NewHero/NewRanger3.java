package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Ranger3Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger3 extends NewHero {


    private int width;
    private int height;
    Player player;
    Ranger3Factory ranger3Factory;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger3(int width, int height, Player player, Ranger3Factory ranger3Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.ranger3Factory = ranger3Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewRanger3(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        partsMove = ranger3Factory.addPartsMove();
        partsAttack = ranger3Factory.addPartsAttack();
        partsSkills = ranger3Factory.addPartsSkills();
    }

    @Override
    public void showBody() {

    }

}
