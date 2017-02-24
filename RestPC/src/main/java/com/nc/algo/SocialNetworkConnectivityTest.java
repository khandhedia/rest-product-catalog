package com.nc.algo;

public class SocialNetworkConnectivityTest {

	public static void main(String[] args) {
		WightedUnionFindSocialConnectivity w = new WightedUnionFindSocialConnectivity(6);

		int foo = 0;
		int bar = 5;
		w.union(foo, bar);
		System.out.printf("%d => %d\n", foo, bar);
		System.out.printf("all connected? => %s\n", w.allConnected());

		foo = 1;
		bar = 5;
		w.union(foo, bar);
		System.out.printf("%d => %d\n", foo, bar);
		System.out.printf("all connected? => %s\n", w.allConnected());

		foo = 2;
		bar = 0;
		w.union(foo, bar);
		System.out.printf("%d => %d\n", foo, bar);
		System.out.printf("all connected? => %s\n", w.allConnected());

		foo = 3;
		bar = 4;
		w.union(foo, bar);
		System.out.printf("%d => %d\n", foo, bar);
		System.out.printf("all connected? => %s\n", w.allConnected());

		foo = 3;
		bar = 0;
		w.union(foo, bar);
		System.out.printf("%d => %d\n", foo, bar);
		System.out.printf("all connected? => %s\n", w.allConnected());
	}
}