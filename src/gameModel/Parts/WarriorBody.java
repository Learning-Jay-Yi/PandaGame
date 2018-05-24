package gameModel.Parts;

import gameModel.NewHero.NewHeroType;
import gameModel.Player;
import gameModel.PlayerType;
import gameModel.RoleType;

import java.util.Random;

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
    private int spawnRange =3,randomSpawnY=0;
    Random randomSpawn = new Random();



    @Override
    public void spawnBody(int boardWidth, int boardHeight, PlayerType playerType) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.playerType= playerType;
//        newHeroType = RoleType.WARRIOR;
        // TODO: 2018/5/24 increase hero num, how to control the spawn loction.
        randomSpawnY = randomSpawn.nextInt(spawnRange);
        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
        spawnY = (playerType == PlayerType.BLUE ? (3-randomSpawnY) : (boardHeight-5-randomSpawnY));
//        randomSpawnY++;
    }

    /**
     * this method use to spawn this hero
     */
    @Override
    public void reSpawn() {
//        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
//        spawnY = 3;
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
