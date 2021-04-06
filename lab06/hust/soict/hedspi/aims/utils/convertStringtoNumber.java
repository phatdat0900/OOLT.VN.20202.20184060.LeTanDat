package hust.soict.hedspi.aims.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class convertStringtoNumber {
	private static final List<String> Num = Arrays.asList("one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine", "ten", "thousand", "hundred", "and");

	private static final List<String> twoDigitNum = Arrays.asList("eleven", "twelve", "thirdteen", "fourteen",
			"fiveteen", "sixteen", "seventeen", "eighteen", "niceteen", "twenty", "thirty", " forty", " fifty",
			" sixty", " seventy", " eighty", " ninety");

	public int convertYear(String input) {
		int year = 0;
		int count = 0;

		if (input != null && input.length() > 0) {
			input = input.toLowerCase();
			String[] Split = input.trim().split("\\s+");
			for (int i = 0; i < Split.length; i++) {
				String str = Split[i];
				if (!Num.contains(str) && !twoDigitNum.contains(str)) {
					System.out.println("Invalid word found : " + str);
					throw new AssertionError("Invalid word found : " + str);
				}
			}
			if (Num.contains(Split[0])) {
				for (int i = 0; i < Split.length; i++) {
					String str = Split[i];
					if (str.equalsIgnoreCase("one")) {
						count += 1;
					} else if (str.equalsIgnoreCase("two")) {
						count += 2;
					} else if (str.equalsIgnoreCase("three")) {
						count += 3;
					} else if (str.equalsIgnoreCase("four")) {
						count += 4;
					} else if (str.equalsIgnoreCase("five")) {
						count += 5;
					} else if (str.equalsIgnoreCase("six")) {
						count += 6;
					} else if (str.equalsIgnoreCase("seven")) {
						count += 7;
					} else if (str.equalsIgnoreCase("eight")) {
						count += 8;
					} else if (str.equalsIgnoreCase("nine")) {
						count += 9;
					} else if (str.equalsIgnoreCase("ten")) {
						count += 10;
					} else if (str.equalsIgnoreCase("eleven")) {
						count += 11;
					} else if (str.equalsIgnoreCase("twelve")) {
						count += 12;
					} else if (str.equalsIgnoreCase("thirteen")) {
						count += 13;
					} else if (str.equalsIgnoreCase("fourteen")) {
						count += 14;
					} else if (str.equalsIgnoreCase("fifteen")) {
						count += 15;
					} else if (str.equalsIgnoreCase("sixteen")) {
						count += 16;
					} else if (str.equalsIgnoreCase("seventeen")) {
						count += 17;
					} else if (str.equalsIgnoreCase("eighteen")) {
						count += 18;
					} else if (str.equalsIgnoreCase("nineteen")) {
						count += 19;
					} else if (str.equalsIgnoreCase("twenty")) {
						count += 20;
					} else if (str.equalsIgnoreCase("thirty")) {
						count += 30;
					} else if (str.equalsIgnoreCase("forty")) {
						count += 40;
					} else if (str.equalsIgnoreCase("fifty")) {
						count += 50;
					} else if (str.equalsIgnoreCase("sixty")) {
						count += 60;
					} else if (str.equalsIgnoreCase("seventy")) {
						count += 70;
					} else if (str.equalsIgnoreCase("eighty")) {
						count += 80;
					} else if (str.equalsIgnoreCase("ninety")) {
						count += 90;
					} else if (str.equalsIgnoreCase("hundred")) {
						count *= 100;
					} else if (str.equalsIgnoreCase("thousand")) {
						count *= 1000;
						year += count;
						count = 0;
					}

				}
				year += count;

			} else if (twoDigitNum.contains(Split[0])) {
				if (Split[0].equalsIgnoreCase("eleven")) {
					count += 1100;
				} else if (Split[0].equalsIgnoreCase("twelve")) {
					count += 1200;
				} else if (Split[0].equalsIgnoreCase("thirteen")) {
					count += 1300;
				} else if (Split[0].equalsIgnoreCase("fourteen")) {
					count += 1400;
				} else if (Split[0].equalsIgnoreCase("fifteen")) {
					count += 1500;
				} else if (Split[0].equalsIgnoreCase("sixteen")) {
					count += 1600;
				} else if (Split[0].equalsIgnoreCase("seventeen")) {
					count += 1700;
				} else if (Split[0].equalsIgnoreCase("eighteen")) {
					count += 1800;
				} else if (Split[0].equalsIgnoreCase("nineteen")) {
					count += 1900;
				} else if (Split[0].equalsIgnoreCase("twenty")) {
					count += 2000;
				} else if (Split[0].equalsIgnoreCase("thirty")) {
					count += 3000;
				} else if (Split[0].equalsIgnoreCase("forty")) {
					count += 4000;
				} else if (Split[0].equalsIgnoreCase("fifty")) {
					count += 5000;
				} else if (Split[0].equalsIgnoreCase("sixty")) {
					count += 6000;
				} else if (Split[0].equalsIgnoreCase("seventy")) {
					count += 7000;
				} else if (Split[0].equalsIgnoreCase("eighty")) {
					count += 8000;
				} else if (Split[0].equalsIgnoreCase("ninety")) {
					count += 9000;
				}
				for (int i = 1; i < Split.length; i++) {
					String str = Split[i];
					if (str.equalsIgnoreCase("one")) {
						if (i == 1) {
							count += 100;
						} else {
							count += 1;
						}
					} else if (str.equalsIgnoreCase("two")) {
						if (i == 1) {
							count += 200;
						} else {
							count += 2;
						}

					} else if (str.equalsIgnoreCase("three")) {
						if (i == 1) {
							count += 300;
						} else {
							count += 3;
						}
					} else if (str.equalsIgnoreCase("four")) {
						if (i == 1) {
							count += 400;
						} else {
							count += 4;
						}
					} else if (str.equalsIgnoreCase("five")) {
						if (i == 1) {
							count += 500;
						} else {
							count += 5;
						}
					} else if (str.equalsIgnoreCase("six")) {
						if (i == 1) {
							count += 600;
						} else {
							count += 6;
						}
					} else if (str.equalsIgnoreCase("seven")) {
						if (i == 1) {
							count += 700;
						} else {
							count += 7;
						}
					} else if (str.equalsIgnoreCase("eight")) {
						if (i == 1) {
							count += 800;
						} else {
							count += 8;
						}
					} else if (str.equalsIgnoreCase("nine")) {
						if (i == 1) {
							count += 900;
						} else {
							count += 9;
						}
					} else if (str.equalsIgnoreCase("ten")) {
						count += 10;
					} else if (str.equalsIgnoreCase("eleven")) {
						count += 11;
					} else if (str.equalsIgnoreCase("twelve")) {
						count += 12;
					} else if (str.equalsIgnoreCase("thirteen")) {
						count += 13;
					} else if (str.equalsIgnoreCase("fourteen")) {
						count += 14;
					} else if (str.equalsIgnoreCase("fifteen")) {
						count += 15;
					} else if (str.equalsIgnoreCase("sixteen")) {
						count += 16;
					} else if (str.equalsIgnoreCase("seventeen")) {
						count += 17;
					} else if (str.equalsIgnoreCase("eighteen")) {
						count += 18;
					} else if (str.equalsIgnoreCase("nineteen")) {
						count += 19;
					} else if (str.equalsIgnoreCase("twenty")) {
						count += 20;
					} else if (str.equalsIgnoreCase("thirty")) {
						count += 30;
					} else if (str.equalsIgnoreCase("forty")) {
						count += 40;
					} else if (str.equalsIgnoreCase("fifty")) {
						count += 50;
					} else if (str.equalsIgnoreCase("sixty")) {
						count += 60;
					} else if (str.equalsIgnoreCase("seventy")) {
						count += 70;
					} else if (str.equalsIgnoreCase("eighty")) {
						count += 80;
					} else if (str.equalsIgnoreCase("ninety")) {
						count += 90;
					}

				}
				year += count;

			}

		}
		return year;

	}

	public int convertMonth(String input) {
		int m = 1;

		String month[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October ", "November", "December" };

		for (int i = 0; i < 12; i++) {
			if (month[i].equals(input)) {

				m = i + 1;
			}
		}

		return m;
	}

	public int convertDay(String input) {
		int day;
		switch (input) {
		case "First":
			day = 1;
			break;
		case "Second":
			day = 2;
			break;
		case "Third":
			day = 3;
			break;
		case "Fourth":
			day = 4;
			break;
		case "Fiveth":
			day = 5;
			break;
		case "Sixth":
			day = 6;
			break;
		case "Seventh":
			day = 7;
			break;
		case "Eighth":
			day = 8;
			break;
		case "Niceth":
			day = 9;
			break;
		case "Tenth":
			day = 10;
			break;
		case "Eleventh":
			day = 11;
			break;
		case "Twelfth":
			day = 12;
			break;
		case "Thirteenth":
			day = 13;
			break;
		case "Fourteenth":
			day = 14;
			break;
		case "Fifteenth":
			day = 15;
			break;
		case "Sixteenth":
			day = 16;
			break;
		case "Seventeenth":
			day = 17;
			break;
		case "Eighteenth":
			day = 18;
			break;
		case "Nineteenth":
			day = 19;
			break;
		case "Twentieth":
			day = 20;
			break;
		case "Twenty-first":
			day = 21;
			break;
		case "Twenty-second":
			day = 22;
			break;
		case "Twenty-third":
			day = 23;
			break;
		case "Twenty-fourth":
			day = 24;
			break;
		case "Twenty-fifth":
			day = 25;
			break;
		case "Twenty-sixth":
			day = 26;
			break;
		case "Twenty-seventh":
			day = 27;
			break;
		case "Twenty-eighth":
			day = 28;
			break;
		case "Twenty-ninth":
			day = 29;
			break;
		case "Thirtieth":
			day = 30;
			break;
		case "Thirty-first":
			day = 31;
			break;
		default:
			throw new AssertionError("Invalid word found : " + input);
		}
		return day;

	}

}
