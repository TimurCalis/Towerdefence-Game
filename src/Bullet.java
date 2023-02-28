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
    public int damage;
    int bulletImg;
    public void act()
    {
        bulletMove();
        removeBullet();
        setBulletImg();
    }
    public Bullet(int rot,int spd,int dmg,int turretType)
    {
        setRotation(rot);  
        speed = spd;
        damage = dmg;
        bulletImg = turretType;
    }
    public void bulletMove()
    {
        move((double)speed);
        counter++;
    }
    public void removeBullet()
    {
        if(isAtEdge()||counter>35){
            this.getWorld().removeObject(this);
        }       
    }
    public void setBulletImg(){
        this.setImage("Bullet"+bulletImg+".png");
    }
}
