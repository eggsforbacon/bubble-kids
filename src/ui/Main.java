package ui;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Sorting sorter = new Sorting();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------------------Bubble Kids--------------------------");
        System.out.println("$>: Specify input file (must be part of listed files below): ");
        System.out.println("$>: Below are the available files located in \"/src/data\"");
        listCommand();
        System.out.println("$>: Please type the name of the file you want to chose.\n" +
                " >: Incorrect file names may lead to unexpected errors: ");
        sorter.load(in.readLine());
        System.out.println("$>: Input is being read... ");
        sorter.bubbleSort();
        System.out.println("$>: Input sorted!");

    }

    public static void listCommand() {
        try {
            new ProcessBuilder("powershell","/c","dir .\\src\\data\\").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
