package com.srivastava.apps;

public class Producer implements IProducer{
	private String message;
	private IDB db;
	public Producer(DB db) {
		this.db = db;
		System.out.println("DB Single Param Cons Call");
		this.db.display();
	}
	
	
	public IDB getDb() {
		return db;
	}


	public void setDb(IDB db) {
		this.db = db;
	}


	public Producer() {
		System.out.println("Producer Cons Call");
	}
	public Producer(int x) {
		System.out.println("Param Cons Call "+x);
	}
	public Producer(int x,int y) {
		System.out.println("2 Param Cons call "+x+" "+y);
	}
	@Override
	public int add(int x, int y) {
		return x + y;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
