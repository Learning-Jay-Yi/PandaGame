package gameView.MainView;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Dario
 * @version 1.2
 * @since 20/05/2018
 *
 * it shows the current turn belongs to who. it only shows after when first move done.
 */
public class TurnView {

	private Text t = new Text();
	private String s;
	private static TurnView Instance = null;

	public Text display(){

		return t;
	}

	public static synchronized TurnView getInstance(){
		if(Instance == null)
			Instance = new TurnView();
		return Instance;
	}

	public void updateText(String s){
		this.s = s;
		t.setText("\tWho's Turn:\t"+s+"\t");
		switch(s){
		case "RED":
			t.setFill(Color.RED);
			break;
		case "BLUE":
			t.setFill(Color.BLUE);
			break;
		}
	}
}
