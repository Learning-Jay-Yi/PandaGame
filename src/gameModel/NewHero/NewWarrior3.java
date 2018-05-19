package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Warrior3Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior3 extends NewHero {


    private int width;
    private int height;
    Player player;
    Warrior3Factory warrior3Factory;
    HeroType heroType = HeroType.WARRIOR;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewWarrior3(int width, int height, Player player, Warrior3Factory warrior3Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.warrior3Factory = warrior3Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewWarrior3(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        partsMove = warrior3Factory.addPartsMove();
        partsAttack = warrior3Factory.addPartsAttack();
        partsSkills = warrior3Factory.addPartsSkills();
    }

}
