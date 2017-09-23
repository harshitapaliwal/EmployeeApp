package com.nineleaps.bean;

import java.util.List;

public class Node {
private String name;
private String manager;
List<Node> nodelist;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}

public Node() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Node [name=" + name + ", manager=" + manager + ", nodelist="
			+ nodelist + "]";
}

}
