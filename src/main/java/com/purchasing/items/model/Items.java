package com.purchasing.items.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sundar
 *
 */
@Entity
@XmlRootElement
@Table(name = "itemdetails")
public class Items {
	public Items() {

	}

	public Items(int itemid, String brand, String desc, boolean availablity, int price) {
		super();
		this.itemid = itemid;
		this.brand = brand;
		this.desc = desc;
		this.availablity = availablity;
		this.price = price;
	}

	@Id
	private int itemid;

	private String brand;

	private String desc;

	private boolean availablity;

	private int price;

	public int getItemid() {
		return itemid;
	}

	public String getBrand() {
		return brand;
	}

	public String getDesc() {
		return desc;
	}

	public boolean isAvailablity() {
		return availablity;
	}

	public int getPrice() {
		return price;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Items [itemid=" + itemid + ", brand=" + brand + ", desc=" + desc + ", availablity=" + availablity
				+ ", price=" + price + "]";
	}
}
