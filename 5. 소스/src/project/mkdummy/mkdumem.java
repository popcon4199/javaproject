package project.mkdummy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class mkdumem {

	public static Random rnd = new Random();
	public static void main(String[] args) {
		mkmem();
	}

	private static void mkmem() {
		ArrayList<String>list = new ArrayList<String>();
		
		
		
		for(int i=1; i<=2000; i++) {
			
			String test = String.format("sy%03d|%s|%s|%s|%s|%s|%s|%s|%s|%d",i,mkid(),mkid(),mkname(),mkage(),mkgen()
					,mkaddress(),mktel(),mkresister(),mkmil());
		
			
			System.out.println(test);
			list.add(test);
		}
			String path = ".\\dat\\Member2.dat";
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			for(String s : list) {
				writer.write(s+"\r\n");
				writer.flush();
			}
			writer.close();
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		
		
	}

	private static int mkmil() {
		
		int mile = rnd.nextInt(50001);
		
		return mile;
	}

	private static String mkresister() {
		ArrayList<String>list = new ArrayList<String>();
		
		Calendar c = Calendar.getInstance();
		c.set(2019, 0, 1);
		
		while(!String.format("%tF",c).equals(String.format("%tF", Calendar.getInstance()))){  //오늘 까지 데이터 추가
		
			String temp = String.format("%tF", c);
				
			list.add(temp);
							
			c.add(Calendar.DATE,1);
			
		}
		
		String[]cal = new String[list.size()];
		int i=0;
		for(String d : list) {
			cal[i]=list.get(i);
			i++;
		}
		
				
		return cal[rnd.nextInt(cal.length)]+"";
	}

	private static String mktel() {
		
		int num = rnd.nextInt(100000000);
		
		return "010"+String.format("%08d", num);
	}

	private static String mkaddress() {
		
		String[] city = {"서울시","대전시","울산시","대구시","의정부시","수원시","남양주시","부산시","광주시","춘천시"};
		String[] goo = {"강남구","종로구","중구","성북구","동래구","남구","서구","동구","북구","관악구","송파구","노원구"	};
		String[] dong = {"효자동","사직동","가회동","혜화동","창신동","종로동","이화동","무악동","평창동","무암동"};
		
		String add = city[rnd.nextInt(city.length)]+goo[rnd.nextInt(goo.length)]+dong[rnd.nextInt(dong.length)];
		
		return add;
	}

	private static boolean mkgen() {
		
		boolean gen = rnd.nextBoolean();
		
		return gen;
	}

	private static String mkage() {
		
		int age =0;
		age = rnd.nextInt(70)+10;
		
	
		return age+"";
	}

	private static String mkname() {
		String[] one = {"김","최","왕","유","이","건","신","오","차","홍","문","우","류","하"};
		String[] two = {"재","종","윤","원","병","행","형","성","희","신","장","유","소","진"};
		String[] three = {"소","경","양","용","준","수","연","창","존","무","하","규","중"};
		
		String name = one[rnd.nextInt(one.length)]+two[rnd.nextInt(two.length)]+three[rnd.nextInt(three.length)];
		
		
		return name;
	}

	private static String mkid() {
		String name = "";
		String[] a = new String[52];
		for(int i=0; i<26; i++) {
			a[i] = (char)('a'+i)+"";
		}
		for(int i=0; i<26; i++) {
			a[i+26] = (char)('A'+i)+"";
		}
		for(int i=0; i<8; i++) {
			name+=a[rnd.nextInt(a.length)];
		}
		
		
		return name;
	}
}
