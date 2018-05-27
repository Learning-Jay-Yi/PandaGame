package gameModel.FactoryModel;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.2
 * @since 2018/5/17
 */
public class Ranger3Factory implements HeroFactory{
    private int factoryNumber =3;

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
        return new SkillForDodge();
    }

    public int getFactoryNumber() {
        return factoryNumber;
    }
}
