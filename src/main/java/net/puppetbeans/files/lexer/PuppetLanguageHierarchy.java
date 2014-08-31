package net.puppetbeans.files.lexer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.puppetbeans.files.jcclexer.PuppetManifestParserConstants;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class PuppetLanguageHierarchy extends LanguageHierarchy<PuppetTokenId> {

    private static List<PuppetTokenId> tokens;
    private static Map<Integer, PuppetTokenId> idToToken;

    private static void init() {
        tokens = Arrays.asList(new PuppetTokenId[]{
                    new PuppetTokenId("EOF", "whitespace", PuppetManifestParserConstants.EOF),
                    new PuppetTokenId("WHITESPACE", "whitespace", PuppetManifestParserConstants.WHITESPACE),
                    new PuppetTokenId("SINGLE_LINE_COMMENT", "comment", PuppetManifestParserConstants.SINGLE_LINE_COMMENT),
                    new PuppetTokenId("KEYWORD", "keywords", PuppetManifestParserConstants.KEYWORD),
                    new PuppetTokenId("ATTRIBUTE", "keywords", PuppetManifestParserConstants.ATTRIBUTE),
                    new PuppetTokenId("IDENTIFIER", "keywords", PuppetManifestParserConstants.IDENTIFIER),
                    new PuppetTokenId("NUMBER", "identifier", PuppetManifestParserConstants.NUMBER),
                    new PuppetTokenId("BOOL", "identifier", PuppetManifestParserConstants.BOOL),
                    new PuppetTokenId("STRING", "identifier", PuppetManifestParserConstants.STRING),
                    new PuppetTokenId("VARIABLE", "identifier", PuppetManifestParserConstants.VARIABLE),
                    new PuppetTokenId("PLACEHOLDER", "identifier", PuppetManifestParserConstants.PLACEHOLDER),
                    new PuppetTokenId("LPAREN", "brace", PuppetManifestParserConstants.LPAREN),
                    new PuppetTokenId("RPAREN", "brace", PuppetManifestParserConstants.RPAREN),
                    new PuppetTokenId("LBRACE", "brace", PuppetManifestParserConstants.LBRACE),
                    new PuppetTokenId("RBRACE", "brace", PuppetManifestParserConstants.RBRACE),
                    new PuppetTokenId("LBRACKET", "brace", PuppetManifestParserConstants.LBRACKET),
                    new PuppetTokenId("RBRACKET", "brace", PuppetManifestParserConstants.RBRACKET),
                    new PuppetTokenId("OPERATOR", "operator", PuppetManifestParserConstants.OPERATOR)
                });
        idToToken = new HashMap<>();
        for (PuppetTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized PuppetTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        PuppetTokenId result = idToToken.get(id);
//        if (result == null) {
//            result = idToToken.get(2); // COMMENT
//            System.out.println("\n\n\ntoken for id=" +id +" not found\n\n\n");
//        }
        return result;
    }

    @Override
    protected synchronized Collection<PuppetTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<PuppetTokenId> createLexer(LexerRestartInfo<PuppetTokenId> info) {
        return new PuppetLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-puppet-manifest";
    }
}