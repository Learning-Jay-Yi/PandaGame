package gameController.Builder;

import gameModel.NewHero.NewHero;


/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public class HeroBuilding {
    NewHero hero;

    public HeroBuilding() {

    }

    public NewHero buildHero (String heroDetails){
        NewHero hero = null;
        HeroBuilding heroBuilding;
        String[] fields = heroDetails.split(" ");
        String heroType = fields[0];
        String factoryNumber = fields[1];
        switch (heroType){
            case "Warrior":
                heroBuilding= new WarriorBuilding();
                hero = heroBuilding.buildHero(heroDetails);
                break;
            case "Ranger":
                heroBuilding = new RangerBuilding();
                hero = heroBuilding.buildHero(heroDetails);
                break;
            case "Support":
                heroBuilding = new SupportBuilding();
                hero = heroBuilding.buildHero(heroDetails);
                break;
            default:
        }

        return hero;
    }

}
