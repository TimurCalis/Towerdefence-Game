import greenfoot.*; 

/**
 * Base to place turret on
 */
public class Base extends Tower
{
    boolean used;
    public void act()
    {
        placeWeapon();
        checkUsed();
    }
    public void placeWeapon(){//place a turret on base if bought [Hilfe von Valentin]
        if(Greenfoot.mouseClicked(this) && this.getWorld().getObjects(WeaponBuyButton.class).size()!=0 ){
            WeaponBuyButton wpn = (WeaponBuyButton)this.getWorld().getObjects(WeaponBuyButton.class).get(0);
            if(wpn.weaponPlaceable == true && used != true){
                System.out.println(wpn.weaponPlaceableID);
                wpn.weaponPlaceable = false;
                this.getWorld().addObject(new Turret(wpn.weaponPlaceableID),this.getX(),this.getY());
            }            
        }
    }
    private void checkUsed(){
        if(isTouching(Tower.class)){
            used = true;
        }
    }
}
