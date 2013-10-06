package com.andrewdemaria.test.rmi.remote_test;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
 
public class RMIServer 
    implements RMIServerIntf {
    public static final String MESSAGE = "Hello world";
 
    public RMIServer() throws RemoteException {
    	
    }
 
    public String getMessage() throws RemoteException {
        return MESSAGE;
    }
 
    public static void main(String args[]) throws Exception {

//    	if(System.getSecurityManager()==null){
//            System.setSecurityManager(new RMISecurityManager());
//    	}
        System.out.println("RMI server started");
        
        //Instantiate RmiServer
        RMIServer obj = new RMIServer();
 
        try { //special exception handler for registry creation
        	
            RMIServerIntf stub = (RMIServerIntf) UnicastRemoteObject.exportObject(obj,0);
            Registry reg;
            try {
            	reg = LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created.");

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	reg = LocateRegistry.getRegistry();
            }
        	reg.rebind("RMIServer", stub);

        } catch (RemoteException e) {
        	e.printStackTrace();
        }
    }
}
