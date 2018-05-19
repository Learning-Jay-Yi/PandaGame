package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Ranger1Factory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger1 extends NewHero {


    private int width;
    private int height;

    private int moveRange;
    private int attackRange;
    private int dodgeChance;


    Player player;
    Ranger1Factory ranger1Factory;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger1(int width, int height, Player player, Ranger1Factory ranger1Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.ranger1Factory = ranger1Factory;
    }


    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;

    public NewRanger1(HeroFactory heroFactory) {

    }


    public int getMoveRange() {
        return moveRange;
    }


    public int getAttackRange() {
        return attackRange;
    }


    public int getDodgeChance() {
        return dodgeChance;
    }

    @Override
    public void MakeHero() {
        partsMove = ranger1Factory.addPartsMove();
        partsAttack = ranger1Factory.addPartsAttack();
        partsSkills = ranger1Factory.addPartsSkills();
    }

    @Override
    public void SpawnBody() {

    }

    @Override
    public void Move() {

    }

    @Override
    public void Attack() {

    }

    @Override
    public void UseSkills() {

    }

}
