/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_cliente_servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Negriz07
 */
public interface Resta extends Remote{
    
 public String Resta (String a, String b) throws RemoteException;
}

