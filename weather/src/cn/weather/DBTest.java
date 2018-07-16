package cn.weather;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {

	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			//String sql = "insert into student(id,name,age,dept,address) values('1507','Tom',20,'¼ÆËã»ú','ºþÄÏ')";
			
			//b.execute(sql);
			ResultSet rs = b.executeQuery("select * from Question;");
			ArrayList<Student> list = new ArrayList();
			while(rs.next()){
				int id = rs.getInt(1);
				String question = rs.getString(2);
				String opt_one = rs.getString(3);
				String opt_two = rs.getString(4);
				String opt_three = rs.getString(5);
				String opt_four = rs.getString(6);
				String anwser = rs.getString(7);
				Student t = new Student(id, question, opt_one, opt_two, opt_three,opt_four,anwser);
				list.add(t);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				int k = 0;
				while(k < 4){
					if(ques[k] == randnumber)
						break;
						k++;
				}
				if(k == 4){ 
					ques[j] = randnumber;
					j++;
				}
			}
			int h = 0,p = 1;
			for(int k = 0; k < 4; k++){
				Student s = list.get(ques[h]);
				System.out.print(p + " . ");
				System.out.println(s.getQuestion());
				h++;
				p++;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
