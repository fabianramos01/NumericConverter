package model;

import java.util.StringTokenizer;

import controller.ConstantList;

public class ManagerCon {

	private String [] convertBases;
	
	public ManagerCon() {
		convertBases = new String[2];
		convertBases[0] = "";
		convertBases[1] = "";
	}
	
	public String convert(String number) {
		if (!convertBases[0].equals("") && !convertBases[1].equals("")) {
			if (convertBases[0].equals(ConstantList.BINARY)) {
				return binaryTo(number);
			} else if (convertBases[0].equals(ConstantList.DECIMAL)) {
				return decimalTo(number);
			} else if (convertBases[0].equals(ConstantList.OCTAL)) {
				return octalTo(number);
			} else if (convertBases[0].equals(ConstantList.HEXADECIMAL)) {
				return hexadecimalTo(number);
			}
		}
		return "";
	}

	private String hexadecimalTo(String number) {
		if (convertBases[1].equals(ConstantList.BINARY)) {
			return hexaToBinary(number);
		} else if (convertBases[1].equals(ConstantList.DECIMAL)) {
			return String.valueOf(hexaToDecimal(number));
		} else if (convertBases[1].equals(ConstantList.OCTAL)) {
			return hexaToOctal(number);
		}
		return number;
	}

	private String octalTo(String number) {
		if (convertBases[1].equals(ConstantList.BINARY)) {
			return octalToBinary(number);
		} else if (convertBases[1].equals(ConstantList.DECIMAL)) {
			return String.valueOf(octalToDecimal(number));
		} else if (convertBases[1].equals(ConstantList.HEXADECIMAL)) {
			return octalToHexa(number);
		}
		return number;
	}

	private String decimalTo(String number) {
		if (convertBases[1].equals(ConstantList.BINARY)) {
			return decimalToBinary(number);
		} else if (convertBases[1].equals(ConstantList.HEXADECIMAL)) {
			return decimalToHexa(Integer.parseInt(number));
		} else if (convertBases[1].equals(ConstantList.OCTAL)) {
			return decimalToOctal(Integer.parseInt(number));
		}
		return number;
	}

	private String binaryTo(String number) {
		if (convertBases[1].equals(ConstantList.HEXADECIMAL)) {
			return binaryToHexa(number);
		} else if (convertBases[1].equals(ConstantList.DECIMAL)) {
			return String.valueOf(binaryToDecimal(number));
		} else if (convertBases[1].equals(ConstantList.OCTAL)) {
			return String.valueOf(binaryToOctal(number));
		}
		return number;
	}

	public String decimalToBinary(String num) {
		double decimal = Double.parseDouble(num);
		if (num.contains(ConstantList.SEPARATOR)) {
			System.out.println(decimal - (int) decimal);
			return decimal((int) decimal) + decimalFraction(decimal - (int) decimal) + "";
		} else {
			return decimal((int) decimal) + "";
		}
	}

	private String decimal(int decimal) {
		return Integer.toBinaryString(decimal);
	}

	private double decimalFraction(double decimal) {
		double result = 0;
		String fraction = "";
		for (int i = 0; i < ConstantList.DIGITS; i++) {
			result = decimal * 2;
			fraction += (int) result;
			decimal = decimal - (int) result;
		}
		return Double.parseDouble(fraction);
	}

	public double binaryToDecimal(String num) {
		if (num.contains(ConstantList.SEPARATOR)) {
			StringTokenizer st = new StringTokenizer(num, ConstantList.SEPARATOR);
			return binary(st.nextToken()) + binaryFraction(st.nextToken());
		} else {
			return binary(num);
		}
	}

	private double binaryFraction(String number) {
		double num = 0;
		for (int i = 0; i < number.length(); i++) {
			num += Math.pow(2, i * -1) * Integer.parseInt(number.charAt(i) + "");
		}
		return num;
	}

	private double binary(String number) {
		double num = 0;
		int n = 0;
		for (int i = number.length() - 1; 0 <= i; i--) {
			num += Math.pow(2, i) * Integer.parseInt(number.charAt(n) + "");
			n++;
		}
		return num;
	}

	public double binaryToOctal(String binary) {
		if (binary.length() % 3 == 0) {
			return octal(binary);
		} else {
			while (binary.length() % 3 != 0) {
				binary = "0" + binary;
			}
			return octal(binary);
		}
	}

	private int octal(String binary) {
		int total = 0;
		int i = 0;
		while (i < binary.length()) {
			total += partOctal(binary.substring(i, i+=3));
		}
		return total;
	}

	private int partOctal(String binary) {
		int num = 0;
		int n = 0;
		for (int i = binary.length() - 1; 0 <= i; i--) {
			num += Math.pow(8, i) * Integer.parseInt(binary.charAt(n) + "");
			n++;
		}
		return num;
	}
	
	public String binaryToHexa(String binary) {
		int num = Integer.valueOf(binary, 2);
		return Integer.toHexString(num);
	}
	
	public String decimalToHexa(int num) {
		return Integer.toHexString(num);
	}
	
	public String decimalToOctal(int num) {
		return Integer.toOctalString(num);
	}
	
	public int octalToDecimal(String octal) {
		Integer num = Integer.valueOf(octal, 8);
		return num.intValue();
	}
	
	public String octalToBinary(String octal) {
		Integer num = Integer.valueOf(octal, 8);
		return Integer.toBinaryString(num.intValue());
	}
	
	public String octalToHexa(String octal) {
		Integer num = Integer.valueOf(octal, 8);
		return Integer.toHexString(num.intValue());
	}
	
	public int hexaToDecimal(String hexa) {
		Integer num = Integer.valueOf(hexa, 16);
		return num.intValue();
	}
	
	public String hexaToBinary(String hexa) {
		Integer num = Integer.valueOf(hexa, 16);
		return Integer.toBinaryString(num.intValue());
	}

	public String hexaToOctal(String hexa) {
		Integer num = Integer.valueOf(hexa, 16);
		return Integer.toOctalString(num.intValue());
	}
	
	public void setFirstBase(String firstBase) {
		convertBases[0] = firstBase;
	}
	
	public void setSecondBase(String secondBase) {
		convertBases[1] = secondBase;
	}
	
	public void resetBases() {
		convertBases[0] = "";
		convertBases[1] = "";
	}
}