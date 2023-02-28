import greenfoot.*; 
/** Counts and returns money
 * 
 */
public class Money extends UI
{
    static int money;
    static boolean notEnoughMoney;
    public void act()
    {
        moneyDisplay();
        getMoney();
    }
    public void moneyEarned(int newMoney)
    {
        money = money + newMoney;
    }
    public int getMoney(){
        return money;
    }
    public void moneyDisplay()
    {
        if(notEnoughMoney == false){
            this.setImage(new GreenfootImage(Integer.toString(money), 45, Color.YELLOW, new Color(0,0,0,0)));
        }
        if(notEnoughMoney == true){ //flash in red if not enough money is available to buy a certain gun/upgrade
            this.setImage(new GreenfootImage(Integer.toString(money), 45, Color.RED, new Color(110,110,110,110)));
            Greenfoot.delay(10); //delay unoptimized solution here -> entire game freezes shortly but for loop didn't work
            notEnoughMoney = false;
        }        
    }
}
