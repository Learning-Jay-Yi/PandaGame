package gameModel;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior extends NewHero {
    private int width;
    private int height;
    Player player;
    HeroType heroType = HeroType.WARRIOR;

    // for the new warrior, all of them have the same body
    public NewWarrior(int width, int height, Player player){
        this.height = height;
        this.width = width;
        this.player = player;
    }



    @Override
    public void MakeHero() {

    }
}