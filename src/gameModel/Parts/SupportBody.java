package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

import java.util.Random;

/**
 * this class is use to make the hero body and spawn it to tile
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class SupportBody implements PartsBody {

    private int boardWidth, boardHeight;
    PlayerType playerType;
    private int spawnX,spawnY;
    private int spawnRange =3,randomSpawnY=0;
    Random randomSpawn = new Random();
    RoleType newHeroType = RoleType.SUPPORT;

    @Override
    public void spawnBody(int boardWidth, int boardHeight, PlayerType playerType) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.playerType= playerType;
//        newHeroType = RoleType.SUPPORT;
        randomSpawnY = randomSpawn.nextInt(spawnRange);

        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
        spawnY = (playerType == PlayerType.BLUE ? (6-randomSpawnY) : boardHeight-(8-randomSpawnY));
//        randomSpawnY++;
    }

    /**
     * this method use to spawn this hero
     */
    @Override
    public void reSpawn() {
//        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
//        spawnY = 3;

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
