package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsBody;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior1 extends NewHero {


    private int width;
    private int height;
    Player player;
    HeroFactory heroFactory;

    private PartsAttack partsAttack;
    private PartsMove partsMove;
    private PartsSkills partsSkills;
    private PartsBody partsBody;


    public NewWarrior1(HeroFactory heroFactory) {
        this.heroFactory = heroFactory;
    }


    // hero = body + move + attack + skill

    @Override
    public void MakeHero() {
        partsBody = heroFactory.addPartsBody();
        partsMove = heroFactory.addPartsMove();
        partsAttack = heroFactory.addPartsAttack();
        partsSkills = heroFactory.addPartsSkills();
//        SpawnBody(partsBody);
    }


    private void SpawnBody(PartsBody partsBody){
        int spawnX, spawnY;
//        int boardW =




    }

    public PartsBody getPartsBody() {
        return partsBody;
    }

    public PartsAttack getPartsAttack() {
        return partsAttack;
    }

    public PartsMove getPartsMove() {
        return partsMove;
    }

    public PartsSkills getPartsSkills() {
        return partsSkills;
    }
}
