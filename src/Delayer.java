import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class delayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Delayer extends UI
{
    boolean isSpawning = false;
    int delayCounter = 0;   //delay between each spawned enemy
    int delayTime;
    int callsCounter = 0;
    int callsMax;           //amount of enemys spawned
    static int wavesCounter = 0;
    int planeHealthE;  //different waves with increasing difficulty
    public void act()
    {
        abc();   
        wavesVariables();
        waveImg();
    }
    public int wavesArray[][]= { //{delayTime, callsMax,planeHealthE}
        {200,5,20},
        {50,3,10},
        {30,7,6},
        {300,2,85},
        };
    public void wavesVariables() {
        delayTime    = this.wavesArray[wavesCounter][0];
        callsMax     = this.wavesArray[wavesCounter][1];
        planeHealthE = this.wavesArray[wavesCounter][2];
    }
    public void abc()
        {
        wavesVariables();
        if(this.isSpawning==true){
            if(this.delayCounter%delayTime==0){
                MyWorld myWorld=((MyWorld)getWorld());
                myWorld.spawnPlane(planeHealthE);   //spawn a plane with the amount of health given
                callsCounter ++;
                
            }
            this.delayCounter ++;
            if(this.callsCounter == callsMax){
                this.isSpawning = false;
                delayCounter = 0;
                callsCounter = 0;
                if(wavesCounter+1<wavesArray.length)//limits waves to length of Arr
                this.wavesCounter ++;
            }
        }
    }
    public void waveImg(){
        
    }
}


