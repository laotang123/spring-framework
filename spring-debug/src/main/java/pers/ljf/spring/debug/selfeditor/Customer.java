package pers.ljf.spring.debug.selfeditor;

/**
 * @author: ljf
 * @date: 2021/3/28 12:25
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class Customer {
	private String name;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"name='" + name + '\'' +
				", address=" + address +
				'}';
	}
}
