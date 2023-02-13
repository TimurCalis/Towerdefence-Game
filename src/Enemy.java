import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover
{
    int eHealth;
    public Enemy(int healthValue){
        eHealth = healthValue;
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(this.getWorld()!=null)
        {
            
            eHealth();            
            walkTileType();
            removeEnemy();

        }
    }
      public void eHealth()
    { 
       Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
       if(bullet != null){
           eHealth = eHealth - 2;
           this.getWorld().removeObject(bullet);
        }
    }
    public void removeEnemy(){
        if(eHealth<=0){
           Money money = new Money();
           money.moneyEarned(5);
           this.getWorld().removeObject(this);
           
       }
    }
    
    public void smoothTurn(int deg)
    {
        MyWorld theWorld=((MyWorld)getWorld());
        if(deg>0){
            for(int i=0;i<(deg/15);i++){
                turn(15);
                
            }
        }
        else if(deg<0){
            for(int i=0;i>(deg/15);i--){
                turn(-15);
                
            }
        }
    }

    private void walkTileType(){
        this.getX();
        this.getY();
        MyWorld theWorld=((MyWorld)getWorld());
        if(theWorld.pathArray[getY()][getX()]==1)
        {
            this.move(0.2);
        }
        else if(theWorld.pathArray[getY()][getX()]==2)
        {
            smoothTurn(90);
            move(1);
        }
        else  if(theWorld.pathArray[getY()][getX()]==3)
        {
            smoothTurn(-90);
            move(1);
        }
        else if(theWorld.pathArray[getY()][getX()]==4)
        {
            System.out.println("am ziel");
            LivesCounter livesCounter = new LivesCounter();
            livesCounter.livesLost(1);
            getWorld().removeObject(this);
        }
        
    }
}
