package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Warrior2Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior2 extends NewHero {


    private int width;
    private int height;
    Player player;
    Warrior2Factory warrior2Factory;
    HeroType heroType = HeroType.WARRIOR;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewWarrior2(int width, int height, Player player, Warrior2Factory warrior2Factory){
        this.height = height;
        this.width = width;
        this.player = player;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewWarrior2(HeroFactory heroFactory) {
    }


    @Override
    public void MakeHero() {
        partsMove = warrior2Factory.addPartsMove();
        partsAttack = warrior2Factory.addPartsAttack();
        partsSkills = warrior2Factory.addPartsSkills();
    }

}
