import greenfoot.*;
import java.util.List;
  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Tower
{
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        findClosestInRange();
        shootAtEnemy();
    }
    //aus https://www.greenfoot.org/topics/60867/0
    public void findClosestInRange()
    {
        List<Enemy> enemys = getObjectsInRange(9, Enemy.class);
        if(enemys.size() != 0)
        {
            double enemysX = enemys.get(0).getExactX();
            double enemysY = enemys.get(0).getExactY();
            
            turnTowards((int)enemysX,(int)enemysY);
            
        }       
    }
    public void shootAtEnemy()
    {
        int reloadTime;
        int tSinceReload;
        //if (tSinceReload<
        List<Enemy> enemys = getObjectsInRange(9, Enemy.class);
        if(enemys.size() != 0)
        {
            Bullet bullet = new Bullet(this.getRotation(),1);
            getWorld().addObject(bullet,this.getX(),this.getY());
        }
    }
}
