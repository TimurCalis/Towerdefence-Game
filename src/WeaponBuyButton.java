import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CannonButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponBuyButton extends ShopElements
{
    /**
     * Act - do whatever the CannonButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int[] priceArray = {100,200,350};
    int price;
    boolean weaponPlaceable;
    public WeaponBuyButton(int id){
        price = priceArray[id];
    }
    public void act()
    {
        pressed();
    }
    public void pressed(){
        if(Greenfoot.mouseClicked(this))
        {
            if(Money.money >= 100 && weaponPlaceable == false)
            {
                Money.money = Money.money-100;
                weaponPlaceable = true;
            }
        }
    }
    
}
