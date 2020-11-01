package model;

public class Location extends PNObject {

    private int tokens;

    public int Get() {
        return tokens;
    }

    public void Set(int tokens) {
        this.tokens = tokens;
    }

    public boolean Decrease(){
        if(tokens == 0){
            return  false;
        } else {
            tokens--;
            return true;
        }
    }

    public void Add(){
        tokens++;
    }
}
