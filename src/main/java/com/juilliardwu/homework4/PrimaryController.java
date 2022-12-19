package com.juilliardwu.homework4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML
    private TextField TextFieldCount;

    @FXML
    private ListView lv;

    @FXML
    private TextField TextFieldDepartment;

    @FXML
    private TextField MaxHour;
    
    @FXML
    private TextField TextFieldName;
    
    @FXML
    private TextField TextFieldHours;
    
    @FXML
    private TextField TextFieldRate;
    
    @FXML
    private TextField TextFieldHireDate;
    
    @FXML
    private ObservableList<String> items;

    private Department department;

    private Gson gson;
    
    /**
     * Run the initialize when the program start run
     */

    @FXML
    public void initialize() {
        items = lv.getItems();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
    }

    @FXML
    // create a file chooser and set it to the curret path and filter to only json file
    
    private void handleMenuItemOpen() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File current = new File(new File(".").getCanonicalPath());
        fileChooser.setInitialDirectory(current);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        // clean the listview before reading the data
        if (selectedFile != null) {
            FileReader fr = new FileReader(selectedFile);
            items.clear();
            department = gson.fromJson(fr, new TypeToken<Department>() {
            }.getType());

            for (WorkerWithInsurance w : department.getWorkers()) {
                items.add(w.getName());
            }
        }
        TextFieldDepartment.setText(department.getName());
        MaxHour.setText(department.getMostHoursWorker().getName());
    }
    /**
     * Close the program
     */

    @FXML
    private void handleMenuItemClose() {
        Platform.exit();

    }
    /**
     * Save file 
     * @throws IOException 
     */

    @FXML
    private void handleSaveMenuItem() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File current = new File(new File(".").getCanonicalPath());
        fileChooser.setInitialDirectory(current);
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(null);
        
        if (selectedFile != null) {
            department.report(selectedFile.getName());
            
        }
    }
    /**
     * Set the TextFied withe the selected Index
     * @param event 
     */
    @FXML
    private void handleListViewItemsMouseClick(MouseEvent event){
        ObservableList<String> observableList =(ObservableList<String>)lv.getItems();
        int selectedIndex = lv.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < observableList.size()) {
            System.out.println("Selected Item: " + observableList.get(selectedIndex));
            WorkerWithInsurance worker = new WorkerWithInsurance();
            Worker ws = department.getWorkers()[selectedIndex];
            
            TextFieldName.setText(ws.getName());
            TextFieldHours.setText(Double.toString(ws.getHour()));
            TextFieldRate.setText(Double.toString(ws.getRate()));
            TextFieldHireDate.setText(ws.gethireDate().toString());
            
            
            
            
        }
        
           
    }
}

