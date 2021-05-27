package may27;

import java.util.Arrays;

public class Morse {

	public static void main(String[] args) {
	
		String str = "Hello. my name is HongGilDong";
		System.out.println(str);
		String[] split = str.split(" ");
		
		for (String string : split) {
			System.out.println(string);			
		}
		
		String str1 = "Hi";
		String str2 = "Hi";
		
		if (str1 == str2) {
			System.out.println("first");
		} else if (str1.equals(str2)) {
			System.out.println("seconds");
		} else {
			System.out.println("not");
		}
		
		
		String[] words = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", 
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

		String morse = ".... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--";
		
		String[] morseArray = morse.split(" ");
		
		for (int i = 0; i < morseArray.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (morseArray[i].equals(words[j]) == true) {
					System.out.print((char)(j + 97));
					break;
				} else if (morseArray[i] == "") {
					System.out.print(" ");
					break;
				}
			}	
		}
		
		System.out.println();
	}
}
