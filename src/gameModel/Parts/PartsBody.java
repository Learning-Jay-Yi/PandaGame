package gameModel.Parts;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public interface PartsBody {
    void spawnBody(int width, int height, PlayerType playerType,int spawnY);
    void reSpawn();
    int getSpawnX();
    int getSpawnY();
    PlayerType getPlayerType();
    HeroType getRoleType();
//    void spawnBody(int width, int height, HeroType heroType, Player player);
}
