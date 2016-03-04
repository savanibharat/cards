package com.learninghorizon.user;

import java.util.LinkedHashMap;
import java.util.Map;

import com.learninghorizon.misc.JSONUtils;

/**
 * Override 
 * {@link Object#equals(Object)}
 * {@link Object#hashCode()}
 * {@link Object#toString()}
 * */
public final class Address {

	private String address1;
	private String address2;
	private String pinCode;
	private String city;
	private String country;

	private Address(final AddressBuilder addressBuilder) {
		super();
		this.address1 = addressBuilder.address1;
		this.address2 = addressBuilder.address2;
		this.pinCode = addressBuilder.pinCode;
		this.city = addressBuilder.city;
		this.country = addressBuilder.country;
	}

	public static class AddressBuilder {

		private String address1;
		private String address2;
		private String pinCode;
		private String city;
		private String country;

		public AddressBuilder() {
		}

		public AddressBuilder address1(final String address1) {
			this.address1 = address1;
			return this;
		}

		public AddressBuilder address2(final String address2) {
			this.address2 = address2;
			return this;
		}

		public AddressBuilder pinCode(final String pinCode) {
			this.pinCode = pinCode;
			return this;
		}

		public AddressBuilder city(final String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder country(final String country) {
			this.country = country;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
	}

	public String address1() {
		return address1;
	}

	public String address2() {
		return address2;
	}

	public String pinCode() {
		return pinCode;
	}

	public String city() {
		return city;
	}

	public String country() {
		return country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		return true;
	}

	@Override
	public String toString() {

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("address1", this.address1());
		map.put("address2", this.address2());
		map.put("pinCode", this.pinCode());
		map.put("city", this.city());
		map.put("country", this.country());

		return JSONUtils.convertMapToString(map).toString();
	}
}
