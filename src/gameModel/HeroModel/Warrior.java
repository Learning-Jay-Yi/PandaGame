package gameModel.HeroModel;

import gameModel.FactoryModel.HeroFactory;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.3
 * @since 2018/5/17
 */
public class Warrior extends Hero {

    private int width;
    private int height;
    PlayerType playerType;
    HeroFactory heroFactory;
    HeroType heroType = HeroType.WARRIOR;
    int spawnY;

    public Warrior(HeroFactory heroFactory, PlayerType playerType, int width, int height, int spawnY) {
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
    }

    @Override
    public void SpawnBody(){
        partsBody.spawnBody(width,height,playerType,spawnY);
    }

    @Override
    public void activityMove() {
        // need get the board W&H
        partsMove.activityMove(width,height);
    }

    @Override
    public void activityAttack() {
        partsAttack.activityAttack(width,height,playerType, heroType);
    }

    @Override
    public void activitySkills() {
        partsSkills.activitySkill(width,height,playerType, heroType);
    }



}
