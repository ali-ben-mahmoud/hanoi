package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
    
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	int status = 0;
    	
    	/**********************************************************************/
        SwingControlDemo swingControlDemo = new SwingControlDemo();  
        swingControlDemo.showEventDemo();    
    	/**********************************************************************/
    	/**********************************************************************/

        // Configure the session factory
        /*configureSessionFactory();

        Session session = null;
        Transaction tx=null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Creating Contact entity that will be save to the sqlite database
            Contact myContact = new Contact(3, "My Name", "my_email@email.com");
            Contact yourContact = new Contact(24, "Your Name", "your_email@email.com");

            // Creating a game
            Game myGame = new Game(1, "First game", 3, 3);

            // Saving to the database
            session.save(myContact);
            session.save(yourContact);
            session.save(myGame);

            // Committing the change in the database.
            session.flush();
            tx.commit();

            // Fetching saved data
            @SuppressWarnings("unchecked")
			List<Contact> contactList = session.createQuery("from Contact").list();

            for (Contact contact : contactList) {
                System.out.println("Id: " + contact.getId() + " | Name:"  + contact.getName() + " | Email:" + contact.getEmail());
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }*/
    	/**********************************************************************/
        while(! swingControlDemo.getStartGameRequested()) {
        	System.out.println("Waiting start game...");
        	Thread.sleep(1000);
        }
        
        System.out.println("Start game requted :)");
        
    		Scanner scanner = new Scanner(System.in);
    	
    		// Enter data using BufferReader
    		BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
    		// Reading data using readLine
    		char from;
    		char to;
    		int movesCounter = 0;       
        
    		Game game = new Game(1, "Game1", 3, 3);
		
    		game.initGame();
    		game.displayGame();
        

    		while((! game.isGameFinished()) && (! swingControlDemo.getEndGameRequested())){
    			System.out.println("What is your next move?");
    			System.out.println("From?");
        	
    			from = scanner.next().charAt(0);

    			//System.out.println("You have entered: "+from);
            
    			System.out.println("To?");       	
    			to = scanner.next().charAt(0);
    			System.out.println("You have entered: "+to);
            

    			//game.moveDisk(Integer.parseInt(from), Integer.parseInt(to));
    			status = game.moveDisk(Character.getNumericValue(from), Character.getNumericValue(to));
            
    			if(status != 0) {
    				System.err.println("Something went wrong at line 129, file App.java");
    				System.exit(status);
    			}
            
    			switch(movesCounter) {
            		case 0:
            			System.out.println("Game after 1st move");
            			break;
            		case 1:
            			System.out.println("Game after 2nd move");
            			break;
            		case 2:
            			System.out.println("Game after 3rd move");
            			break;
            		default:
            			System.out.println("Game after " + (movesCounter + 1) + "th move");
            			break;
            
    			}
            
	            //Display the game
	            game.displayGame();
	
	            //Increment movesCounter
	        	movesCounter++;
    		}
        
    		if(game.isGameFinished()) {
    			System.out.println("Congratulations!! Game finished after " + movesCounter + " moves");
    		}
    		else {
    			System.out.println("Game abort requested !!!");
    			System.exit(status);
    		}
    	
    	};
        
    
}
