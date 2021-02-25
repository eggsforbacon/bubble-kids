package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Sorting {

    ArrayList<ArrayList<Double>> lineByLine = new ArrayList<>(); //[elements],[meanOfSorts]
    private String testCases;

    private double setMean(double sum, int data) {
        return sum / data;
    }

    public void load(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/data/" + fileName));
        testCases = br.readLine();
        String line = br.readLine();
        while(line!=null){
            String[] parts = line.split(" ");
            ArrayList<Double> lineAL = new ArrayList<>();
            for (String s: parts) {
                lineAL.add(Double.parseDouble(s));
            }
            lineByLine.add(lineAL);
            line = br.readLine();
        }
        br.close();
    }

    public void bubbleSort() {
        for (ArrayList<Double> doubles : lineByLine) {
            double sum = 0;
            int time = 0;
            for (int i = 1; i < doubles.size(); i++) {
                time++;
                for (int j = 0; j < doubles.size() - i; j++) {
                    if (doubles.get(j) > doubles.get(j + 1)) {
                        double temp = doubles.get(j);
                        doubles.set(j, doubles.get(j + 1));
                        doubles.set(j + 1, temp);
                        sum++;
                    }
                }
            }
            doubles.add(0, setMean(sum, time));
        }
    }

    public String asString() {
        StringBuilder output = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        for (ArrayList<Double> doubles: lineByLine) {
            output.append(df.format(doubles.get(0)));
            output.append("-");
            for (int i = 1, doublesSize = doubles.size(); i < doublesSize; i++) {
                double d = doubles.get(i);
                output.append(df.format(d)).append(" ");
            }
            output.deleteCharAt(output.length() - 1);
            output.append("\n----------------------------------------------------------------------\n");
        }
        output.append("-------------------------------------------------------------").append("\n$>: Test cases: ").append(testCases);
        return output.toString();
    }
}
