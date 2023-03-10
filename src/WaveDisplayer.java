import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * displays the current wave as a*10^0 and b*10^1
 */
public class WaveDisplayer extends Waves
{
    static int currentWave;
    int magnitude;
    static int a ;
    static int b;
    int counterDecimalPoint;
    public WaveDisplayer(int decimalPoint){
        counterDecimalPoint = decimalPoint;
    }
    public void act()
    {
        wavesImg();
        size();
        zerlegung();
    }
    public void size(){ 
        if(currentWave < 10){
            magnitude = 0;
        }
        if(currentWave < 20 && currentWave > 9){
            magnitude = 1;
        }
        if(currentWave < 30 && currentWave > 19){
            magnitude = 2;
        }
    }
    public void zerlegung(){
        if(magnitude == 0){
            a = currentWave;
        }
        if(magnitude == 1){
            a = currentWave - 10;
        }
        if(magnitude == 2){
            a = currentWave - 20;
        }
        b = currentWave - a;
    }
    public void wavesImg(){
        if(counterDecimalPoint == 0){
            setImage("int" + a + ".png");//print the current _Wave from the Wave.class
        }
        if(counterDecimalPoint == 1){
            setImage("int" + b/10 + ".png");
        }
    }
}
