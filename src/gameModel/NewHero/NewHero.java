package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero{

    public NewHero() {

    }
    protected int[] validX,validY;

    // this is to spawn the hero on the board
    public abstract void MakeHero();

    public abstract void showBody();


}
