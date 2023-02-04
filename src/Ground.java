import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (titi) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    public int type;
    
    
    //constructor für path
    //consturctor ist neue methode
    public Ground(int type){
        this.type=type;
        //if(type==5){
        //    GreenfootImage image = new GreenfootImage("nfloor.png");
        //    image.scale(1,1);
        //    this.setImage("flooryy.png");
        //}
        
    }
    public int getType(){
        return this.type;
    }
    
    public void act()
    {
        
    }
    
    
}
