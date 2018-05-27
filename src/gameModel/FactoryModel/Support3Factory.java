package gameModel.FactoryModel;

import com.google.java.contract.Invariant;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.2
 * @since 2018/5/17
 */
@Invariant("factoryNumber != null")
public class Support3Factory implements HeroFactory{
    private int factoryNumber =3;

    @Override
    public PartsBody addPartsBody() {
        return new SupportBody();
    }

    @Override
    public PartsAttack addPartsAttack() {
        return new SupportAttack();
    }

    @Override
    public PartsMove addPartsMove() {
        return new SupportMove();
    }

    @Override
    public PartsSkills addPartsSkills() {
        return new SkillForDodge();
    }

    public int getFactoryNumber() {
        return factoryNumber;
    }
}
