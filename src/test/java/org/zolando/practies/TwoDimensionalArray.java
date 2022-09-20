package org.zolando.practies;

import java.util.Iterator;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		String[][] arr = new String[2][3];

		arr[0][0] = "a1";
		arr[0][1] = "a2";
		arr[1][0] = "b1";
		arr[1][1] = "b2";
		arr[1][2] = "b3";
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
//		System.out.println(arr.toString());
//		<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

	}
}
