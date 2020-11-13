package data;


import data.parser.ParagraphParser;
import data.parser.SentenceParser;
import data.parser.TextParser;

public class ChainBuilder {

   public TextParser build() {

       TextParser textParser = new TextParser();
       ParagraphParser paragraphParser = new ParagraphParser();
       SentenceParser sentenceParser = new SentenceParser();
       textParser.setSuccessor(paragraphParser);
       paragraphParser.setSuccessor(sentenceParser);
       sentenceParser.setSuccessor(null);
       return textParser;
   }

}
