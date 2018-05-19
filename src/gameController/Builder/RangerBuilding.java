package gameController.Builder;


import gameModel.Factory.*;
import gameModel.NewHero.*;

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

    public NewHero buildHero (String heroDetails){
        NewHero hero = null;
        String[] fields = heroDetails.split(" ");
//        String heroType = fields[0];
        String factoryNumber = fields[1];
        HeroFactory heroFactory;
        switch (factoryNumber){
            case "1":
                heroFactory = new Ranger1Factory();
                hero = new NewRanger(heroFactory);
                break;
            case "2":
                heroFactory = new Ranger2Factory();
                hero = new NewRanger(heroFactory);
                break;
            case "3":
                heroFactory = new Ranger3Factory();
                hero = new NewRanger(heroFactory);
                break;
            default:

        }

        return hero;
    }
}
