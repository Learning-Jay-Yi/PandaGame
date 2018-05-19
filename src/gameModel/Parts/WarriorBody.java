package gameModel.Parts;

import gameModel.NewHero.NewHeroType;
import gameModel.Player;
import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * this class is use to make the hero body and spawn it to tile
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class WarriorBody implements PartsBody {

    private int boardWidth, boardHeight;
    PlayerType playerType;
    private int spawnX,spawnY;
    RoleType newHeroType = RoleType.WARRIOR;

    @Override
    public void PartsBody(int boardWidth, int boardHeight, PlayerType playerType) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.playerType= playerType;
        Spawn();
    }

    /**
     * this method use to spawn this hero
     */
    private void Spawn() {
        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
        spawnY = 3;

//        System.out.println("Spawn "+newHeroType+" at "+spawnX+" "+spawnY);
    }
    @Override
    public int getSpawnX() {
        return spawnX;
    }
    @Override
    public int getSpawnY() {
        return spawnY;
    }
    @Override
    public PlayerType getPlayerType() {
        return playerType;
    }
    @Override
    public RoleType getRoleType() {
        return newHeroType;
    }

}
