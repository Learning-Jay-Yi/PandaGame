package gameView;

import javafx.scene.text.Text;

/**
 *
 * @author Dario
 *
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
		t.setText(s);
	}
}
