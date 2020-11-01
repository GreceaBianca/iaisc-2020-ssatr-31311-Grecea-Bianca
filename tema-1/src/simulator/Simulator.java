package simulator;

import model.Location;
import model.Transition;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Simulator {

    private int steps;

    public void SetSteps(int steps) {
        this.steps = steps;
    }

    private boolean CheckInputTokens(Transition transition) {
        boolean status = true;
        if (transition.GetInput().size() == 0)
            return false;
        for (int i = 0; i < transition.GetInput().size(); i++) {
            Location location = PetriNet.getInstance().getLocationById(transition.GetInput().get(i));
            if (location.Get() == 0)
                status = false;
        }
        return status;
    }

    public void SimulatePetriNet(PrintWriter printWriter) {
        for (int i = 0; i < steps; i++) {
            printWriter.print(i + " : ");
            PetriNet.getInstance().getLocations().forEach(location -> {
                System.out.print(", " + location.GetId() + ": " + location.Get() + " ");
                printWriter.print(", " + location.GetId() + ": " + location.Get() + " ");
            });
            printWriter.println();
            System.out.println();
            PetriNet.getInstance().getTransitions().forEach(
                    transition -> System.out.print(", " + transition.GetId() + " : " + transition.GetTempTokens() + " ")
            );
            System.out.println();
            for (int k = 0; k < PetriNet.getInstance().getTransitions().size(); k++) {

                Transition transition = PetriNet.getInstance().getTransitions().get(k);

                if (transition.GetDelay() > 0) {
                    transition.DecreaseDelay();
                }

                if (transition.GetTempTokens() == 0) {
                    if (true == CheckInputTokens(transition)) {
                        System.out.println("Valid input for " + transition.GetId());
                        for (int iii = 0; iii < transition.GetInput().size(); iii++) {
                            Location location = PetriNet.getInstance().getLocationById(transition.GetInput().get(iii));
                            if (location.Decrease())
                                System.out.println("Token token from " + location.GetId());

                            else
                                System.out.println("Error ! No tokens in " + location.GetId());
                        }
                        transition.AddTempToken();
                        System.out.println("Token added in " + transition.GetId());
                        transition.SetDelay();
                    }
                } else
                    System.out.println("Transition " + transition.GetId() + " already activated");
            }
            for (int j = 0; j < PetriNet.getInstance().getTransitions().size(); j++) {
                Transition transition = PetriNet.getInstance().getTransitions().get(j);
                if (transition.GetDelay() == 0) {
                    if (transition.DecreaseTokens()) {
                        System.out.println("Temp token taken from " + transition.GetId());
                        for (int ii = 0; ii < transition.GetOutput().size(); ii++) {
                            Location location = PetriNet.getInstance().getLocationById(transition.GetOutput().get(ii));
                            location.Add();
                            System.out.println("Token added in " + location.GetId());
                        }
                    }
                } else {
                    System.out.println(transition.GetId() + " has delay: " + transition.GetDelay());
                }
            }
        }
    }

}