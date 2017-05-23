package pl.edu.agh.agents;

import pl.edu.agh.agents.agents.Thermometer;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Thermometer> thermometers = new LinkedList<>();
        for (int c = 0; c < 4; c++) {
            Thermometer t = new Thermometer("./environment/room_" + c);
            thermometers.add(t);
        }
        for (int i = 0; i < 200; i++) {
            for (int c = 0; c < 4; c++) {
                Thermometer t = thermometers.get(c);
                System.out.println("temp " + c + ": " + t.getTemperature());
            }
            try {
                Thread.sleep(300);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}