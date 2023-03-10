import greenfoot.*; 

/** Regular lives Display + Gameover screen in one class for efficeny (no new world is required) + win screen
 *  LivesCounter(0) = LivesCounter 
 *  LivesCounter(1) = created after all lives are lost, clickable for restart
 *  LivesCounter(2) = created after all waves have been played, clickable for restart
 */
public class LivesCounter extends UI
{
    static int lives; //  amount of lives  
    int gameEndLogo;
    public LivesCounter(int gameOverLogo){
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
        if(gameEndLogo == 0){ //regular counter as display
            this.setImage(new GreenfootImage(Integer.toString(lives), 45, Color.RED, new Color(0,0,0,0)));
        }
        if(gameEndLogo == 1){ //game over screen
            this.setImage("InkedGameOver.png");
        }
        if(gameEndLogo == 2){
            this.setImage("win.png");
        }
    }
    public void checkGameend()
    {
        if(lives<=0){
            getWorld().removeObjects(getWorld().getObjects(SmoothMover.class));
            getWorld().addObject(new LivesCounter(1),15,12);
            if(Greenfoot.mouseClicked(this)){
                MainWorld mainWorld=((MainWorld)getWorld());
                mainWorld.prepare(); //load prepare(), all static values will get reset, all actors removed. Game restarts.
            }
        }
        if(Waves.wavesCounter >= 13){//if wincondition then winscreen
            getWorld().removeObjects(getWorld().getObjects(SmoothMover.class));
            getWorld().addObject(new LivesCounter(2),15,12);
            if(Greenfoot.mouseClicked(this)){
                MainWorld mainWorld=((MainWorld)getWorld());
                mainWorld.prepare(); //load prepare(), all static values will get reset, all actors removed. Game restarts.
            }
        }
    }
}
