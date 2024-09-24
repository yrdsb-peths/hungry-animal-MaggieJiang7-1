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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    String facing = "right";
    public Elephant(){
        for(int i = 0; i<8; i++){
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i<8; i++){
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant(){
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex+1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex+1) % idleLeft.length;
        }
    }
    
    
    public void act()
    {
        if (Greenfoot.isKeyDown("left")){
            facing = "left";
            move(-3);
        } else if (Greenfoot.isKeyDown("right")){
            move(3);
            facing = "right";
        }
        
        // Removes the apple if the elephant collides with it
        eat();
        animateElephant();
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
