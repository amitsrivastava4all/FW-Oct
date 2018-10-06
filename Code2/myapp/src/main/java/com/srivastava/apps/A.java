package com.srivastava.apps;

public class A {
	private B zz;   // By Type will do <property Injection>
	public A(B x) {
		this.zz = x;
		System.out.println("A Call B Cons Call.....");
	}
	public A (int x , int y) {
		System.out.println("A 2 Params Cons call");
	}
	public A() {
		System.out.println("A Cons Call");
	}

	public B getZZ() {
		return zz;
	}
	public void setZZ(B b) {
		this.zz = b;
		System.out.println("B Setter Call BY NAME");
	}
//
//	public void setObject(B object) {
//		this.object = object;
//	}
	

}
