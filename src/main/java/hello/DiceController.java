package hello;

import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {
	 @RequestMapping(value = "/randomnumber", method = RequestMethod.GET)
	 public List<Dice> randomnum(){ 
		 SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
		 DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
		 Connection conn = myFactory.getConnection();
		 PreparedStatement ps = null;
		 String query = "";
		 
		 List <Dice> dicelist = new ArrayList<Dice>();
		 Random rand = new Random();
		  
		 try { 
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  sdf.format(timestamp);
		  
		  for(int i=1;i<=3; i++) {
			  Dice dice = new Dice();
			  dice.setName("Dice " + i + ":");
			  dice.setDice(rand.nextInt(6)+1);
			  dicelist.add(dice);
			  
				  query = "insert into random_number (dice1, dice2, dice3, timestamp) values (?,?,?,?)";
				  ps = conn.prepareStatement(query);
				  
			  }}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  
		 return dicelist;}
	 








}

