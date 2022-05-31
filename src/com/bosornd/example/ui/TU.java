package com.bosornd.example.ui;

import java.util.Scanner;

import com.bosornd.example.core.*;
import com.bosornd.example.logic.*;

public class TU {
	TA a;
	
	public TU(TA a) {
		this.a = a;
	}
	
	public void process() {
		Scanner in = new Scanner(System.in);
		a.process(in.nextInt());
		in.close();
	}
	
	public static void main(String[] args) {
		TM tc = new TM(new TC());		// thread TC
		tc.start();
		
		TM tb = new TM(new TB(tc));		// thread TB, connected to TC
		tb.start();
		
		TU u = new TU(new TA(tb));		// main thread(TA), connected to TB
		u.process();
		
		try {
			tc.join();
			tb.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
