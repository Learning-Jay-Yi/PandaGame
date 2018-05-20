package gameView.Option;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 15/05/2018
 *
 * HeroPickView include all hero types, and 2 players' containers which are going to save the hero picked
 */
public class HeroPickView {

	private Label label1 = new Label("Hero Pool");
	private Label label2 = new Label("Player Red");
	private Label label3 = new Label("Player Blue");


	private ObservableList<HeroPool> data = FXCollections.observableArrayList(
			new HeroPool("Warrior", 1),
			new HeroPool("Warrior", 2),
			new HeroPool("Warrior", 3),
			new HeroPool("Support", 1),
			new HeroPool("Support", 2),
			new HeroPool("Support", 3),
			new HeroPool("Ranger", 1),
			new HeroPool("Ranger", 2),
			new HeroPool("Ranger", 3)
			);


	public HeroPickView(){
	}

	public GridPane getHeroPick(){
		GridPane root = new GridPane();

		root.add(label1, 0, 0); // hero list
		root.add(label2, 1, 0); // player red
		root.add(label3, 2, 0); // player blue
		//TODO
		root.add(getHeroPool(), 0, 1);
		root.add(getRedContainer(), 1, 1);
		root.add(getBlueContainer(), 2, 1);
		return root;
	}

	public VBox getHeroPool(){
		VBox pool = new VBox();

		TableView<HeroPool> heroPool = new TableView();
		ObservableList<TableColumn<HeroPool, ?>> columns = heroPool.getColumns();

		TableColumn<HeroPool, String> typeColumn = new TableColumn<>("Hero Type");
		typeColumn.setMinWidth(100);
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("heroType"));


	    TableColumn<HeroPool, Integer> abilityColumn = new TableColumn<>("Special Ability");
	    abilityColumn.setMinWidth(100);
	    abilityColumn.setCellValueFactory(new PropertyValueFactory<>("ability"));

	    TableColumn<HeroPool, CheckBox> selectColumn = new TableColumn<HeroPool, CheckBox>("Select");
        selectColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<HeroPool, CheckBox>, ObservableValue<CheckBox>>(){
                    @Override
                    public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<HeroPool, CheckBox> arg0) {
                    	HeroPool data = arg0.getValue();
                        CheckBox checkBox = new CheckBox();
                        checkBox.selectedProperty().setValue(data.isSelected());

                        return new SimpleObjectProperty<CheckBox>(checkBox);
                    }
                });

	    columns.addAll(typeColumn, abilityColumn, selectColumn);

	    heroPool.setItems(data);
		pool.getChildren().add(heroPool);
		//TODO
		return pool;
	}

	public VBox getRedContainer(){
		VBox redContainer = new VBox();


		//redContainer.getChildren().add(redList);
		//TODO
		return redContainer;
	}

	public VBox getBlueContainer(){
		VBox blueContainer = new VBox();



		//blueContainer.getChildren().add(blueList);
		//TODO
		return blueContainer;
	}

}
