package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero{

    PartsAttack partsAttack;
    PartsMove partsMove;
    PartsSkills partsSkills;
    PartsBody partsBody;

    public NewHero() {

    }
//    protected int[] validX,validY;

    // create a new hero
    public abstract void MakeHero();
    // this is to spawn the hero on the board
    public abstract void SpawnBody();
    // use to move selected hero
    public abstract void Move();
    // use to attack a hero
    public abstract void Attack();
    // use to use hero skill
    public abstract void UseSkills();



}
