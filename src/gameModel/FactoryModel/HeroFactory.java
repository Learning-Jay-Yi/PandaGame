package gameModel.FactoryModel;

import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsBody;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;

/**
 * This is the top factory that who will receives the order form main class
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface HeroFactory {

    PartsBody addPartsBody();

    PartsAttack addPartsAttack();

    PartsMove addPartsMove();

    PartsSkills addPartsSkills();

    int getFactoryNumber();


}

