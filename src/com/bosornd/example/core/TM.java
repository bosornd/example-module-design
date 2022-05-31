package com.bosornd.example.core;

public class TM extends Thread {
	Boolean requested = false;
	int number;
	TP p;
	
	public TM(TP p) {
		this.p = p;
	}
	
	public void request(int number) {
		this.number = number;
		requested = true;
	}
	
	public void run() {
		while(!requested) {
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
		
		p.process(number);
	}
}
