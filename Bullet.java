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
    public int c=0;
    public void act()
    {
        bulletMove();
        removeBullet();
    }
    public Bullet(int rot,int speed)
    {
        setRotation(rot);  
        this.speed=speed;
    }
    public void bulletMove()
    {
        move(speed);
        c++;
    }
    public void removeBullet()
    {
        if(isAtEdge()||c>7){
            this.getWorld().removeObject(this);
        }       
    }
}
