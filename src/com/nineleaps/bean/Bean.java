package com.nineleaps.bean;

public class Bean {
private String name;
private String designation;
private String manager;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
@Override
public String toString() {
	return "Bean [name=" + name + ", designation=" + designation + ", manager="
			+ manager + "]";
}
public Bean() {
	super();
	// TODO Auto-generated constructor stub
}

}
