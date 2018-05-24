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
public class RangerBody implements PartsBody {

    private int boardWidth, boardHeight;
    PlayerType playerType;
    private int spawnX,spawnY;
    RoleType newHeroType = RoleType.RANGER;
    private int spawnRange =3,randomSpawnY=0;
    Random randomSpawn = new Random();


    @Override
    public void spawnBody(int boardWidth, int boardHeight, PlayerType playerType) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.playerType= playerType;
//        newHeroType = RoleType.RANGER;
        randomSpawnY = randomSpawn.nextInt(spawnRange);
        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
        spawnY = (playerType == PlayerType.BLUE ? (9-randomSpawnY) : boardHeight-(11-randomSpawnY));
//        randomSpawnY++;
    }

    /**
     * this method use to spawn this hero
     */
    @Override
    public void reSpawn() {
//        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
//        spawnY = (playerType == PlayerType.BLUE ? 9 : boardHeight-10);

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
