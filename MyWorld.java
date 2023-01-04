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
    public int patharray[][]= {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,2,0,0,0,0,0,0,0,0,0,2,1,4},
            {0,0,0,1,0,0,0,0,0,0,0,0,2,3,0,0},
            {0,0,0,3,1,1,1,2,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,3,1,1,1,1,3,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; 

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(16, 8, 64); 
        prepare();
        addObject(new Plane(),0,1);
    }

    private void prepare(){

        for (int i=0;i<this.patharray.length;i++)
        {    
            for (int j=0;j<this.patharray[i].length;j++)
            {
                addObject(new Ground(patharray[i][j]),j,i);

            }
        }
    }

    public void sliep(int ticks){
        int counter=0;
        while(counter<ticks)
        {
            counter+=1;
            System.out.println(counter);
        }
    }
}
