package com.study.springcore.proxy.sta;

public class ProxyText {
	public static void main(String[] args) {
		
		Person man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());
		
		man.work();
		woman.work();
	}
}
