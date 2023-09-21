package storeProject.store.pay;

public class PayDTO {
	private int payinfoID;
	private int inherenceID;
	private String merchantID;
	private String impID;
	private int itemID;
	private String itemName;
	private int buyCount;
	private int totalAmount;
	private String itemType;
	private String buyerEmail;
	private String buyerName;
	private String buyerTel;
	private String buyerAddr;
	private String buyerPost;
	
	public int getPayinfoID() {
		return payinfoID;
	}
	public void setPayinfoID(int payinfoID) {
		this.payinfoID = payinfoID;
	}
	public int getInherenceID() {
		return inherenceID;
	}
	public void setInherenceID(int inherenceID) {
		this.inherenceID = inherenceID;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	public String getImpID() {
		return impID;
	}
	public void setImpID(String impID) {
		this.impID = impID;
	}
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
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerTel() {
		return buyerTel;
	}
	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}
	public String getBuyerAddr() {
		return buyerAddr;
	}
	public void setBuyerAddr(String buyerAddr) {
		this.buyerAddr = buyerAddr;
	}
	public String getBuyerPost() {
		return buyerPost;
	}
	public void setBuyerPost(String buyerPost) {
		this.buyerPost = buyerPost;
	}
	
	public PayDTO(int payinfoID, int inherenceID, String merchantID, String impID, int itemID, String itemName,
			int buyCount, int totalAmount, String itemType, String buyerEmail, String buyerName, String buyerTel,
			String buyerAddr, String buyerPost) {
		super();
		this.payinfoID = payinfoID;
		this.inherenceID = inherenceID;
		this.merchantID = merchantID;
		this.impID = impID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.buyCount = buyCount;
		this.totalAmount = totalAmount;
		this.itemType = itemType;
		this.buyerEmail = buyerEmail;
		this.buyerName = buyerName;
		this.buyerTel = buyerTel;
		this.buyerAddr = buyerAddr;
		this.buyerPost = buyerPost;
	}
	
	
}
