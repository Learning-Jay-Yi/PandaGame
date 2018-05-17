package gameModel.Factory;

import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;

/**
 * This is the top factory that who will receives the order form main class
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface HeroFactory {

    AbilityAttack addAbilityAttack();

    AbilityMove addAbilityMove();

    AbilitySkills addAbilitySkills();


}

