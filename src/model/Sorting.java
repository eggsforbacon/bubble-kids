package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sorting {

    ArrayList<ArrayList<Integer>> lineByLine = new ArrayList<>(); //[elements],[meanOfSorts]
    private int testCases;

    private void setLines(String[] splitInput) {

    }

    private void setMean() {

    }

    public void load(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/data/" + fileName));
        testCases = br.read();
        String line = br.readLine();
        while(line!=null){
            String[] parts = line.split(" ");

            line = br.readLine();
        }
        br.close();
    }

    public ArrayList<ArrayList<Integer>> getLineByLine() {
        return lineByLine;
    }
}
