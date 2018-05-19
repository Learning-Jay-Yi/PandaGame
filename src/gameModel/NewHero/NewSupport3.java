package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Support3Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport3 extends NewHero {


    private int width;
    private int height;
    Player player;
    Support3Factory support3Factory;
    HeroType heroType = HeroType.SUPPORT;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewSupport3(int width, int height, Player player, Support3Factory support3Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.support3Factory = support3Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewSupport3(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        partsMove = support3Factory.addPartsMove();
        partsAttack = support3Factory.addPartsAttack();
        partsSkills = support3Factory.addPartsSkills();
    }

}
