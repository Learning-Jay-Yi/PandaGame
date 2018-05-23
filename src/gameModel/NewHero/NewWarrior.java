package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior extends NewHero {

    private int width;
    private int height;
    PlayerType playerType;
    HeroFactory heroFactory;
    int fromFactoryNum;
    RoleType roleType = RoleType.WARRIOR;

    public NewWarrior(HeroFactory heroFactory, PlayerType playerType, int width, int height) {
        this.width = width;
        this.height = height;
        this.playerType = playerType;
        this.heroFactory = heroFactory;
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
        partsBody.spawnBody(width,height,playerType);
    }

    @Override
    public void activityMove() {
        // need get the board W&H
        partsMove.activityMove(width,height);
    }

    @Override
    public void activityAttack() {
        partsAttack.activityAttack(width,height,playerType,roleType);
    }

    @Override
    public void activitySkills() {

        switch (fromFactoryNum){
            case 1:
                // call activitySkill for attack
//                partsSkills.activitySkill();
                break;
            case 2:
                // call activitySkill for move
                break;
            case 3:
                // call activitySkill for dodge
                break;
        }
        partsSkills.activitySkill(width,height,playerType,roleType);
    }



}
