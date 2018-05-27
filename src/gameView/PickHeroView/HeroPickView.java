package gameView.PickHeroView;

import gameModel.HeroPool;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author Yu Liu
 * @version 1.3
 * @since 15/05/2018
 *
 * HeroPickView include all hero types, and 2 players' containers which are going to save the hero picked
 */
public class HeroPickView {

	private Label label1 = new Label("Hero Pool");
	private Label label2 = new Label("Player Red");
	private Label label3 = new Label("Player Blue");


	private ObservableList<HeroPool> data;

	private ObservableList<HeroPool> redData = FXCollections.observableArrayList();
	private ObservableList<HeroPool> blueData = FXCollections.observableArrayList();

	public HeroPickView(ObservableList<HeroPool> data){
		this.data = data;
	}

	public GridPane getHeroPick(){
		GridPane root = new GridPane();

		root.add(label1, 0, 0); // hero list
		root.add(label2, 1, 0); // player red
		root.add(label3, 2, 0); // player blue

		root.add(getHeroPool(), 0, 1);
		root.add(getRedContainer(), 1, 1);
		root.add(getBlueContainer(), 2, 1);
		return root;
	}

	/*
	 * the first list view to show the available hero list
	 */
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
                        checkBox.selectedProperty().addListener(e->{
                        	if(checkBox.isSelected())
                        		data.setSelect(true);
                        	else
                        		data.setSelect(false);
                        });

                        return new SimpleObjectProperty<CheckBox>(checkBox);
                    }
                });

	    columns.addAll(typeColumn, abilityColumn, selectColumn);

	    heroPool.setItems(data);
		pool.getChildren().add(heroPool);
		return pool;
	}

	/*
	 * the second list view shows the heros that selected by player red
	 */
	public VBox getRedContainer(){
		VBox redContainer = new VBox();
		TableView<HeroPool> redList = new TableView();
		ObservableList<TableColumn<HeroPool, ?>> redcolumns = redList.getColumns();

		TableColumn<HeroPool, String> typeColumn = new TableColumn<>("Hero Type");
		typeColumn.setMinWidth(100);
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("heroType"));

		TableColumn<HeroPool, Integer> abilityColumn = new TableColumn<>("Special Ability");
	    abilityColumn.setMinWidth(100);
	    abilityColumn.setCellValueFactory(new PropertyValueFactory<>("ability"));

		redcolumns.addAll(typeColumn, abilityColumn);

		Button addBtn = new Button("Add");
		Button deleteBtn = new Button("Clean");
		deleteBtn.setVisible(false);
		HBox btnPane = new HBox();
		btnPane.getChildren().addAll(addBtn, deleteBtn);

		addBtn.setOnAction(e ->{
			for(HeroPool a : data){
				if(a.isSelected() && !a.isRedAdd()){
					redData.add(a);
					a.setRedAdd(true);
				}
			}
			redList.setItems(redData);
			addBtn.setVisible(false);
			deleteBtn.setVisible(true);
		});

		deleteBtn.setOnAction(e->{
			for(HeroPool a : redData){
				a.setRedAdd(false);
			}
			redData = FXCollections.observableArrayList();
			redList.setItems(redData);
			addBtn.setVisible(true);
			deleteBtn.setVisible(false);
		});

		redContainer.getChildren().addAll(btnPane, redList);
		//TODO
		return redContainer;
	}


	/*
	 * the third list view shows the heros that selected by player blue
	 */
	public VBox getBlueContainer(){
		VBox blueContainer = new VBox();

		TableView<HeroPool> blueList = new TableView();
		ObservableList<TableColumn<HeroPool, ?>> bluecolumns = blueList.getColumns();

		TableColumn<HeroPool, String> typeColumn = new TableColumn<>("Hero Type");
		typeColumn.setMinWidth(100);
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("heroType"));

		TableColumn<HeroPool, Integer> abilityColumn = new TableColumn<>("Special Ability");
	    abilityColumn.setMinWidth(100);
	    abilityColumn.setCellValueFactory(new PropertyValueFactory<>("ability"));

        bluecolumns.addAll(typeColumn, abilityColumn);

		Button addBtn = new Button("Add");
		Button deleteBtn = new Button("Clean");
		deleteBtn.setVisible(false);
		HBox btnPane = new HBox();
		btnPane.getChildren().addAll(addBtn, deleteBtn);

		addBtn.setOnAction(e ->{
			for(HeroPool a : data){
				if(a.isSelected() && !a.isBlueAdd()){
					blueData.add(a);
					a.setBlueAdd(true);
				}
			}
			blueList.setItems(blueData);
			addBtn.setVisible(false);
			deleteBtn.setVisible(true);
		});

		deleteBtn.setOnAction(e->{
			for(HeroPool a : blueData){
				a.setBlueAdd(false);
			}
			blueData = FXCollections.observableArrayList();
			blueList.setItems(blueData);
			addBtn.setVisible(true);
			deleteBtn.setVisible(false);
		});

		blueContainer.getChildren().addAll(btnPane, blueList);

		return blueContainer;
	}


	public ObservableList<HeroPool> getRedData(){
		return redData;
	}

	public ObservableList<HeroPool> getBlueData(){
		return blueData;
	}

}
