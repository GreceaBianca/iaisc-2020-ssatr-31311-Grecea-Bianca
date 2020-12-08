import java.util.List;

public class Main {
    Port port=new Port();
    Capsule capsule=new Capsule();
    String capsuleName;
    List<Port> inputPorts;
    List<Port> outputPorts;

    public void getCapsule(){
        capsuleName=capsule.getCapsuleName();
    }
    public List<String> getPortInputs(){
        return capsule.getInputs();
    }
    public List<String> getPortOutputs(){
        return capsule.getOutputs();
    }

    public static void checkTypePortsIn(){
        System.out.println("RT-UML");
    }
    public static void main(String[] args) {
        checkTypePortsIn();
    }
}
