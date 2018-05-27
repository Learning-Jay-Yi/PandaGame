package gameController.Builder;

import gameModel.HeroModel.Hero;


/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 *
 * Description: this class use to receive the order from the player pick hero
 *              and send it to different factories to create hero.
 *              1
 */
public class HeroBuilder {

    public HeroBuilder() {

    }

    public Hero buildHero(String heroDetails, int width, int height){
        Hero hero = null;
        HeroBuilder heroBuilder;
        String[] fields = heroDetails.split(" ");
        String heroType = fields[0];
        // send different order to the spacial factory depend on hero type.
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
