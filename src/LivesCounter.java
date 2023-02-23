import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesCounter extends UI
{
    static int lives; //c amount of lives  
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkGameend();
        livesDisplay();
    }
    //livesLost amount of lives lost
    public void livesLost(int livesLost)
    {
        lives -= livesLost;
    }
    public void livesDisplay()
    {
        this.setImage(new GreenfootImage(Integer.toString(lives), 45, Color.RED, new Color(0,0,0,0)));
    }
    public void checkGameend()
    {
        if(lives<=0){
            System.out.println("ende");
            Greenfoot.stop();
        }
    }
}
