package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MaximumProductLength {
	public int maxProduct(String[] words) {
        int n = words.length;
        if (n == 0 || n == 1) return 0;
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            char[] w = words[i].toCharArray();
            for (int j = 0; j < w.length; j++) {
                v[i] |= 1 << ((int)(w[j] - 'a'));
            }
        }
        int ret = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((v[i] & v[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }

	public static void main(String[] arg) {
		System.out.println(new MaximumProductLength().maxProduct(new String[] {"ffdcafaddcddf","beb"}));
		//"ccd", "accaceddeeeaefc", "bcaffa"
//				"bbcfafbb", "accacfebbabbeedfbfdb", "beddecbffcdaededdaefdedfdea", "cf", "ddafdcbd",
//				"bbafacebacaefdaffccebddff", "ebccffcddbeddccacceccaec", "becfbfdccdfdeadfbfaddbcded",
//				"cbabeaaeabefedbaeaedc", "dfadbbdbead", "cafaefdcd", "eccdbfceafeeeacfcddc", "dbabbcdbb",
//				"abfbfbffcbebde", "cfaadaa", "fc", "faebcabb", "adbacebabcaaccbdeaffff", "aeaefccf",
//				"dbacbeeabdbcdfccabebaecfef", "ecdadeefcaddffaececffa", "defcabf", "abbcecbccbdaebaecaefabed",
//				"dfeeebcbaaefc", "aecccbcbbdddb", "dcfabacec", "fccfbacbacddeaaea", "dfdbfacbacbecb", "cbfeebdbfecb",
//				"cffaacacbde", "aafd", "bdcebbbebd", "afeffadcfcdacfba", "dafeefbcdfaffcfacee", "dcbbebfbedafedcdbab",
//				"cafaf", "bcbcccfdebdd", "efaaaacccff", "cffbead", "ebcfccfcddffdec", "fffdfdcec", "beeafefbdfa",
//				"cdfdbccfbaaeffcabab", "ddadcbabbcb", "decfaeabbecebaebeaddedae", "cdcbfffbebae", "aeccefcbcbbddfdc",
//				"ffefedaf", "cddbabccafaffeafeedcbedbdad", "eddeeccfedcefadfdfebfacb", "aca", "ffdcafaddcddf", "ef",
//				"bbbbffe", "ffccfebabaadcffacbbb", "cbdeddfddffacbeeeebafebabda", "ddeecb", "cffdc", "edcffcebadf",
//				"becbcadcafddcfbbeeddbfffcab", "abcbaceeaeaddd", "cfeffceebfaeefadaaccfa", "eaccddb", "caeafbfafecd",
//				"becaafdbaadbfecfdfde", "ecabaaeafbfbcbadaac", "bdcdffcfaeebeedfdfddfaf", "dbbfbaeecbfcdebad",
//				"cceecddeeecdbde", "beec", "adbcfdbfdbccdcffffbcffbec", "bbbbfe", "cdaedaeaad", "dadbfeafadd",
//				"fcacaaebcedfbfbcddfc", "ceecfedceac", "dada", "ccfdaeffbcfcc", "eadddbbbdfa", "beb",
//				"fcaaedadabbbeacabefdabe", "dfcddeeffbeec", "defbdbeffebfceaedffbfee", "cffadadfbaebfdbadebc",
//				"fbbadfccbeffbdeabecc", "bdabbffeefeccb", "bdeeddc", "afcbacdeefbcecff", "cfeaebbbadacbced",
//				"edfddfedbcfecfedb", "faed", "cbcdccfcbdebabc", "efb", "dbddadfcddbd", "fbaefdfebeeacbdfbdcdddcbefc",
//				"cbbfaccdbffde", "adbcabaffebdffad" }));
	//}
	}}

class LengthComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return new Integer(a.length()).compareTo(new Integer(b.length()));
	}
}
