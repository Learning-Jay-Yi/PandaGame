package gameModel;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public class NewWarriors extends NewHero {

    private int width;
    private int height;
    Player player;

    public NewWarriors(int width, int height, Player player){
        this.height = height;
        this.width = width;
        this.player = player;
    }



    @Override
    public AbilityAttack abilityAttack() {
        return null;
    }

    @Override
    public AbilityMove abilityMove() {
        return null;
    }

    @Override
    public AbilitySkills abilitySkills() {
        return null;
    }
}
