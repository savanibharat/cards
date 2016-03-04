package com.learninghorizon.authnauth;

/**
 * BasicCredential consists of user name and password.  
 **/
public interface BasicCredential {

	public abstract String userName();
	public abstract String encryptedPassword();
	
}
