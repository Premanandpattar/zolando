package org.zolando.practies;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random rand=new Random();
		System.out.println(rand.nextInt(10000000));
		System.out.println(rand.nextGaussian());
	}
}
