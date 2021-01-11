package bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		if(e.getMessage().getContentRaw().equals(".commands")) {
			e.getChannel().sendMessage("The commands are:\n.facade - Describing Facade's purpose\n.stock - Shows what stock Facade has\n.adminlist - Shows the admin list\n.replist - Shows the sales representatives list\n.clientlist - Shows you the client list").queue();
		}
	}
	
}
