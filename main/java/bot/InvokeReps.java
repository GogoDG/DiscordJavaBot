package bot;

import java.sql.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InvokeReps extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		displayReps(e);
	}
	
	public void displayReps(MessageReceivedEvent e) {
		SQLConnection sql = new SQLConnection();
		Connection conn = sql.getConnection();
		String query = "SELECT firstname, lastname, username FROM sales_rep";
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(e.getMessage().getContentRaw().equals(".replist")) {
				e.getChannel().sendMessage("Sales Representatives are: ").queue();
				while(rs.next()) {
					String data1 = rs.getString("firstname");
					String data2 = rs.getString("lastname");
					String data3 = rs.getString("username");
				
					e.getChannel().sendMessage(data1 + " " + data2 + " with the username: " + data3).queue();
				}
			}
			conn.close();
		} catch (SQLException e1) {
			System.out.println("Something's wrong...");
		}
	}

}
