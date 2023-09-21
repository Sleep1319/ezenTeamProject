package storeProject.store.basket;
//디비에 있는 값으로 돌아가니 이걸 활용할 필요가 없나?
public class BasketDTO {
	private int basketID;
	private int inherenceID;
	private int itemID;
	
	public int getBasketID() {
		return basketID;
	}
	public void setBasketID(int basketID) {
		this.basketID = basketID;
	}
	public int getInherenceID() {
		return inherenceID;
	}
	public void setInherenceID(int inherenceID) {
		this.inherenceID = inherenceID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	public BasketDTO(int basketID, int inherenceID, int itemID) {
		super();
		this.basketID = basketID;
		this.inherenceID = inherenceID;
		this.itemID = itemID;
	}
	
}
