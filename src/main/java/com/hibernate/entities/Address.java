package com.hibernate.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity /*
		 * Tells hibernate that the table for the mentioned class with the field
		 * provided have to be created in the database.
		 */
@Table(name = "address") /* Tells hibernate that the name of table should be "address" */
public class Address {

	@Id /* Tells hibernate about the primary key. */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*
														 * Tells hibernate that it should be incremented automatically.
														 */
	@Column(name = "addressId") /* Tells hibernate that the column name in the database should be "addressId" */
	private int addressId;

	@Column(name = "country", length = 100) /* length specifies that maximum allowed length will be 100 characters */
	private String country;

	@Column(name = "state", length = 100)
	private String state;

	@Column(name = "city", length = 100)
	private String city;

	@Column(name = "TrainFacilityAvailable")
	private boolean isTrainAvailable;

	@Column(name = "BusFacilityAvailable")
	private boolean isBusAvailable;

	@Transient /*
				 * Tells hibernate that we should not be creating collumn for this field in the
				 * database.
				 */
	private double longitude;

	@Transient
	private double latitude;

	@Temporal(TemporalType.DATE) /* Used for specifying the format in which we require the date. */
	@Column(name = "arrivalDate")
	private Date arrivalDate;

	@Lob /* Tells hibernate that it is large object */
	@Column(name = "cityImage")
	private byte[] image;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String country, String state, String city, boolean isTrainAvailable,
			boolean isBusAvailable, double longitude, double latitude, Date arrivalDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.isTrainAvailable = isTrainAvailable;
		this.isBusAvailable = isBusAvailable;
		this.longitude = longitude;
		this.latitude = latitude;
		this.arrivalDate = arrivalDate;
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isTrainAvailable() {
		return isTrainAvailable;
	}

	public void setTrainAvailable(boolean isTrainAvailable) {
		this.isTrainAvailable = isTrainAvailable;
	}

	public boolean isBusAvailable() {
		return isBusAvailable;
	}

	public void setBusAvailable(boolean isBusAvailable) {
		this.isBusAvailable = isBusAvailable;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", isTrainAvailable=" + isTrainAvailable + ", isBusAvailable=" + isBusAvailable + ", longitude="
				+ longitude + ", latitude=" + latitude + ", arrivalDate=" + arrivalDate + ", image="
				+ Arrays.toString(image) + "]";
	}

}
