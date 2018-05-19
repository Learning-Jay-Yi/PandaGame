package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Support2Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport2 extends NewHero {


    private int width;
    private int height;
    Player player;
    Support2Factory support2Factory;
    HeroType heroType = HeroType.SUPPORT;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewSupport2(int width, int height, Player player, Support2Factory support2Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.support2Factory = support2Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewSupport2(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        partsMove = support2Factory.addPartsMove();
        partsAttack = support2Factory.addPartsAttack();
        partsSkills = support2Factory.addPartsSkills();
    }

}
