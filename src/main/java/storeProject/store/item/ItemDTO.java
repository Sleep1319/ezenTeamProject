package storeProject.store.item;

public class ItemDTO {
	private int itemID;
    private String itemName;
    private int itemAmount;
    private String itemType; 
    private int itemCount;
	private String itemImg;
	private String itemInfoDetail;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemInfoDetail() {
		return itemInfoDetail;
	}

	public void setItemInfoDetail(String itemInfoDetail) {
		this.itemInfoDetail = itemInfoDetail;
	}

	public ItemDTO(int itemID, String itemName, int itemAmount, String itemType, int itemCount, String itemImg, String itemInfoDetail) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.itemType = itemType;
		this.itemCount = itemCount;
		this.itemImg = itemImg;
		this.itemInfoDetail = itemInfoDetail;

	}
}
