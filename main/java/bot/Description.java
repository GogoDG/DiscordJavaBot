package bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Description extends ListenerAdapter{
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		if(e.getMessage().getContentRaw().equals(".facade")) {
			e.getChannel().sendMessage("Facade is a computer software company in the HD Universe. The player can buy stocks from them on the Bawsaq.com website in Grand Theft Auto V.").queue();
		}
	}
	
}
