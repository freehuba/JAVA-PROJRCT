package com.components.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String f;
	private String g;
	private String h;
	private String i;
	private String j;
	private String k;
	private String l;
	private String m;
	private String n;
	public String getA() {
		return a;
	}
	public void setA(String o) {
		this.a = o;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	public String getJ() {
		return j;
	}
	public void setJ(String j) {
		this.j = j;
	}
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getL() {
		return l;
	}
	public void setL(String l) {
		this.l = l;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public User(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j,
			String k, String l, String m, String n) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
		this.j = j;
		this.k = k;
		this.l = l;
		this.m = m;
		this.n = n;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
