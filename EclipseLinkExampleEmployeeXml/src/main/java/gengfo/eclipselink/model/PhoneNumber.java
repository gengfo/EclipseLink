/*******************************************************************************
 * Copyright (c) 1998, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * 		dclarke - initial JPA Employee example using XML (bug 217884)
 ******************************************************************************/
package gengfo.eclipselink.model;


import java.io.Serializable;

public class PhoneNumber implements Serializable {
	private int id;
	private String areaCode;
	private String number;
	private String type;
	private Employee owner;

	public PhoneNumber() {
	}

	public PhoneNumber(String type, String areaCode, String number) {
		this();
		setType(type);
		setAreaCode(areaCode);
		setNumber(number);
	}

	public String getAreaCode() { 
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int empId) {
		this.id = empId;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String pNumber) {
		this.number = pNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Employee getOwner() {
		return this.owner;
	}

	protected void setOwner(Employee employee) {
		this.owner = employee;
		this.id = employee.getId();
	}
	
	public String toString() {
		return "Phone([" + getType() + "] " + getAreaCode() + " - " + getNumber() + ")";
	}

	public static class ID implements Serializable {
		public int id;
		public String type;

		public ID() {
		}

		public ID(int empId, String type) {
			this.id = empId;
			this.type = type;
		}

		public boolean equals(Object other) {
			if (other instanceof ID) {
				final ID otherID = (ID) other;
				return otherID.id == id && otherID.type.equals(type);
			}
			return false;
		}

		public int hashCode() {
			return super.hashCode();
		}
	}
}
