import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    //i y-Achse
    //j x-Achse
    static boolean gameOver;
    static int textID;
    private boolean textKeyDown1;
    private boolean textKeyDown2;
    public int pathArray[][]= {
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 4,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,2, 3,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,6, 0,0,1, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,1, 0,6,0, 0,0,0, 0,0,6, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 2,1,3, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,6, 0,2,1, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,1,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,6,0, 2,1,1, 1,3,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,6,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 6,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 2,1,1, 1,1,1, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,6,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {1,1,1, 1,1,1, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,6,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,6,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,6, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0}, 
        }; 

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainWorld()
    {    
        super(31, 24, 21); 
        prepare();
    }
    public void act(){
        if(textKeyDown1 != Greenfoot.isKeyDown("1") && (textKeyDown1 = !textKeyDown1) && ShopButton.shopOpen == false){
            removeObjects(getObjects(Text.class));
            addObject(new Text(textID),Text.textCord[textID][0],Text.textCord[textID][1]);
            textID ++;
            if(textID >= 6){
                textID = 0;
            }
        }
        if(textKeyDown2 != Greenfoot.isKeyDown("1") && (textKeyDown2 = !textKeyDown2)&& ShopButton.shopOpen != false){ //aus https://www.greenfoot.org/topics/62647/0
            if(textID >= 8){
                textID = 0;
            }
            System.out.println(textID);
            removeObjects(getObjects(Text.class));
            addObject(new Text(textID+6),Text.textCord[textID+6][0],Text.textCord[textID+6][1]);
            textID ++;
           
            }
        }
    public void prepare(){
        removeObjects(getObjects(Actor.class));
        for (int i=0;i<this.pathArray.length;i++)
        {    
            for (int j=0;j<this.pathArray[i].length;j++)
            {
                if(this.pathArray[i][j] != 0 && this.pathArray[i][j] != 6){
                    addObject(new Ground(pathArray[i][j]),j,i);
                }
                if(this.pathArray[i][j]==6){
                    addObject(new Base(),j,i);
                }
            }
        }
        addObject(new LivesCounter(false),10,1);
        addObject(new Money(),19,1);
        LivesCounter livesCounter = new LivesCounter(false);
        livesCounter.lives=5;
        WaveStartButton button = new WaveStartButton();
        addObject(button,29,22);
        ShopButton shopButton = new ShopButton();
        addObject(shopButton,27,22);
        ShopButton.shopOpen = false;
        Money.money = 150;
        LivesCounter.lives = 10;
        Waves.wavesCounter = 0;
        WaveDisplayer.currentWave = 1;
    }
    public void spawnPlane(int planeHealth){ 
        addObject(new Enemy(planeHealth),0,16);
    }
    public void gameEnd(){
        //this.setImage("GameOver.png");
    }
    }

