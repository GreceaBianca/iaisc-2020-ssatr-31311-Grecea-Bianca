package model;

import java.util.ArrayList;
import java.util.List;

public class PNObject {

    protected String id;
    protected List<String> inputArray = new ArrayList<String>();
    protected List<String> outputArray = new ArrayList<String>();

    public String GetId() {
        return id;
    }

    public void SetId(String id) {
        this.id = id;
    }

    public List<String> GetInput() {
        return inputArray;
    }

    public void SetInput(List<String> input) {
        this.inputArray = input;
    }

    public List<String> GetOutput() {
        return outputArray;
    }

    public void SetOutput(List<String> output) {
        this.outputArray = output;
    }
}
