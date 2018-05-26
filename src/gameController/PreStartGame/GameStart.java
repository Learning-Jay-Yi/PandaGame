package gameController.PreStartGame;

import java.io.*;
import java.io.IOException;

import gameModel.HeroPool;
import javafx.collections.ObservableList;

/**
 *
 * @author Dario
 *
 */
public class GameStart {

	private ObservableList<HeroPool> blueData;
	private ObservableList<HeroPool> redData;
	private int redCount = 1;
	private int blueCount = 1;

	public GameStart(ObservableList<HeroPool> redData, ObservableList<HeroPool> blueData){
		this.redData = redData;
		this.blueData = blueData;
	}

	public void heroPoolData() throws IOException{
		File file =new File("HeroPoolData.txt");
	    if(!file.exists())
	    {
	    	// if not exists, then create new file and write it into file
	    	System.out.println("File 'HeroPoolData.txt' does not exit");
	        System.out.println(file.createNewFile());
	        file.createNewFile();
	        dataFileWrite(file);//call the databaseFileRead() method, to initialize data from ArrayList and write data into data.txt
	    }
	    else
	    {
	    	// if exists, just rewrite it
			dataFileWrite(file);//call the databaseFileRead() method, to load data directly from data.txt
	    }
	}

	private void dataFileWrite(File file) throws IOException{

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
//		PrintWriter out = new PrintWriter(bw);

		for(HeroPool a : redData){
			bw.write(a.getHeroType()+" "+ a.getAbility()+ " " + "RED" + " "+ redCount);
			bw.newLine();
			redCount++;
		}

		for(HeroPool b : blueData){
			bw.write(b.getHeroType()+" "+ b.getAbility()+ " " + "BLUE" + " " + blueCount);
			bw.newLine();
			blueCount++;
		}
		bw.close();
	}

}
