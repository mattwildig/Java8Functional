package loveletter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalLoveLetter {
	static Integer LONG=1;
	static Integer SHORT=2;
	Integer last = null;

	
	List<String> sals1 = new ArrayList<>(Arrays.asList("Beloved", "Darling", "Dear", "Dearest", "Fanciful", "Honey"));
	List<String> sals2 = new ArrayList<>(Arrays.asList("Chickpea", "Dear", "Duck", "Jewel", "Love", "Moppet", "Sweetheart"));
	List<String> adjs = new ArrayList<>(Arrays.asList("affectionate", "amorous", "anxious", "avid", "beautiful", "breathless", "burning", "covetous", "craving", "curious", "eager", "fervent", "fondest", "loveable", "lovesick", "loving", "passionate", "precious", "seductive", "sweet", "sympathetic", "tender", "unsatisfied", "winning", "wistful"));
	List<String> nouns = new ArrayList<>(Arrays.asList("adoration", "affection", "ambition", "appetite", "ardour", "being", "burning", "charm", "craving", "desire", "devotion", "eagerness", "enchantment", "enthusiasm", "fancy", "fellow feeling", "fervour", "fondness", "heart", "hunger", "infatuation", "little liking", "longing", "love", "lust", "passion", "rapture", "sympathy", "thirst", "wish", "yearning"));
	List<String> advs = new ArrayList<>(Arrays.asList("affectionately", "ardently", "anxiously", "beautifully", "burningly", "covetously", "curiously", "eagerly", "fervently", "fondly", "impatiently", "keenly", "lovingly", "passionately", "seductively", "tenderly", "wistfully"));
	List<String> verbs = new ArrayList<>(Arrays.asList("adores", "attracts", "clings to", "holds dear", "hopes for", "hungers for", "likes", "longs for", "loves", "lusts after", "pants for", "pines for", "sighs for", "tempts", "thirsts for", "treasures", "yearns for", "woos"));

	Random generator = new Random();
	
	public String getLetter(){
		
		StringBuilder letter = new StringBuilder();
		letter.append(makeGreeting());
			
		letter.append(makeBody());
		
		letter.append(makeSignature());
		return(letter.toString());
	}
	
	private String makeGreeting(){
		return String.format("%s %s,\n     ", getRandomWord(sals1), getRandomWord(sals2));
	}
	private String makeBody(){
		last = null;
		String body = Stream.generate(() -> makeSentenceSegment()).limit(5).collect(Collectors.joining());
		return body;
	}

	private String makeSentenceSegment(){
		String sentence;
		if (generator.nextBoolean()) {
			//LONG
			String prefix;
			if (last != null) {
				prefix = ". My ";
			} else {
				prefix = "My ";
			}
			sentence = Stream.of( 
					getNounClause(generator.nextBoolean()), 
					getVerbClause(generator.nextBoolean()), 
					getNounClause(generator.nextBoolean()))
				.collect(Collectors.joining(" ", prefix, ""));
			last = LONG;
		} else {
			//SHORT
			String prefix = "";
			if (last == SHORT) {
				prefix = ", my ";
			} else if (last == LONG) {
				prefix = ". You are my ";
			} else {
				prefix = "You are my ";
			}
			sentence = Stream.of(getNounClause(true)).collect(Collectors.joining(" ", prefix, ""));
			last = SHORT;
		}

		return sentence;
	}

	private String getNounClause(boolean addAdjective){
		if ( addAdjective){
			return getRandomWord(adjs) + " " + getRandomWord(nouns);
		} else {
			return getRandomWord(nouns);
		}
	}

	private String getVerbClause(boolean addAdverb) {
		if ( addAdverb){
			return getRandomWord(advs) + " " + getRandomWord(verbs);
		} else {
			return getRandomWord(verbs);
		}
	}

	private String makeSignature(){
		return (String.format(".\n     Yours %s,\n     M.U.C.\n", getRandomWord(advs)));
	}
	private String getRandomWord(List<String> words){
		return words.get(generator.nextInt(words.size()));
	}
}
