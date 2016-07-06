package com.obc.mq.p2p;

interface Extendbroadable {
	
	public void inPut ( );
}

class KeyBroad implements Extendbroadable {
	
	public void inPut ( ) {
		System.out.println(" hi,keybroad has be input into then mainbroad! ");
	}
}

class NetCardBroad implements Extendbroadable {
	
	public void inPut ( ) {
		System.out.println(" hi,netCardBroad has be input into then mainbroad! ");
	}
}

class CheckBroad {
	
	public void getMainMessage ( Extendbroadable ext ) {
		ext.inPut();
	}
}

