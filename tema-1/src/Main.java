import simulator.Simulator;
import utils.JsonLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        int steps = 30;
        JsonLoader jsonLoader = new JsonLoader();

        if(jsonLoader.LoadJson("src/files/InputFile.json")){
            try {
                FileWriter fileWriter = new FileWriter("src/files/OutputFile.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                Simulator simulator = new Simulator();
                simulator.SetSteps(steps);
                simulator.SimulatePetriNet(printWriter);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("JSON couldn't be loaded !");
        }

    }
}
