import greenfoot.*; 

/**
 * Write a description of class delayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waves extends UI
{
    boolean isSpawning = false;
    int delayCounter = 0;   
    int delayTime;          //time between next enemy
    int callsCounter = 0;
    int callsMax;           //amount of enemys spawned
    static int wavesCounter = 0;
    int planeHealthE;  //health of enemys
    public void act()
    {
        abc();   
        wavesVariables();
    }
    public int wavesArray[][]= { //{delayTime, callsMax,planeHealthE}
        {100,5,6},  //0(1)
        {50,5,4},   //2
        {2,6,2},    //3
        {4,6,4},    //4
        {20,8,16},  //5 
        {90,4,30},  //6
        {20,10,8},  //7
        {80,4,40},  //8
        {70,4,60},  //9
        {60,5,70},  //10
        {1,1,200},  //11
        {20,12,20}, //12
        {50,6,100}, //13
        {40,7,150}, //14
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
                MainWorld mainWorld=((MainWorld)getWorld());
                mainWorld.spawnPlane(planeHealthE);   //spawn a plane with the amount of health given
                callsCounter ++;
                
            }
            this.delayCounter ++;
            if(this.callsCounter == callsMax){
                this.isSpawning = false;
                delayCounter = 0;
                callsCounter = 0;
                if(wavesCounter+1<wavesArray.length){//limits waves to length of Arr
                    this.wavesCounter ++;
                    wavesDisplayInt();
                }
            }
        }
    }
    public void wavesDisplayInt(){
        WaveDisplayer.currentWave = wavesCounter + 1;
    }
}


