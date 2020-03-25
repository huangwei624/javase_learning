import java.util.ArrayList;
import java.util.List;

/**
 * 给定任意一个词的序列，如: n-gram models are widely used in natural language processing.
 * 1-gram输出为：{n-gram, models, are, widely, used, in, natural, language, processing}
 * 2-gram输出为：{(n-gram, models), (models, are), (are, widely), (widely, used), (used, in) ... }
 * 3-gram输出为：{(n-gram, models, are), (models, are, widely), (are, widely, used) ... }
 */
public class NgramDemo {
	
	static void ngram(List<String> seq, int N) {
		for (int i = 1; i <= N; i++) {
			int width = i;
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			for (int j = 0; j < seq.size(); j++) {
				int tempj = j;
				if (width > 1 && j + width <= seq.size()) {
					sb.append("(");
				}
				for (int k = j; k < j + width && j + width <= seq.size(); k++) {
					sb.append(seq.get(k));
					if (k < j + width - 1) {
						sb.append(", ");
					}
				}
				j = tempj;
				if (width > 1 && j + width <= seq.size()) {
					sb.append("),");
				}
				if (width == 1) {
					sb.append(", ");
				}
			}
			sb.append("}");
			System.out.println(sb.substring(0, sb.toString().length() - 2) + "}");
		}
	}

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		//n-gram models are widely used in natural language processing
		strings.add("n-gram");
		strings.add("models");
		strings.add("are");
		strings.add("widely");
		strings.add("used");
		strings.add("in");
		strings.add("natural");
		strings.add("language");
		strings.add("processing");
		NgramDemo.ngram(strings, 7);
	}
}
