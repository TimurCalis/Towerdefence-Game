import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends UI
{
    int id;   
    String[] textArray = {"Click through the tips by \n pressing 1 again. \n Close the tips \n by opening the shop",
                          "Your lives", 
                          "Your current money", 
                          "The current wave will \n be displayed above", 
                          "Starts the next wave",
                          "Opens the shop",
                          "Here you can choose\n between 3 towers", 
                          "1.The Cannon \n medium rate of fire \n  medium damage", 
                          "2.The Mashine Gun \n high rate of fire \n low damage", 
                          "3.The Mashine Gun \n low rate of fire \n high damage",
                          "After buying click on one \n of the turret bases \n to place the turret",
                          "You can also upgrade an \n existing turret by clicking on it \n after having bought the same type again",
                          "Upgrades grant several advantages:\n 1. Increased reload speed\n 2. range increase\n 3. higher attack damage",
                          "Some waves come with \n a high frequency of opponents, \n others consist of tankier units. \n So spend your money wisely ;)"};
    static int textCord[][] = {{7,5},{10,2},{20,2},{5,3},{26,20},{22,22},
                               {25,14},{21,2},{21,6},{21,9},{15,20},{15,20},{15,20},{15,20}};
                                       // super(31, 24, 21);
    public Text(int id)
    {
        this.id = id;
    }
    public void act()
    {
        this.setImage(new GreenfootImage((textArray[id]), 25, Color.BLACK, new Color(110,110,110,150)));
        //checkForF1();
    }
    
}
