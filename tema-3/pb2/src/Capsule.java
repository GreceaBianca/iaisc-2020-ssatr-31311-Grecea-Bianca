import java.util.List;

public class Capsule {
    String capsuleName;
    List<String> inputs;
    List<String> outputs;

    public Capsule() {
    }

    public String getCapsuleName() {
        return capsuleName;
    }

    public void setName(String capsuleName) {
        this.capsuleName = capsuleName;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<String> outputs) {
        this.outputs = outputs;
    }
}