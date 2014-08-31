package net.puppetbeans.files.lexer;

import net.puppetbeans.files.jcclexer.JavaCharStream;
import net.puppetbeans.files.jcclexer.PuppetManifestParserTokenManager;
import net.puppetbeans.files.jcclexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

class PuppetLexer implements Lexer<PuppetTokenId> {

    private final LexerRestartInfo<PuppetTokenId> info;
    private final PuppetManifestParserTokenManager puppetParserTokenManager;

    PuppetLexer(LexerRestartInfo<PuppetTokenId> info) {
        this.info = info;
        JavaCharStream stream = new PuppetLexerInputStream(info.input());
        puppetParserTokenManager = new PuppetManifestParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<PuppetTokenId> nextToken() {
        Token token = puppetParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(PuppetLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}