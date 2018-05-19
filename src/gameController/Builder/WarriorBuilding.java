package gameController.Builder;


import gameModel.Factory.HeroFactory;
import gameModel.Factory.Warrior1Factory;
import gameModel.Factory.Warrior2Factory;
import gameModel.Factory.Warrior3Factory;
import gameModel.NewHero.NewHero;
import gameModel.NewHero.NewWarrior1;
import gameModel.NewHero.NewWarrior2;
import gameModel.NewHero.NewWarrior3;

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

    public NewHero buildHero (String heroDetails){
        NewHero hero = null;
        String[] fields = heroDetails.split(" ");
//        String heroType = fields[0];
        String factoryNumber = fields[1];
        HeroFactory heroFactory;
        switch (factoryNumber){
            case "1":
                heroFactory = new Warrior1Factory();
                hero = new NewWarrior1(heroFactory);
            case "2":
                heroFactory = new Warrior2Factory();
                hero = new NewWarrior2(heroFactory);
            case "3":
                heroFactory = new Warrior3Factory();
                hero = new NewWarrior3(heroFactory);
            default:

        }
        return hero;
    }
}
