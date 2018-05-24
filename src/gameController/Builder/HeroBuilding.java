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

    public NewHero buildHero(String heroDetails, int width, int height){
        NewHero hero = null;
        HeroBuilding heroBuilding;
        String[] fields = heroDetails.split(" ");
        String heroType = fields[0];
        String factoryNumber = fields[1];
        int spawnY = Integer.valueOf(fields[3]);
        switch (heroType){
            case "Warrior":
                heroBuilding= new WarriorBuilding();
                hero = heroBuilding.buildHero(heroDetails, width, height);
                break;
            case "Ranger":
                heroBuilding = new RangerBuilding();
                hero = heroBuilding.buildHero(heroDetails, width, height);
                break;
            case "Support":
                heroBuilding = new SupportBuilding();
                hero = heroBuilding.buildHero(heroDetails, width, height);
                break;
            default:
        }

        return hero;
    }

}
