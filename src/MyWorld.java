import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //i y-Achse
    //j x-Achse
    public int pathArray[][]= {
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 4,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,2, 3,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,1, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,1, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 2,1,3, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,2,1, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,1,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 2,1,1, 1,3,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 2,1,1, 1,1,1, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 1,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {1,1,1, 1,1,1, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0},
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0}, 
        }; 

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(31, 24, 21); 
        prepare();
        //addObject(new Heart(),1,0);
        //addObject(new Cannon(),2,2);
        //addObject(new SmoothMover(),0,0);
    }

    private void prepare(){

        for (int i=0;i<this.pathArray.length;i++)
        {    
            for (int j=0;j<this.pathArray[i].length;j++)
            {
                if(this.pathArray[i][j]==5){
                    addObject(new Ground(pathArray[i][j]),j,i);
                }
                if(this.pathArray[i][j]!=0){
                    addObject(new Ground(pathArray[i][j]),j,i);
                }

            }
        }
        addObject(new LivesCounter(),10,1);

        addObject(new Money(),19,1);

        Cannon cannon = new Cannon();
        addObject(cannon,4,4);

        LivesCounter livesCounter = new LivesCounter();
        livesCounter.lives=5;

        addObject(new Button(),29,22);
        Cannon cannon2 = new Cannon();
        addObject(cannon2,13,15);
        Cannon cannon3 = new Cannon();
        addObject(cannon3,18,11);
    }

    public void spawnPlane(int planeHealth){ 
        addObject(new Enemy(planeHealth),0,16);
        System.out.println(planeHealth);
    }
    }

