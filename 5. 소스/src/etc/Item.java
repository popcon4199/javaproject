package etc;

public class Item {

	
		
		//이용내역 누적.
	private static int lockid; //라커번호	
	public String category;	//부대시설 이름
	public String menu;		//메뉴 
	public String ea;		//수량 
	public int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getLockid() {
		return lockid;
	}
	public static void setLockid(int lockid) {
		Item.lockid = lockid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
	}
	@Override
	public String toString() {
		return "Item [category=" + category + ", menu=" + menu + ", ea=" + ea + "]";
	}
	
	
	
	
		
	
	
}//class










