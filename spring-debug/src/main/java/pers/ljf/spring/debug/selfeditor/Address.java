package pers.ljf.spring.debug.selfeditor;

/**
 * @author: ljf
 * @date: 2021/3/28 12:22
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class Address {
	private String city;
	private String province;
	private String town;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Address{" +
				"city='" + city + '\'' +
				", province='" + province + '\'' +
				", town='" + town + '\'' +
				'}';
	}
}
