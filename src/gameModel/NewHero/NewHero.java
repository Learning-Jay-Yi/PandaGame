package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero{

    public enum HeroType{
        WARRIOR, SUPPORT, RANGER
    }


    protected int moveRange;
    protected int attackRange;
    protected int dodgeChance;

    HeroType heroType;

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public void setMoveRange(int moveRange) {
        this.moveRange = moveRange;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    // this is to spawn the hero on the board
    public abstract void MakeHero();


}
