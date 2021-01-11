package bot;

import java.sql.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InvokeStock extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		displayStock(e);
	}
	
	public void displayStock(MessageReceivedEvent e) {
		SQLConnection sql = new SQLConnection();
		Connection conn = sql.getConnection();
		String query = "SELECT product_name, product_brand FROM products";
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(e.getMessage().getContentRaw().equals(".stock")) {
				e.getChannel().sendMessage("Stock is: ").queue();
				while(rs.next()) {
					String data1 = rs.getString("product_brand");
					String data2 = rs.getString("product_name");
				
					e.getChannel().sendMessage(data1 + " " + data2).queue();
				}
			}
			conn.close();
		} catch (SQLException e1) {
			System.out.println("Something's wrong...");
		}
	}

}
