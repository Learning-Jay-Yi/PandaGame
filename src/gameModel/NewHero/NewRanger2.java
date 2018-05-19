package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Ranger2Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger2 extends NewHero {


    private int width;
    private int height;
    Player player;
    Ranger2Factory ranger2Factory;
    HeroType heroType = HeroType.RANGER;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger2(int width, int height, Player player, Ranger2Factory ranger2Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.ranger2Factory = ranger2Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewRanger2(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        partsMove = ranger2Factory.addPartsMove();
        partsAttack = ranger2Factory.addPartsAttack();
        partsSkills = ranger2Factory.addPartsSkills();
    }

}
