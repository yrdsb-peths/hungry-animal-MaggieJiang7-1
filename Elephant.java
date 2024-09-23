import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our Hero
 * 
 * @author Maggie Jiang
 * @version September 2024
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephant.mp3");
    
    public void act()
    {
        if (Greenfoot.isKeyDown("left")){
            move(-3);
        } else if (Greenfoot.isKeyDown("right")){
            move(3);
        }
        
        // Removes the apple if the elephant collides with it
        eat();
    }
    
    
    // Eats the apple and spawn a new one
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
