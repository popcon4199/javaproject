package Stream;

import java.util.ArrayList;

import java.util.HashMap;
import etc.Item;

public class locker {
	
	private ArrayList<Item> items = new ArrayList<Item>(); //사용 항목

	private static ArrayList<locker>lockers;
	private int test;
	private String type; //목욕, 찜질
	private String person; //대인 소인
	private ArrayList<String>recipt;  //종류             ->정렬 어떻게할까? 하려면 String으로 합쳤다가 정렬 후 나눠야함.
	private ArrayList<Integer>number;  //개수
	private ArrayList<Integer>price; //단위가격
	private String membership;  //회원번호
	private int lockernum;  //락커번호
	private String lockerpw;  //락커비번
	private int charge; //입장료 
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public int getLockernum() {
		return lockernum;
	}

	public void setLockernum(int lockernum) {
		this.lockernum = lockernum;
	}

	public String getLockerpw() {
		return lockerpw;
	}

	public void setLockerpw(String lockerpw) {
		this.lockerpw = lockerpw;
	}

	public locker() {
		
		this.test = 0;
		this.membership="비회원";
		this.type = "남녀대소";
		this.recipt = recipt;
		this.number = number;
		this.price = price;
	}

	static {
		lockers = new ArrayList<locker>();
	}
			
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getRecipt() {
		return recipt;
	}

	public void setRecipt(ArrayList<String> recipt) {
		this.recipt = recipt;
	}

	public ArrayList<Integer> getNumber() {
		return number;
	}

	public void setNumber(ArrayList<Integer> number) {
		this.number = number;
	}

	public ArrayList<Integer> getPrice() {
		return price;
	}

	public void setPrice(ArrayList<Integer> price) {
		this.price = price;
	}

	public static ArrayList<locker> getLockers() {
		return lockers;
	}

	public static void setLockers(ArrayList<locker> lockers) {
		locker.lockers = lockers;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		return "locker [test=" + test + ", type=" + type + ", person=" + person + ", recipt=" + recipt + ", number="
				+ number + ", price=" + price + ", membership=" + membership + ", lockernum=" + lockernum
				+ ", lockerpw=" + lockerpw + "]";
	}

	
	
	
}
