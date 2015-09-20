package loveletter;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.String;


/**
 * @author Debbie
 * Algorithm for producing a 'love letter' based on Ferranti loveletters algorithm (Christopher Strachey 1952)
 * this version is adapted into Java from a php version of the algorithm from here: https://github.com/gingerbeardman/loveletter
 * 
 * It produces 'letters' by selecting random words from predefined lists of nouns, verbs, adverbs, etc such that the sentences it forms are grammatically correct
 * The letters have  two word greeting, followed by a comma and newline
 * The algorithm then loops 5 times to produce a letter body
 * Finally a signature is added, line break ", Yours <word>," line break M.U.C. 
 * e.g.
 * Dearest Moppet,
 *    You are my loveable charm, my eager sympathy, my avid appetite. My winning ardour affectionately thirsts for your unsatisfied heart. You are my precious thirst.
 *    Yours affectionately,
 *    M.U.C.
 */
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
				//LONG - 
				//Adds a sentence in the form "My <adjective> noun <adverb> verb <adjective> noun"
				//prepending a ". " if necessary
				if (last != null) {
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
				//SHORT -
				//Adds a sentence segment. Multiple 'SHORT' sentence segments may be chained together
				//The first takes the form "You are my adjective noun"
				//Subsequent segments are chained together ", my adjective noun"
				//Full stop will be added to the front of the first segment if it follows a 'LONG' sentence
				//e.g. "You are my curious enchantment" + ", my avid hunger"
				if (last == SHORT) {
					letter.append( ", " );
				} else if (last == LONG) {
					letter.append( ". You are ");
				} else {
					letter.append( "You are " );
				}
				String adj = getRandomWord(adjs);
				String noun = getRandomWord(nouns);
				
				letter.append(String.format("my %s %s", adj, noun));
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
