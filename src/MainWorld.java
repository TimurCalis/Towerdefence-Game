import greenfoot.*;
public class MainWorld extends World
{
    static boolean gameOver;
    static int textID;
    private boolean textKeyDown1;//true when help key("1")is pressed outside of the shop
    private boolean textKeyDown2;//true when help key("1")is pressed inside of the shop
    //i y-Achse
    //j x-Achse
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
        }; //array of the level, tells enemys how to move through th level
    public MainWorld()
    {    
        super(31, 24, 21); 
        prepare();
    }
    public void act(){
        if(textKeyDown1 != Greenfoot.isKeyDown("1") && (textKeyDown1 = !textKeyDown1) && ShopButton.shopOpen == false){//displays the help message
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
            removeObjects(getObjects(Text.class));
            addObject(new Text(textID+6),Text.textCord[textID+6][0],Text.textCord[textID+6][1]);
            textID ++;
           
            }
        }
    public void prepare(){
        removeObjects(getObjects(Actor.class));
        for (int i=0;i<this.pathArray.length;i++)//iterate over the array, place paths according to the array in world
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
        addObject(new LivesCounter(0),10,1);
        addObject(new Money(),19,1);
        LivesCounter livesCounter = new LivesCounter(0);
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
        //resets to default values
    }
    public void spawnPlane(int planeHealth){ //spawn enemies
        addObject(new Enemy(planeHealth),0,16);
    }
    }

