package gameModel;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public class Player {
    String player;
    int turns;

    public enum PlayerType {
        RED, BLUE
    }

    protected PlayerType playerType;

    public Player(PlayerType type, int turns, String player){
        this.playerType = type;
        this.player = player;
        this.turns =turns;
    }

    /**
     *
     * @return Player type
     */
    public PlayerType getPlayerType() {
        return playerType;
    }

    /**
     *
     * @return player's turn
     */
    public int getTurns() {
        return turns;
    }

    /**
     *
     * @return player name
     */
    public String getPlayer() {
        return player;
    }

    /**
     *
     * @return String that to store the info to save game
     */

    @Override
    public String toString() {
        return player+" "+playerType+" "+turns;
    }


}
