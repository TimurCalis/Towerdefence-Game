import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money extends UI
{
    static int money;
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        this.setImage(new GreenfootImage(Integer.toString(money), 45, Color.YELLOW, new Color(0,0,0,0)));
    }
}
