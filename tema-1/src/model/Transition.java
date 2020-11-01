package model;

import java.util.Random;

public class Transition extends PNObject{

    private int minTime;
    private int maxTime;
    private int delay;
    private int tempTokens;

    public Transition(){
        delay = 0;
    }

    public void SetMinTime(int minTime) {
        this.minTime = minTime;
    }


    public void SetMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int GetDelay() {
        return delay;
    }

    public int GetTempTokens() {
        return tempTokens;
    }

    public void AddTempToken(){
        tempTokens++;
    }

    public boolean DecreaseTokens(){
        if(tempTokens == 0){
            return  false;
        } else {
            tempTokens--;
            return true;
        }
    }

    public void SetDelay(){
        if(minTime == 0 && maxTime == 0){
            System.out.println(id+" has no delay!");
        } else {
            Random r = new Random();
            delay = r.nextInt((maxTime - minTime) + 1) + minTime;
            System.out.println(id+" delay set: "+delay);
        }

    }

    public void DecreaseDelay(){
        if(delay == 0){
            System.out.println(id+" delay is  0");
        }
        else {
            delay--;
            System.out.println(id+" delay decreased ! now: "+delay);
        }
    }
}
