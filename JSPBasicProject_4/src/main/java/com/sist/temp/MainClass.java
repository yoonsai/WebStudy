package com.sist.temp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container c=new Container();
		Model m=c.getBean("board");
		m.execute();
		
		Model m1=c.getBean("board");
		m1.execute();
		
		Model m2=c.getBean("board");
		m2.execute();
		
		System.out.println("m="+m);
		System.out.println("m="+m1);
		System.out.println("m="+m2);
		
	}

}
