package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport extends NewHero {

    private int width;
    private int height;
    Player player;
    HeroFactory heroFactory;

    public NewSupport(HeroFactory heroFactory) {
        this.heroFactory = heroFactory;
    }


    // hero = body + move + attack + skill

    @Override
    public void MakeHero() {
        System.out.println("Add Hero body: ");
        partsBody = heroFactory.addPartsBody();
        partsMove = heroFactory.addPartsMove();
        partsAttack = heroFactory.addPartsAttack();
        partsSkills = heroFactory.addPartsSkills();
    }

    @Override
    public void SpawnBody(){

        partsBody.PartsBody(20,15,(new Player(Player.PlayerType.RED,1,"abc")));
    }

    @Override
    public void Move() {
//        partsMove.PartsMove();
    }

    @Override
    public void Attack() {

    }

    @Override
    public void UseSkills() {

    }

}
