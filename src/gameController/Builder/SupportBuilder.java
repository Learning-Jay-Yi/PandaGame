package gameController.Builder;


import gameModel.FactoryModel.*;
import gameModel.HeroModel.*;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 * Description: this class is to identify what the spacial skill need to add to hero,
 *              also, use the Spawn Y to relocate the first Y
 *              1
 */
public class SupportBuilder extends HeroBuilder {

    public Hero buildHero(String heroDetails, int width, int height){
        Hero hero = null;
        PlayerType playerType;
        String[] fields = heroDetails.split(" ");
        String factoryNumber = fields[1];
        String sPlayerType = fields[2];
        int spawnY = Integer.valueOf(fields[3]);

        // to initial the player type
        if (sPlayerType.equals(PlayerType.RED.toString()))
            playerType = PlayerType.RED;
        else
            playerType = PlayerType.BLUE;


        HeroFactory heroFactory;
        switch (factoryNumber){
            case "1":
                heroFactory = new Support1Factory();
                hero = new Support(heroFactory,playerType,width,height,spawnY);
                break;
            case "2":
                heroFactory = new Support2Factory();
                hero = new Support(heroFactory,playerType,width,height,spawnY);
                break;
            case "3":
                heroFactory = new Support3Factory();
                hero = new Support(heroFactory,playerType,width,height,spawnY);
                break;
            default:
        }
        return hero;
    }
}
