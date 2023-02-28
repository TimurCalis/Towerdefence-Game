import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaveCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveDisplayer extends Waves
{
    /**
     * Act - do whatever the WaveCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static int currentWave;
    int magnitude;
    static int einer ;
    static int zehner;
    int counterStelle;
    public WaveDisplayer(int stelle){
        counterStelle = stelle;
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
            einer = currentWave;
        }
        if(magnitude == 1){
            einer = currentWave - 10;
        }
        if(magnitude == 2){
            einer = currentWave - 20;
        }
        zehner = currentWave - einer;
        System.out.println(zehner);
    }
    public void wavesImg(){
        if(counterStelle == 0){
            setImage("int" + einer + ".png");//print the current _Wave from the Wave.class
        }
        if(counterStelle == 1){
            setImage("int" + zehner/10 + ".png");
        }
    }
}
