package com.swim.model;

public class Asn{

	private int asn;
	private String vendorId;
	private String expectedArrivalDate;
	private String expectedArrivalTime;
	private String status;
	private Products[] serials;

	// No Args Constructor
	public Asn() {
	}

    public Products[] getSerials() {
        return serials;
    }

    public void setSerials(Products[] serials) {
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



}
