/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ColorsTXTReader implements ArchiveReader {
    public static  List<String> txtData = new ArrayList<>();

    public void read(String txtPath){
        ArrayList<String> txtLines = new ArrayList<String>();
        
        try(BufferedReader txtReader = new BufferedReader(new FileReader(txtPath))){
            String line;
             while ((line = txtReader.readLine()) != null) {
                txtLines.add(line.trim());
            }
        }catch(IOException exception){
            System.err.print("An error occurred during the file reading: "+ exception.getMessage());
        }

        txtData = txtLines;
    }

    public int count(){
        return txtData.size();
    }
}
