import greenfoot.*;
import java.util.List;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Tower
{
    int reloadTime;
    int tSinceReload = 0;
    int turretLevel;
    int turretType;
    public int ReloadArray[][]= {{25,17,10},{10,5,2},{40,30,17},}; //reload speed for every Level and ever Turret {Cannon}{MashineGun}{RocketLauncher}
    public int BulletDmgArray[][]={{4,5,8},{2,3,5},{10,16,30},};                          //{4,2,10}; //damage of bullets being shot
    public int TurretRangeArray[][]={{8,12,18},{5,7,10},{20,25,35},}; //Range  
    public Turret(int type){
        turretType = type;
    }
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        findClosestInRange();
        shootAtEnemy();
        upgrade();
        turretLevelChanges();
    }
    //aus https://www.greenfoot.org/topics/60867/0
    public void findClosestInRange()
    {
        List<Enemy> enemys = getObjectsInRange(TurretRangeArray[turretType][turretLevel], Enemy.class);
        if(enemys.size() != 0)
        {
            double enemysX = enemys.get(0).getExactX();
            double enemysY = enemys.get(0).getExactY();

            turnTowards((int)enemysX,(int)enemysY);

        }       
    }
    public void shootAtEnemy()
    {
        if (tSinceReload<reloadTime)
        {
            tSinceReload ++;
        }
        else
        {
            List<Enemy> enemys = getObjectsInRange(TurretRangeArray[turretType][turretLevel], Enemy.class);
            if(enemys.size() != 0)
            {
                Bullet bullet = new Bullet(this.getRotation(),1,BulletDmgArray[turretType][turretLevel],turretType);//information given to the bullet: rotation, speed, damage, bullet typ
                getWorld().addObject(bullet,this.getX(),this.getY());
            }
            tSinceReload = 0;
        }
    }
    public void upgrade(){
        if(Greenfoot.mouseClicked(this) && this.getWorld().getObjects(WeaponBuyButton.class).size()!=0 ){
            WeaponBuyButton wpn = (WeaponBuyButton)this.getWorld().getObjects(WeaponBuyButton.class).get(0);
            if(wpn.weaponPlaceable == true && turretLevel <= 2 && wpn.weaponPlaceableID == turretType){
                turretLevel ++;
                wpn.weaponPlaceable = false;
            }
        }
    }
    public void turretLevelChanges(){
        if(turretLevel <= 2){
            this.setImage(turretType + "" + turretLevel + ".png");
            reloadTime = ReloadArray[turretType][turretLevel] ; 
        }
    }
    
    
}

