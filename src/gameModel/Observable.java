package gameModel;

import gameView.Observer;

/**
 *
 * @author Yu Liu
 * @version 1.3
 * @since 15/05/2018
 *
 *
 *
 */
public interface Observable {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}
