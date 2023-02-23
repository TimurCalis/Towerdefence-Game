import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class base here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Base extends Tower
{
    /**
     * Act - do whatever the base wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean used;
    public void act()
    {
        placeWeapon();
        checkUsed();
    }
    public void placeWeapon(){//place a weapon Hilfe von Valentin
        if(Greenfoot.mouseClicked(this) && this.getWorld().getObjects(WeaponBuyButton.class).size()!=0 ){
            WeaponBuyButton wpn = (WeaponBuyButton)this.getWorld().getObjects(WeaponBuyButton.class).get(0);
            if(wpn.weaponPlaceable == true && used != true){
                System.out.println("base turret");
                wpn.weaponPlaceable = false;
                this.getWorld().addObject(new Cannons(0),this.getX(),this.getY());
            }            
        }
    }
    private void checkUsed(){
        if(isTouching(Tower.class)){
            used = true;
        }
    }
}
