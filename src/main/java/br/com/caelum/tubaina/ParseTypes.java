package br.com.caelum.tubaina;

import java.io.IOException;
import br.com.caelum.tubaina.parser.Parser;
import br.com.caelum.tubaina.parser.RegexConfigurator;
import br.com.caelum.tubaina.parser.html.HtmlParser;
import br.com.caelum.tubaina.parser.latex.LatexParser;

public enum ParseTypes {
	
	HTML{
		@Override
		public Parser getParser(RegexConfigurator conf, boolean noAnswer, boolean showNotes) throws IOException {
			return new HtmlParser(conf.read(
					"/regex.properties", "/html.properties"), noAnswer);
		}
	}, LATEX{
		@Override
		public Parser getParser(RegexConfigurator conf, boolean noAnswer, boolean showNotes) throws IOException {
			return new LatexParser(conf.read("/regex.properties", "/latex.properties"), showNotes, noAnswer);
		}
	}, HTMLFLAT{
		@Override
		public Parser getParser(RegexConfigurator conf, boolean noAnswer,
				boolean showNotes) throws IOException {
			return new HtmlParser(conf.read(
					"/regex.properties", "/html.properties"), noAnswer);
		}
	};
	
	public String getType() {
		return this.toString().toLowerCase();
	}
	
	public abstract Parser getParser(RegexConfigurator conf, boolean noAnswer, boolean showNotes) throws IOException ;
	
}
