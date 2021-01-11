package bot;

import java.sql.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InvokeClients extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		displayClients(e);
	}
	
	public void displayClients(MessageReceivedEvent e) {
		SQLConnection sql = new SQLConnection();
		Connection conn = sql.getConnection();
		String query = "SELECT firstname, lastname, company FROM clients";
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(e.getMessage().getContentRaw().equals(".clientlist")) {
				e.getChannel().sendMessage("Clients are: ").queue();
				while(rs.next()) {
					String data1 = rs.getString("firstname");
					String data2 = rs.getString("lastname");
					String data3 = rs.getString("company");
				
					e.getChannel().sendMessage(data1 + " " + data2 + " representing " + data3 + " company.").queue();
				}
			}
			conn.close();
		} catch (SQLException e1) {
			System.out.println("Something's wrong...");
		}
	}

}