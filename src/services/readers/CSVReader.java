package services.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements ArchiveReader{
    private final String csvSeparator;
    private List<String[]> csvData;
    public CSVReader(String csvSeparator){
        super();
        this.csvSeparator = csvSeparator;
        this.csvData = new ArrayList<>();
    }

    @Override
    public void read(String path) {
        String line;
        List<String[]> csvData = new ArrayList<>();

        try(BufferedReader csvReader = new BufferedReader(new FileReader(path))){
            while( (line = csvReader.readLine()) != null){
                String[] columns = line.split(this.csvSeparator);
                csvData.add(columns);
            }
        }catch(IOException exception){
            System.err.print("An error occurred during the file reading: "+ exception.getMessage());
        }
        this.csvData = csvData;
    }

    public int count(){
        return this.csvData.size();
    }

    public List<String[]> getData(){
        return this.csvData;
    }
}
