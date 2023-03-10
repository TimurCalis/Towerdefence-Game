import greenfoot.*;
import java.util.List;
/**
 * contains all 3 turret variants and their respective upgrades
 */
public class Turret extends Tower
{
    int reloadTime;
    int tSinceReload = 0;
    int turretLevel;
    int turretType;
    public int ReloadArray[][]= {{25,17,10},{10,5,2},{40,30,17},}; //reload speed for every Level and ever Turret {Cannon}{MashineGun}{RocketLauncher}
    public int BulletDmgArray[][]={{4,5,8},{2,3,5},{20,30,45},};   //damage of bullets being shot
    public int TurretRangeArray[][]={{8,12,18},{5,7,10},{20,25,35},}; //Range of turret 
    public Turret(int type){
        turretType = type;
    }
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
                Bullet bullet = new Bullet(this.getRotation(),1,BulletDmgArray[turretType][turretLevel],turretType);//information given to the bullet: rotation, speed, damage, bullet type
                getWorld().addObject(bullet,this.getX(),this.getY());
            }
            tSinceReload = 0;
        }
    }
    public void upgrade(){//if same weapon has been bought again and placed on this instance of turret and turretLevel not over 2, set turret level higher
        if(Greenfoot.mouseClicked(this) && this.getWorld().getObjects(WeaponBuyButton.class).size()!=0 && this.turretLevel < 2){
            WeaponBuyButton wpn = (WeaponBuyButton)this.getWorld().getObjects(WeaponBuyButton.class).get(0);
            if(wpn.weaponPlaceable == true && turretLevel <= 1 && wpn.weaponPlaceableID == turretType){
                turretLevel ++;
                wpn.weaponPlaceable = false;
            }
        }
    }
    public void turretLevelChanges(){//update turret img according to current lvl
            this.setImage(turretType + "" + turretLevel + ".png");
            reloadTime = ReloadArray[turretType][turretLevel] ; 
    }
    
    
}


