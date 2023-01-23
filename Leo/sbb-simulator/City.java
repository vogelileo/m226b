import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class City
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class City extends Actor
{
    private String name;
    private boolean selected = false;
    public int xPos;
    public int yPos;
    
    public City(String name,int xPos, int yPos ){
        this.name = name;
        this.xPos  = xPos;
        this.yPos = yPos;
    }

    
    public void setSelected(boolean select){
        this.selected = select;
    }
    
    
    /**
     * Act - do whatever the City wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        if(selected){
            GreenfootImage backgroundBlue = new GreenfootImage("blue-draught.png");
            setImage(backgroundBlue);
            
        }else{
            GreenfootImage backgroundRed = new GreenfootImage("red-draught.png");
            setImage(backgroundRed);
        }
        

        if(Greenfoot.mouseClicked(this)){
            MasterWorld world = (MasterWorld)getWorld();
            WorldController controller = world.worldController;
            controller.selectCity(this);
        }
            
    }
}
