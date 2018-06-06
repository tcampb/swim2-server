package com.swim.model;

public class Products {
	private int asn;
	private int serial;
	private boolean received;
	private boolean delivered;

	// No Args Constructor
	public Products() {
	}

	// Getters and Setter
	public int getAsn() {
		return asn;
	}

	public void setAsn(int asn) {
		this.asn = asn;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public boolean getReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	public boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
}
