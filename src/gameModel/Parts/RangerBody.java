package gameModel.Parts;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;

import java.util.Random;

import com.google.java.contract.Ensures;

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
    HeroType heroType = HeroType.RANGER;
    private int spawnRange =2,randomSpawnY=0;
    Random randomSpawn = new Random();


    @Override
    public void spawnBody(int boardWidth, int boardHeight, PlayerType playerType, int newSpawnY) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.playerType= playerType;
//        heroType = HeroType.RANGER;
        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
        spawnY = (playerType == PlayerType.BLUE ? newSpawnY+spawnRange : boardHeight-(newSpawnY+spawnRange));
//        randomSpawnY++;
    }

    /**
     * this method use to spawn this hero
     */
    @Override
    public void reSpawn() {
//        spawnX = (playerType == PlayerType.BLUE ? 0 : boardWidth-1);
//        spawnY = (playerType == PlayerType.BLUE ? 9 : boardHeight-10);

//        System.out.println("Spawn "+heroType+" at "+spawnX+" "+spawnY);
    }
   
    @Ensures("spawnX != null")
    @Override
    public int getSpawnX() {
        return spawnX;
    }
    
    @Ensures("spawnY != null")
    @Override
    public int getSpawnY() {
        return spawnY;
    }
    @Ensures("playerType == RED || playerType == BLUE")
    @Override
    public PlayerType getPlayerType() {
        return playerType;
    }
    @Ensures("heroType == RANGER")
    @Override
    public HeroType getRoleType() {
        return heroType;
    }

}
