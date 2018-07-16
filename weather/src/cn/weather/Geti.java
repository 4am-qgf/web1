package cn.weather;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import cn.weather.DBConnection;

public class Geti extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from question;");
			
			int id = 0;
			String question = "";
			String xone = "";
			String xtwo = "";
			String xthree = "";
			String xfour = "";
			String anwser = "";
			
			int count = 0;
			ArrayList<Student> list = new ArrayList<Student>();
			while(rs.next()){
				count++;
				id = rs.getInt(1);
				question = rs.getString(2);
				xone = rs.getString(3);
				xtwo = rs.getString(4);
				xthree = rs.getString(5);
				xfour = rs.getString(6);
				anwser = rs.getString(7);
				Student q = new Student(id, question, xone, xtwo, xthree,xfour,anwser);
				list.add(q);
			}
			db.close();
			
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
//			int h = 0,p = 1;
//			for(int k = 0; k < 4; k++){
//				Question s = list.get(ques[h]);
//				System.out.print(p + " . ");
//				System.out.println(s.getQuestion());
//				h++;
//				p++;
//			}	
			
			int h = 0;
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			Student q1 = list.get(ques[h]);
			obj1.put("id", id);
			obj1.put("question", q1.question);
			obj1.put("xone", q1.xone);
			obj1.put("xtwo", q1.xtwo);
			obj1.put("xthree", q1.xthree);
			obj1.put("xfour", q1.xfour);
			obj1.put("anwser", q1.anwser);
			obj.put("question1",obj1);
			h++;
			
			JSONObject obj2 = new JSONObject();
			Student q2 = list.get(ques[h]);
			obj2.put("id", id);
			obj2.put("question", q2.question);
			obj2.put("xone", q2.xone);
			obj2.put("xtwo", q2.xtwo);
			obj2.put("xthree", q2.xthree);
			obj2.put("xfour", q2.xfour);
			obj2.put("anwser", q2.anwser);
			obj.put("question2",obj2);
			h++;
			
			JSONObject obj3 = new JSONObject();
			Student q3 = list.get(ques[h]);
			obj3.put("id", id);
			obj3.put("question", q3.question);
			obj3.put("xone", q3.xone);
			obj3.put("xtwo", q3.xtwo);
			obj3.put("xthree", q3.xthree);
			obj3.put("xfour", q3.xfour);
			obj3.put("anwser", q3.anwser);
			obj.put("question3",obj3);
			h++;
			
			JSONObject obj4 = new JSONObject();
			Student q4 = list.get(ques[h]);
			obj4.put("id", id);
			obj4.put("question", q4.question);
			obj4.put("xone", q4.xone);
			obj4.put("xtwo", q4.xtwo);
			obj4.put("xthree", q4.xthree);
			obj4.put("xfour", q4.xfour);
			obj4.put("anwser", q4.anwser);
			obj.put("question4",obj4);
			h++;
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Geti();
	}

}
