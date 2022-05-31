package com.bosornd.example.logic;

import com.bosornd.example.core.TM;
import com.bosornd.example.core.TP;

public class TA extends TP {
	TM m;
	
	public TA(TM m) {
		this.m = m;
	}
	
	public void process(int number) {
		System.out.println("TA.process: " + number);
		
		// request to m
		m.request(number + 1);
	}
}
