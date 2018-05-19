package gameController.Builder;


import gameModel.Factory.HeroFactory;
import gameModel.Factory.Warrior1Factory;
import gameModel.Factory.Warrior2Factory;
import gameModel.Factory.Warrior3Factory;
import gameModel.NewHero.NewHero;
import gameModel.NewHero.NewWarrior;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class WarriorBuilding extends HeroBuilding{
//    NewHero hero;
//
//    public WarriorBuilding(String heroDetails){
//        hero = buildHero(heroDetails);
//    }

    public NewHero buildHero(String heroDetails, int width, int height){
        NewHero hero = null;
        PlayerType playerType;
        String[] fields = heroDetails.split(" ");
        String factoryNumber = fields[1];
        String sPlayerType = fields[2];

        if (sPlayerType.equals(PlayerType.RED.toString()))
            playerType = PlayerType.RED;
        else
            playerType = PlayerType.BLUE;

        HeroFactory heroFactory;
        switch (factoryNumber){
            case "1":
                heroFactory = new Warrior1Factory();
                hero = new NewWarrior(heroFactory,playerType,width,height);
                break;
            case "2":
                heroFactory = new Warrior2Factory();
                hero = new NewWarrior(heroFactory, playerType, width, height);
                break;
            case "3":
                heroFactory = new Warrior3Factory();
                hero = new NewWarrior(heroFactory, playerType, width, height);
                break;
            default:
        }
        return hero;
    }
}
