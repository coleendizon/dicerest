package hello;

import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DiceController {
	 @RequestMapping(value = "/randomnumber", method = RequestMethod.GET)
	 public List<Dice> randomnum(){ 
		 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 //DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
		 //Connection conn = myFactory.getConnection();
		 //PreparedStatement ps = null;
		 //String query = "";
		 
		 List <Dice> dicelist = new ArrayList<Dice>();
		 Random rand = new Random();
		 for(int i=1;i<=3; i++) {
			  Dice dice = new Dice();
			  dice.setName("Dice " + i + ":");
			  dice.setDice(rand.nextInt(6)+1);
			  dicelist.add(dice);
		 }
		 /*
		 try { 
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  
				  query = "insert into random_number (dice1, dice2, dice3, timestamp) values (?,?,?,?)";
				  ps = conn.prepareStatement(query);
				  ps.setInt(1, dicelist.get(0).getDice());
				  ps.setInt(2, dicelist.get(1).getDice());
				  ps.setInt(3, dicelist.get(2).getDice());
				  ps.setString(4, sdf.format(timestamp));
				  ps.executeUpdate();
			  }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  */
		 return dicelist;
		 
	 
	 }
	 








}

