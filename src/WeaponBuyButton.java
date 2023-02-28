import greenfoot.*; 

/**
 *  Individual button for each type of weapon
 */
public class WeaponBuyButton extends ShopElements
{
    int[] priceArray = {100,200,350}; //price for 1.Cannon, 2.MashineGun,3.RocketLauncher
    int price;
    static int weaponPlaceableID;       //provides WeaponBase with information on which type of turret has been purchased
    static boolean weaponPlaceable;         //provides WeaponBase with information on weather a turret has been bought but not yet places
    int weaponID;                       //each ID is for one type of weapon: 1.=0 ; 2. =1 ; 3. = 2
    public WeaponBuyButton(int id){     //3 WBBs recive their ID corrosponding with the weapon they stand for e.g. ID 1 stands for MashineGun, which costs 200$
        price = priceArray[id];         //sets the purchasing price to the specific weapon type
        weaponID = id;
    }
    public void act()
    {
        checkPressed();
    }
    public void checkPressed(){
        if(Greenfoot.mouseClicked(this))
        {
            if(Money.money >= price && weaponPlaceable == false) //if there hasn't already been a weapon purchased and enough money is available subtract money and set both values accordingly
            {
                Money.money = Money.money-price;
                weaponPlaceable = true;
                weaponPlaceableID = weaponID;
            }
            else if(Money.money < price) //if not enough money, flash
            {
                Money.notEnoughMoney = true;
            }
        }
    }
    
}
