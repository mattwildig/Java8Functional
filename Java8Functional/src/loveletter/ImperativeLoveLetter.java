package loveletter;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.String;

public class ImperativeLoveLetter {
	static Integer LONG=1;
	static Integer SHORT=2;
	Random generator = new Random();
	
	public String getLetter(){
		List<String> sals1 = new ArrayList<>(Arrays.asList("Beloved", "Darling", "Dear", "Dearest", "Fanciful", "Honey"));
		List<String> sals2 = new ArrayList<>(Arrays.asList("Chickpea", "Dear", "Duck", "Jewel", "Love", "Moppet", "Sweetheart"));
		List<String> adjs = new ArrayList<>(Arrays.asList("affectionate", "amorous", "anxious", "avid", "beautiful", "breathless", "burning", "covetous", "craving", "curious", "eager", "fervent", "fondest", "loveable", "lovesick", "loving", "passionate", "precious", "seductive", "sweet", "sympathetic", "tender", "unsatisfied", "winning", "wistful"));
		List<String> nouns = new ArrayList<>(Arrays.asList("adoration", "affection", "ambition", "appetite", "ardour", "being", "burning", "charm", "craving", "desire", "devotion", "eagerness", "enchantment", "enthusiasm", "fancy", "fellow feeling", "fervour", "fondness", "heart", "hunger", "infatuation", "little liking", "longing", "love", "lust", "passion", "rapture", "sympathy", "thirst", "wish", "yearning"));
		List<String> advs = new ArrayList<>(Arrays.asList("affectionately", "ardently", "anxiously", "beautifully", "burningly", "covetously", "curiously", "eagerly", "fervently", "fondly", "impatiently", "keenly", "lovingly", "passionately", "seductively", "tenderly", "wistfully"));
		List<String> verbs = new ArrayList<>(Arrays.asList("adores", "attracts", "clings to", "holds dear", "hopes for", "hungers for", "likes", "longs for", "loves", "lusts after", "pants for", "pines for", "sighs for", "tempts", "thirsts for", "treasures", "yearns for", "woos"));
	
		Random generator = new Random();
		StringBuilder letter = new StringBuilder();
		letter.append(String.format("%s %s,\n     ", getRandomWord(sals1), getRandomWord(sals2)));
	
		Integer last = null;
		
		for(int i=0; i<5; i++){
			if (generator.nextBoolean()) {
				//LONG
				if (last != null || last == LONG) {
					letter.append(". ");
				}
				String optadj1 = generator.nextBoolean() ? "" : getRandomWord(adjs);
				String noun1 = getRandomWord(nouns);
				String optadv = generator.nextBoolean() ? "" : getRandomWord(advs);
				String verb = getRandomWord(verbs);
				String optadj2 = generator.nextBoolean() ? "" : getRandomWord(adjs);
				String noun2 = getRandomWord(nouns);
				
				letter.append(String.format("My %s %s %s %s your %s %s", optadj1, noun1, optadv, verb, optadj2, noun2));
				last = LONG;
			} else {
				//SHORT
				String adj = getRandomWord(adjs);
				String noun = getRandomWord(nouns);
				String concat = "";
				if (last == SHORT) {
					concat = ", ";
				} else if (last == LONG) {
					concat = ". You are";
				} else {
					concat = "You are";
				}
				letter.append(String.format("%s my %s %s", concat, adj, noun));
				last = SHORT;
			}
		}
		String adv = getRandomWord(advs);
		letter.append(String.format(".\n     Yours %s,\n     M.U.C.\n", adv));
		return(letter.toString());
	}
	private String getRandomWord(List<String> words){
		return words.get(generator.nextInt(words.size()));
	}
}
