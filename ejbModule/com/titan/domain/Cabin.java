package com.titan.domain;

import javax.persistence.*;

@Entity
@Table(name="CABIN")
public class Cabin implements java.io.Serializable {
	private int id;
	private String name;
	private int deckLevel;
	private int shipId;
	private int bedCount;
	
	@Id
	@Column(name="ID", nullable=false)
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	@Column(name="NAME", length=30)
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Column(name="DECK_LEVEL")
	public int getDeckLevel() { return deckLevel; }
	public void setDeckLevel(int deckLevel) { this.deckLevel = deckLevel; }
	
	@Column(name="SHIP_ID")
	public int getShipId() { return shipId; }
	public void setShipId(int shipId) { this.shipId = shipId; }
	
	@Column(name="BED_COUNT")
	public int getBedCount() { return bedCount; }
	public void setBedCount(int bedCount) { this.bedCount = bedCount; }
}
