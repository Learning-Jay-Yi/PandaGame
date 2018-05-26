package gameController.Builder;


import gameModel.FactoryModel.HeroFactory;
import gameModel.FactoryModel.Warrior1Factory;
import gameModel.FactoryModel.Warrior2Factory;
import gameModel.FactoryModel.Warrior3Factory;
import gameModel.HeroModel.Hero;
import gameModel.HeroModel.Warrior;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class WarriorBuilder extends HeroBuilder {
//    HeroModel hero;
//
//    public WarriorBuilder(String heroDetails){
//        hero = buildHero(heroDetails);
//    }

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
        switch (factoryNumber){
            case "1":
                heroFactory = new Warrior1Factory();
                hero = new Warrior(heroFactory,playerType,width,height,spawnY);
                break;
            case "2":
                heroFactory = new Warrior2Factory();
                hero = new Warrior(heroFactory, playerType, width, height,spawnY);
                break;
            case "3":
                heroFactory = new Warrior3Factory();
                hero = new Warrior(heroFactory, playerType, width, height,spawnY);
                break;
            default:
        }
        return hero;
    }
}
