package gameView.BridgePattern;

import gameModel.PlayerType;
import javafx.scene.shape.Shape;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/27
 */
public class RangerShape extends HeroShape{

    private int size;
    PlayerType playerType;
    public RangerShape(int size, PlayerType playerType, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.size = size;
        this.playerType = playerType;
    }

    @Override
    Shape draw() {
       return drawingAPI.drawShape(size,playerType);
    }
}
