package pl.edu.agh.agents.agents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LowLevelConnector {

    private String filePath;

    LowLevelConnector(String filePath) {
        this.filePath = filePath;
    }

    private double readFile() {
        File file = new File(this.filePath);
        Scanner scan;
        try {
            scan = new Scanner(file);
            return new Double(scan.nextLine());
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return -100.0;
        }
    }

    double getState() {
        return this.readFile();
    }

}
