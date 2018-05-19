package gameController.Builder;


import gameModel.Factory.*;
import gameModel.NewHero.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class SupportBuilding extends HeroBuilding{
//    NewHero hero;
//
//    public WarriorBuilding(String heroDetails){
//        hero = buildHero(heroDetails);
//    }

    public NewHero buildHero(String heroDetails, int width, int height){
        NewHero hero = null;
        String[] fields = heroDetails.split(" ");
//        String heroType = fields[0];
        String factoryNumber = fields[1];
        HeroFactory heroFactory;
        switch (factoryNumber){
            case "1":
                heroFactory = new Support1Factory();
                hero = new NewSupport(heroFactory);
                break;
            case "2":
                heroFactory = new Support2Factory();
                hero = new NewSupport(heroFactory);
                break;
            case "3":
                heroFactory = new Support3Factory();
                hero = new NewSupport(heroFactory);
                break;
            default:
        }
        return hero;
    }
}
