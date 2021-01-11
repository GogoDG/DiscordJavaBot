package bot;

import java.io.*;
import java.nio.charset.*;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class Messages {
	
	 public void sendMessage(JDA jda) {
	        
	        Thread thread = new Thread(() -> {
	        String line;
	        TextChannel tch = jda.getTextChannelById(785180200836005938L);
	        	 try {	
	                    InputStream fis = new FileInputStream("C:\\Users\\GogoDG\\eclipse-workspace\\DiscordJavaBot\\resources\\msgs.txt");
	                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
	                    BufferedReader br = new BufferedReader(isr);
	                {
	                while ((line = br.readLine()) != null) {
	                    // Deal with the line
	                	tch.sendMessage("**"+line+"**").queue();
	                    System.out.println("Posting: " + line + "...");

	                    try {
	                        System.out.println("Sleeping for 60 seconds...");
	                        //Thread.sleep(1800000); // every 30 minutes
	                        Thread.sleep(60000); // every 60 seconds
	                    } catch (InterruptedException et) {
	                        et.printStackTrace();
	                    }

	                }
	            }
	            br.close();
	        } catch (IOException et) {
	        	System.out.println("Something's wrong...");
	        }
	        	
	        });
	       thread.start();

	    }

}
