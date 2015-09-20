package loveletter;

public class LetterWriter {
	public static void main(String args[]){
		ImperativeLoveLetter letterWriter1 = new ImperativeLoveLetter();
		System.out.println(letterWriter1.getLetter());
		FunctionalLoveLetter letterWriter2 = new FunctionalLoveLetter();
		System.out.println(letterWriter2.getLetter());
	}
}
