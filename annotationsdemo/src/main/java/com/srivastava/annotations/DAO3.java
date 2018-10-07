package com.srivastava.annotations;

import org.springframework.stereotype.Repository;

@Repository
public class DAO3 {
	public DAO3(){
		System.out.println("DAO3 Cons Call");
	}
	public void dao3() {
		System.out.println("Dao 3");
	}
}
