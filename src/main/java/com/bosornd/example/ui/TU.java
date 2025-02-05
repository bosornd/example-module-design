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
        TC c = new TC();
        TM m2 = new TM(c);        // thread TC
        m2.start();
        
        TB b = new TB(m2);
        TM m1 = new TM(b);        // thread TB, connected to TC
        m1.start();
        
        TA a = new TA(m1);
        TU u = new TU(a);        // main thread(TA), connected to TB
        
        u.process();
        
        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}