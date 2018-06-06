package com.swim.model;

import java.util.ArrayList;

public class Asn{

	private int asn;
	private String vendorId;
	private String expectedArrivalDate;
	private String expectedArrivalTime;
	private String status;
	private ArrayList<Products> serials;
	private String dockDoor;

	// No Args Constructor
	public Asn() {
	}

    public ArrayList<Products> getSerials() {
        return serials;
    }

    public void setSerials(ArrayList<Products> serials) {
        this.serials = serials;
    }

    // Getters and Setter
	public int getAsn() {
		return asn;
	}

	public void setAsn(int asn) {
		this.asn = asn;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public void setExpectedArrivalDate(String expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public String getExpectedArrivalTime() {
		return expectedArrivalTime;
	}

	public void setExpectedArrivalTime(String expectedArrivalTime) {
		this.expectedArrivalTime = expectedArrivalTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public String getDockDoor() {
        return dockDoor;
    }

    public void setDockDoor(String dockDoor) {
        this.dockDoor = dockDoor;
    }
}
