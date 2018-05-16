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
    // all types hero will be implemented here
//    protected final String className = "HeroFactory";
//    public void Error(String methodName){
//        System.err.println(className + "'s "+methodName+" may have some problems!!");
//        System.exit(1);
//    }


    AbilityAttack addAbilityAttack();

    AbilityMove addAbilityMove();

    AbilitySkills addAbilitySkills();


}

