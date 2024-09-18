import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in.
 * 
 * @author Maggie
 * @version September 2024
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel = new Label(0, 80);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create a label
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    // Ends the game and draw "GameOver"
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    
    // Increases the score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    
    // Creates a new apple at random locations at the top of the screen
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
