import java.util.Arrays;
import java.util.Scanner;

public class HW1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("Enter the number of digits of pi: ");
//		int piInput = scanner.nextInt();
//		System.out.println("Value: " + pi(piInput));
		//Input 1: 3 ---> 3.141 
		//Input 2: 6 ---> 3.141592
		
//		System.out.println(easter(1998)); Output: April 12 
//		System.out.println(easter(1998)); Output: April 15

		
//		System.out.println(Arrays.toString(random(5, 5, 5, 5))); Output: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//		System.out.println(Arrays.toString(random(12, 14, 26, 78))); Output: [38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38, 12, 38]
//		System.out.println(escape(1000)); Output: "The astronaut will return to Halley's Comet."
//		System.out.println(escape(5500)); Output: The astronaut will not return to Halley’s Comet. In order for the astronaut to return, the comet would need to have a mass larger than 5.22506413513883E22


	}
	public static double pi(int n){
		
		double total = 0;
		for(int i = 0; i < 1000000000; i++){
			if(i % 2 == 0){
				total += (1.0/((i*2.0)+1.0));
			}
			else{
				total -= (1.0/((i*2.0)+1.0));
			}
		}
		return Double.valueOf(String.valueOf(total*4).substring(0,n + 2));
		
	}
	public static String easter(int y){
		int a = y % 19;
		int b = y/100;
		int c = y % 100;
		int d = b/4;
		int e = b % 4;
		int g = (8 * b + 13)/25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c/4;
		int k = c % 4;
		int m = (a + 11 * h)/319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90)/25;
		int p = (h - m + r + n + 19) % 32;
		
		String monthString = ""; 
		if (n == 1){
			monthString = "January";
		}
		if (n == 2){
			monthString = "February";
		}
		if (n == 3){
			monthString = "March";
		}
		if (n == 4){
			monthString = "April";
		}
		if (n == 5){
			monthString = "May";
		}
		if (n == 6){
			monthString = "June";
		}
		if (n == 7){
			monthString = "July";
		}
		if (n == 8){
			monthString = "August";
		}
		if (n == 9){
			monthString = "September";
		}
		if (n == 10){
			monthString = "October";
		}
		if (n == 11){
			monthString = "November";
		}
		if (n == 12){
			monthString = "December";
		}
		
		String returned = monthString + " " + Integer.toString(p);
		return returned;
	}
	public static int[] random(int r, int a, int b, int m){
		int[] thelist = new int[25];
		for (int i = 0; i < thelist.length; i++){
			int newNum = ((a * r) + b) % m;
			thelist[i] = newNum;
			r = newNum;
		}
		return thelist;
		
	}
	public static String escape(double v){
		double conversion = v * 0.44704;
		double velocity = Math.sqrt(2*(6.67*Math.pow(10,-11))*(1.3*Math.pow(10,22))/(1.153*Math.pow(10,6)));
		String answer = "";
		if (conversion > velocity) {
			double mass = Math.pow(conversion,2)*(1.153*Math.pow(10,6))/(2*6.67*Math.pow(10,-11));
			answer = "The astronaut will not return to Halley’s Comet. In order for the astronaut to return, the comet would need to have a mass larger than " + mass;
		} else {
			answer = "The astronaut will return to Halley's Comet.";
		}
		return answer;
	}
}
