import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{
    public int rot;
    public int speed;
    public int counter = 0;
    public int dmg;
    public void act()
    {
        bulletMove();
        removeBullet();
        getDmg();
    }
    public Bullet(int rot,int speed,int dmg)
    {
        setRotation(rot);  
        this.speed=speed;
    }
    public int getDmg(){
        return dmg;
    }
    public void bulletMove()
    {
        move((double)speed);
        counter++;
    }
    public void removeBullet()
    {
        if(isAtEdge()||counter>20){
            this.getWorld().removeObject(this);
        }       
    }
}
