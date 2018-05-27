package gameModel.FactoryModel;

import com.google.java.contract.Invariant;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.2
 * @since 2018/5/17
 */
@Invariant("factoryNumber != null")
public class Ranger2Factory implements HeroFactory{
    private int factoryNumber =2;

    @Override
    public PartsBody addPartsBody() {
        return new RangerBody();
    }

    @Override
    public PartsAttack addPartsAttack() {
        return new RangerAttack();
    }

    @Override
    public PartsMove addPartsMove() {
        return new RangerMove();
    }

    @Override
    public PartsSkills addPartsSkills() {
        return new SkillForMove();
    }

    public int getFactoryNumber() {
        return factoryNumber;
    }
}
