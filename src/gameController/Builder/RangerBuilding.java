package gameController.Builder;


import gameModel.Factory.*;
import gameModel.NewHero.*;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class RangerBuilding extends HeroBuilding{
//    NewHero hero;
//
//    public WarriorBuilding(String heroDetails){
//        hero = buildHero(heroDetails);
//    }

    public NewHero buildHero(String heroDetails, int width, int height){
        NewHero hero = null;
        PlayerType playerType;
        String[] fields = heroDetails.split(" ");
//        String heroType = fields[0];
        String factoryNumber = fields[1];

        String sPlayerType = fields[2];

        if (sPlayerType.equals(PlayerType.RED.toString()))
            playerType = PlayerType.RED;
        else
            playerType = PlayerType.BLUE;
        HeroFactory heroFactory;
        switch (factoryNumber){
            case "1":
                heroFactory = new Ranger1Factory();
                hero = new NewRanger(heroFactory,playerType,width,height);
                break;
            case "2":
                heroFactory = new Ranger2Factory();
                hero = new NewRanger(heroFactory,playerType,width,height);
                break;
            case "3":
                heroFactory = new Ranger3Factory();
                hero = new NewRanger(heroFactory,playerType,width,height);
                break;
            default:

        }

        return hero;
    }
}
