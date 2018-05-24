package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport extends NewHero {

    private int width;
    private int height;
    PlayerType playerType;
    HeroFactory heroFactory;
    int spawnY;
    RoleType roleType = RoleType.SUPPORT;

    public NewSupport(HeroFactory heroFactory, PlayerType playerType, int width, int height,int spawnY) {
        this.width = width;
        this.height = height;
        this.playerType = playerType;
        this.heroFactory = heroFactory;
        this.spawnY = spawnY;
    }


    // hero = body + move + attack + activitySkill

    @Override
    public void MakeHero() {
        partsBody = heroFactory.addPartsBody();
        partsMove = heroFactory.addPartsMove();
        partsAttack = heroFactory.addPartsAttack();
        partsSkills = heroFactory.addPartsSkills();
//        fromFactoryNum = heroFactory.getFactoryNumber();
    }

    @Override
    public void SpawnBody(){
        partsBody.spawnBody(width,height,playerType,spawnY);
    }

    @Override
    public void activityMove() {
        partsMove.activityMove(width,height);
    }

    @Override
    public void activityAttack() {
        partsAttack.activityAttack(width,height,playerType,roleType);
    }

    @Override
    public void activitySkills() {
        partsSkills.activitySkill(width,height,playerType,roleType);
    }



}
