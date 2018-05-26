package gameController.Builder;

import gameModel.HeroModel.Hero;


/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public class HeroBuilder {
    Hero hero;

    public HeroBuilder() {

    }

    public Hero buildHero(String heroDetails, int width, int height){
        Hero hero = null;
        HeroBuilder heroBuilder;
        String[] fields = heroDetails.split(" ");
        String heroType = fields[0];
        String factoryNumber = fields[1];
        int spawnY = Integer.valueOf(fields[3]);
        switch (heroType){
            case "Warrior":
                heroBuilder = new WarriorBuilder();
                hero = heroBuilder.buildHero(heroDetails, width, height);
                break;
            case "Ranger":
                heroBuilder = new RangerBuilder();
                hero = heroBuilder.buildHero(heroDetails, width, height);
                break;
            case "Support":
                heroBuilder = new SupportBuilder();
                hero = heroBuilder.buildHero(heroDetails, width, height);
                break;
            default:
        }

        return hero;
    }

}
