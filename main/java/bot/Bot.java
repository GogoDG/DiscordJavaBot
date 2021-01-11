package bot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot {
	ListenerAdapter[] la = new ListenerAdapter[] {new Description(), new Commands(), new InvokeStock(), new InvokeAdmins(), new InvokeReps(), new InvokeClients()};
	String token;
	JDA jda;
	
	public Bot(String token) {
		this.token = token;
	}
	
	public void start() {
		JDABuilder jdaBld = JDABuilder.createDefault(token);
		jdaBld.setActivity(Activity.playing("Stonks"));
		Messages msg = new Messages();
		jdaBld.addEventListeners(la);
		try {
			jda = jdaBld.build();
			jda.awaitReady();
			msg.sendMessage(jda);
		} catch(LoginException e) {
			System.out.println("Unsuccessful login.");
		} catch(InterruptedException e) {
			System.out.println("Something's wrong...");
		}
		
	}
}
