package com.bosornd.example.logic;

import com.bosornd.example.core.TM;
import com.bosornd.example.core.TP;

public class TB extends TP {
	TM m;
	
	public TB(TM m) {
		this.m = m;
	}
	
	public void process(int number) {
		System.out.println("TB.process: " + number);
		
		// request to m
		m.request(number + 1);
	}
}
