package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.PlayerType;

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

    public NewWarrior(HeroFactory heroFactory, PlayerType playerType, int width, int height) {
        this.width = width;
        this.height = height;
        this.playerType = playerType;
        this.heroFactory = heroFactory;
    }


    // hero = body + move + attack + skill

    @Override
    public void MakeHero() {
        System.out.println("Add Hero body: ");
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

        partsMove.PartsMove(19,3,20,15);
    }

    @Override
    public void Attack() {

    }

    @Override
    public void UseSkills() {

    }



}