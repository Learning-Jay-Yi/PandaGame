package gameView.BridgePattern;

import gameModel.PlayerType;
import javafx.scene.shape.Shape;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/27
 */
public abstract class HeroShape {
    DrawingAPI drawingAPI;
    public HeroShape(DrawingAPI drawingAPI){
        this.drawingAPI = drawingAPI;
    }
    abstract Shape draw();
}
