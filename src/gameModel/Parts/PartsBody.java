package gameModel.Parts;

import gameModel.NewHero.NewHeroType;
import gameModel.Player;
import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/19
 */
public interface PartsBody {
    void PartsBody(int width, int height, PlayerType playerType);
    int getSpawnX();
    int getSpawnY();
    PlayerType getPlayerType();
    RoleType getRoleType();
//    void PartsBody(int width, int height, NewHeroType newHeroType, Player player);
}
