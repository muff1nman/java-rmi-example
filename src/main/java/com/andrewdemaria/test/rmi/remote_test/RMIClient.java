package com.andrewdemaria.test.rmi.remote_test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient { 
    public static void main(String args[]) throws Exception {
//        RMIServerIntf obj = (RMIServerIntf)Naming.lookup("//localhost/RmiServer");
        Registry registry = LocateRegistry.getRegistry("localhost");
        RMIServerIntf obj = (RMIServerIntf) registry.lookup("RMIServer");
        System.out.println(obj.getMessage()); 
    }
}