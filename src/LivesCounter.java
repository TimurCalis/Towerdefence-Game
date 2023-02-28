import greenfoot.*; 

/** Regular lives Display + Gameover screen in one class for efficeny (no new world is required)
 *  LivesCounter(false) = LivesCounter 
 *  LivesCounter(true) = created after all lives are lost, clickable for restart
 */
public class LivesCounter extends UI
{
    static int lives; //  amount of lives  
    boolean gameEndLogo;
    public LivesCounter(boolean gameOverLogo){
        gameEndLogo = gameOverLogo;
    }
    public void act()
    {
        checkGameend();
        livesDisplay();
    }
    public void livesLost(int livesLost)
    {
        lives -= livesLost;
    }
    public void livesDisplay()
    {
        if(gameEndLogo == false){ //regular counter as display
            this.setImage(new GreenfootImage(Integer.toString(lives), 45, Color.RED, new Color(0,0,0,0)));
        }
        if(gameEndLogo){ //game over screen
            this.setImage("InkedGameOver.png");
        }
    }
    public void checkGameend()
    {
        if(lives<=0){
            getWorld().addObject(new LivesCounter(true),15,12);
            if(Greenfoot.mouseClicked(this)){
                MainWorld mainWorld=((MainWorld)getWorld());
                mainWorld.prepare(); //load prepare(), all static values will get reset, all actors removed. Game restarts.
            }
        }
    }
}
