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
    RoleType roleType = RoleType.SUPPORT;

    public NewSupport(HeroFactory heroFactory, PlayerType playerType, int width, int height) {
        this.width = width;
        this.height = height;
        this.playerType = playerType;
        this.heroFactory = heroFactory;
    }


    // hero = body + move + attack + skill

    @Override
    public void MakeHero() {
        partsBody = heroFactory.addPartsBody();
        partsMove = heroFactory.addPartsMove();
        partsAttack = heroFactory.addPartsAttack();
        partsSkills = heroFactory.addPartsSkills();
    }

    @Override
    public void SpawnBody(){
        partsBody.PartsBody(width,height,playerType);
    }

    @Override
    public void Move() {
        // need get the current X&Y, board W&H
        partsMove.PartsMove(width,height);
    }

    @Override
    public void Attack() {
        partsAttack.PartsAttack(width,height,playerType,roleType);
    }

    @Override
    public void UseSkills() {

    }



}
