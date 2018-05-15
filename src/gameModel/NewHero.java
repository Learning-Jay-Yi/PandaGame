package gameModel;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero implements HeroFactory{
    protected Player player;
    protected HeroType heroType;

    public enum HeroType {
        WARRIOR, SUPPORT, RANGER
    }

    protected int startX, startY;

    protected int[] validX, validY;

    public NewHero(){
    }

    public void spawn(){}


    public Player getPlayer() {
        return player;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int[] getValidX() {
        return validX;
    }

    public int[] getValidY() {
        return validY;
    }

}
