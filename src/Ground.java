import greenfoot.*;  

/** Ground for enemys to move on
 *  Type is given by MainWorld.pathArray[i][j]
 */
public class Ground extends Actor
{
    public int type;
    public Ground(int type){
        this.type=type;
    }
}
