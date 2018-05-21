package gameController.Option;

import java.io.*;
import java.io.IOException;

import gameModel.Option.HeroPool;
import javafx.collections.ObservableList;

/**
 *
 * @author Dario
 *
 */
public class GameStart {

	private ObservableList<HeroPool> blueData;
	private ObservableList<HeroPool> redData;

	public GameStart(ObservableList<HeroPool> redData, ObservableList<HeroPool> blueData){
		this.redData = redData;
		this.blueData = blueData;
	}

	public void heroPoolData() throws IOException{
		File file =new File("HeroPoolData.txt");
	    if(!file.exists())
	    {
	    	System.out.println("File 'HeroPoolData.txt' does not exit");
	        System.out.println(file.createNewFile());
	        file.createNewFile();
	        dataFileWrite(file);//call the databaseFileRead() method, to initialize data from ArrayList and write data into data.txt
	    }
//	    else
//	    {
//	    	dataFileRead();//call the databaseFileRead() method, to load data directly from data.txt
//	    }
	}

	private void dataFileWrite(File file) throws IOException{

		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		//PrintWriter out = new PrintWriter(bw);

		for(HeroPool a : redData){
			bw.write(a.getHeroType()+" "+ a.getAbility()+ " " + "RED");
			bw.newLine();
		}

		for(HeroPool b : blueData){
			bw.write(b.getHeroType()+" "+ b.getAbility()+ " " + "BLUE");
			bw.newLine();
		}
		bw.close();
	}

}
