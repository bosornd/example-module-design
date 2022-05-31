package com.bosornd.example.core;

public class TM extends Thread {
	Boolean done = false;
	TP p;
	
	public TM(TP p) {
		this.p = p;
	}
	
	public void request(int number) {
		p.process(number);
		done = true;
	}
	
	public void run() {
		while(!done) {
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
	}
}
