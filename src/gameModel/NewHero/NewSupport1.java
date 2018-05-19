package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Support1Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport1 extends NewHero {


    private int width;
    private int height;
    Player player;
    Support1Factory support1Factory;
    HeroType heroType = HeroType.SUPPORT;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewSupport1(int width, int height, Player player, Support1Factory support1Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.support1Factory = support1Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewSupport1(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        partsMove = support1Factory.addPartsMove();
        partsAttack = support1Factory.addPartsAttack();
        partsSkills = support1Factory.addPartsSkills();
    }

}
