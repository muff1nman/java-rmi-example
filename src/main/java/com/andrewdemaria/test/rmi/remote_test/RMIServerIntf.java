package com.andrewdemaria.test.rmi.remote_test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerIntf extends Remote {
	public String getMessage() throws RemoteException;
}
