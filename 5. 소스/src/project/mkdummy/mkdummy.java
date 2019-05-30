package project.mkdummy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class mkdummy {
	public static void main(String[] args) {
		
		
		
		
		mkd("된장찌개",7000);
		mkd("김치찌개",7000);
		mkd("제육쌈밥",8000);
		mkd("라면",4000);
		mkd("떡만둣국",6000);
		mkd("국수",6000);
		mkd("우동",6000);
		mkd("돈까스",10000);
		mkd("치킨",15000);

	
	//35 line에서 dat path 확인하고 쓸 것
	//mkd("파일이름",가격)
	
	
	
	}

	private static void mkd(String filename, int price) {
		Calendar c = Calendar.getInstance();
		Random rnd = new Random();   //물품 갯수 랜덤
		ArrayList<String> list = new ArrayList<String>(); 
		String path = "dat\\"+filename+".dat";  //저장위치, 저장 데이터 이름
		int i=0;
		c.set(2019,0,1);  //2019.01.01부터
		
		
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			while(!String.format("%tF",c).equals(String.format("%tF", Calendar.getInstance()))){  //오늘 까지 데이터 추가
				String temp = "";
				int num =(rnd.nextInt(900)+100);		  	//물품 갯수 	
				int stock = (rnd.nextInt(100)+500);			//재고
				int warehousing = (rnd.nextInt(100)+800);	//입고
				temp = String.format("%03d|%d|%d|%d|%d|%s",i,num,num*price,stock,warehousing,String.format("%tF", c));
				System.out.println(temp);
				list.add(temp);
								
				c.add(Calendar.DATE,1);
				i++;
			}
			
			for(String s : list) {
				
				writer.write(s+"\r\n"); 
				
			}
			
			writer.close();
			
			
			
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

}


