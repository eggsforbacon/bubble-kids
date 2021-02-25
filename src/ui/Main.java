package ui;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Sorting sorter = new Sorting();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        clear();
        System.out.println("--------------------------Bubble Kids--------------------------");
        System.out.println("$>: Specify input file (must be part of listed files below): ");
        System.out.println("$>: Below are the available files located in \"/src/data\"");
        listCommand();
        System.out.println("$: Please type the name of the file you want to chose.\n" +
                " > Incorrect file names may lead to unexpected errors: ");
        sorter.load(br.readLine());
        System.out.println("$: Input is being sorted... ");
        sorter.bubbleSort();
        System.out.println("$: Input sorted!");
        wait(1000);
        clear();
        System.out.println("$: Printing output...");
        wait(1000);
        System.out.println(sorter.asString());
        System.out.println("$: Output printed!");
        wait(1000);
        System.out.print("$: Press any key to exit");
        in.nextLine();
        in.close();
        clear();
        System.out.println("$/: Terminated");
    }

    public static void listCommand() {
        try {
            new ProcessBuilder("powershell","/c","dir .\\src\\data\\").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void clear() {
        try {
            final String OS = System.getProperty("os.name");
            if (OS.contains("Windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("Screen could not be cleared (" + e + ")\n");
        }
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
