package gameView.BridgePattern;

import gameModel.PlayerType;
import javafx.scene.shape.Shape;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/27
 */
public class WarriorShape extends HeroShape{

    private int size;
    PlayerType playerType;
    public WarriorShape(int size, PlayerType playerType, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.size = size;
        this.playerType = playerType;
    }

    @Override
    Shape draw() {
       return drawingAPI.drawShape(size,playerType);
    }
}
