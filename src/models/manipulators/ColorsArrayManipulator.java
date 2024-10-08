/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.manipulators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ColorsArrayManipulator {
    private List<String> colors;
    
    public ColorsArrayManipulator(){
        this.colors = new ArrayList<>();
        this.init();
    }
    
    private void init(){
        ArrayList<String> txtLines = new ArrayList<String>();
        String txtPath = "C:\\Users\\guilh\\Documentos\\IdeaProjects\\StockFilter\\src\\contents\\Colors.txt";
        
        try(BufferedReader txtReader = new BufferedReader(new FileReader(txtPath))){
            String line;
             while ((line = txtReader.readLine()) != null) {
                txtLines.add(line);
            }
        }catch(IOException exception){
            System.err.print("An error occurred during the file reading: "+ exception.getMessage());
        }
        
        this.colors = txtLines;
    }

    public List<String> get(){
        return this.colors;
    }
}
