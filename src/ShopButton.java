import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopButton extends UI
{
    /**
     * Act - do whatever the shopButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static boolean shopOpen = false;
    public void act()
    {
        checkPress();
    }
    public void checkPress(){
        if(Greenfoot.mouseClicked(this)){
            ShopBackground shopBackground = new ShopBackground();
            WeaponBuyButton weaponButtonCannon = new WeaponBuyButton(0);
            WeaponBuyButton weaponButtonMg = new WeaponBuyButton(1);
            WeaponBuyButton weaponButtonRl = new WeaponBuyButton(2);
            MainWorld.textID = 0;
            if(getWorld().getObjects(Text.class) != null){
                getWorld().removeObjects(getWorld().getObjects(Text.class));
            }
            if(shopOpen == false){
                this.getWorld().addObject(shopBackground,28,5);
                this.getWorld().addObject(weaponButtonCannon,27,1);
                this.getWorld().addObject(weaponButtonMg,27,5);
                this.getWorld().addObject(weaponButtonRl,27,9);
                shopOpen = true;
                
            }
            else if(shopOpen == true && ((WeaponBuyButton)this.getWorld().getObjects(WeaponBuyButton.class).get(0)).weaponPlaceable == false){
                getWorld().removeObjects(getWorld().getObjects(ShopElements.class));
                
                shopOpen = false;
            }
        }
    }
}
