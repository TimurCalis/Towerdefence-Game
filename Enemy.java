import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getTileType();
    }

    public void smoothTurn(int deg)
    {
        MyWorld theWorld=((MyWorld)getWorld());
        if(deg>0){
            for(int i=0;i<(deg/30);i++){
                turn(30);
                Greenfoot.delay(1);
            }
        }
        else if(deg<0){
            for(int i=0;i>(deg/30);i--){
                turn(-30);
                Greenfoot.delay(1);
            }
        }
    }

    private void getTileType(){
        this.getX();
        this.getY();
        MyWorld theWorld=((MyWorld)getWorld());
        if(theWorld.patharray[getY()][getX()]==1)
        {
            move(1);
            Greenfoot.delay(1);
        }
        else if(theWorld.patharray[getY()][getX()]==2)
        {
            smoothTurn(90);
            move(1);
            Greenfoot.delay(1);
        }
        else  if(theWorld.patharray[getY()][getX()]==3)
        {
            smoothTurn(-90);
            move(1);
            Greenfoot.delay(1);
        }
        else if(theWorld.patharray[getY()][getX()]==4)
        {
            getWorld().removeObject(this);
        }
    }
}
