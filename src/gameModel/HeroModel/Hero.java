package gameModel.HeroModel;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class Hero {

    PartsAttack partsAttack;
    PartsMove partsMove;
    PartsSkills partsSkills;
    PartsBody partsBody;

    public Hero() {

    }
//    protected int[] validX,validY;

    // create a new hero
    public abstract void MakeHero();
    // this is to spawn the hero on the board
    public abstract void SpawnBody();
    // use to move selected hero
    public abstract void activityMove();
    // use to attack a hero
    public abstract void activityAttack();
    // use to use hero activitySkill
    public abstract void activitySkills();

    public PartsSkills getPartsSkills() {
        return partsSkills;
    }

    public PartsMove getPartsMove() {
        return partsMove;
    }

    public PartsAttack getPartsAttack() {
        return partsAttack;
    }

    public PartsBody getPartsBody() {
        return partsBody;
    }
}
