import greenfoot.*; 

/**
 * Enemy class. Enemys recive a healthValue (enemyHealth) trough Waves.wavesArray[x][3]
 * 
 */
public class Enemy extends SmoothMover
{
    int enemyHealth;
    public Enemy(int healthValue){
        enemyHealth = healthValue;
    }
    public void act()
    {     
        eHealth();            
        walkTileType();
        removeEnemy();
    }
    public void eHealth() //touching a bullet results in health loss by the amount given at Turret.BulletDmgArray[][]
    { 
       Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
       if(bullet != null){ //if there is a bullet listed           
           enemyHealth = enemyHealth - bullet.damage;
           this.getWorld().removeObject(bullet);
        }
    }
    public void removeEnemy(){//if enemy killed add money
        if(enemyHealth<=0){
           Money money = new Money();
           Money.money += 25;
           this.getWorld().removeObject(this);
           
       }
    }
    private void walkTileType(){
        this.getX();
        this.getY();
        MainWorld mainWorld=((MainWorld)getWorld());
        if(mainWorld.pathArray[getY()][getX()]==1)//checks the secific tile Enemy is on. Monves according to mainWorld.pathArray[][] value.
        {
            this.move(0.2); //speed as double pissible due to SmoothMover
        }
        else if(mainWorld.pathArray[getY()][getX()]==2)
        {
            turn(90);
            move(1);
        }
        else  if(mainWorld.pathArray[getY()][getX()]==3)
        {
            turn(-90);
            move(1);
        }
        else if(mainWorld.pathArray[getY()][getX()]==4)//subtract a life if enemy at end of track
        {
            LivesCounter.lives-=1;
            getWorld().removeObject(this);
        }
        
    }
}
