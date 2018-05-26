package gameController.Builder;


import gameModel.FactoryModel.*;
import gameModel.HeroModel.*;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 *
 * Description: this class is to identify what the spacial skill need to add to hero,
 *              also, use the Spawn Y to relocate the first Y
 */
public class RangerBuilder extends HeroBuilder {

    public Hero buildHero(String heroDetails, int width, int height){
        Hero hero = null;
        PlayerType playerType;
        String[] fields = heroDetails.split(" ");
        String factoryNumber = fields[1];

        String sPlayerType = fields[2];
        int spawnY = Integer.valueOf(fields[3]);

        if (sPlayerType.equals(PlayerType.RED.toString()))
            playerType = PlayerType.RED;
        else
            playerType = PlayerType.BLUE;
        HeroFactory heroFactory;

        // to create the spacial skill for different hero
        // SpawnY is use to relocate the first Y.
        switch (factoryNumber){
            case "1":
                heroFactory = new Ranger1Factory();
                hero = new Ranger(heroFactory,playerType,width,height,spawnY);
                break;
            case "2":
                heroFactory = new Ranger2Factory();
                hero = new Ranger(heroFactory,playerType,width,height,spawnY);
                break;
            case "3":
                heroFactory = new Ranger3Factory();
                hero = new Ranger(heroFactory,playerType,width,height,spawnY);
                break;
            default:

        }

        return hero;
    }
}
