package cn.weather;



public class Student {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getxone() {
		return xone;
	}

	public void setOpt_one(String xone) {
		this.xone = xone;
	}

	public String getxtwo() {
		return xtwo;
	}

	public void setOpt_two(String xtwo) {
		this.xtwo = xtwo;
	}

	public String getOpt_three() {
		return xthree;
	}

	public void setOpt_three(String xthree) {
		this.xthree = xthree;
	}
	
	public String getOpt_four(){
		return xfour;
	}
	
	public void setOpt_four(String xfour){
		this.xfour = xfour;
	}
	
	public String getAnwser(){
		return anwser;
	}
	public void setAnwser(String anwser){
		this.anwser = anwser;
	}

	public int id;
	public String question;
	public String xone;
	public String xtwo;
	public String xthree;
	public String xfour;
	public String anwser;
	
	public Student() {
		
	}
	public Student(int id, 
			String question, String xone, 
			String xtwo, String xthree, String xfour, String answer) {
		this.id = id;
		this.question = question;
		this.xone = xone;
		this.xtwo = xtwo;
		this.xthree = xthree;
		this.xfour = xfour;
		this.anwser = answer;
	}
	public static void main(String[] args) {
		

	}

}

