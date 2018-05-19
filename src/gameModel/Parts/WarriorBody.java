package gameModel.Parts;

import gameModel.NewHero.NewHeroType;
import gameModel.Player;

/**
 * this class is use to make the hero body and spawn it to tile
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public class WarriorBody implements PartsBody {

    private int boardWidth, boardHeight;
    Player player;
    private int spawnX,spawnY;
    NewHeroType newHeroType = NewHeroType.WARRIOR;

    @Override
    public void PartsBody(int boardWidth, int boardHeight, Player player) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.player = player;
        Spawn();
//        testSpawn();
    }

//    @Override
//    public void PartsBody(int boardWidth, int boardHeight, NewHeroType newHeroType, Player player) {
//        this.boardWidth = boardWidth;
//        this.boardHeight = boardHeight;
//        this.player = player;
//        Spawn();
//    }


    /**
     * this method use to spawn this hero
     */
    private void Spawn() {
        spawnX = (player.getPlayerType() == Player.PlayerType.BLUE ? 0 : boardWidth-1);
        spawnY = 3;

        System.out.println("Spawn "+newHeroType+" at "+spawnX+" "+spawnY);
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public int getWidth() {
        return boardWidth;
    }

    public int getHeight() {
        return boardHeight;
    }

    public Player getPlayer() {
        return player;
    }

    public NewHeroType getNewHeroType() {
        return newHeroType;
    }
}
