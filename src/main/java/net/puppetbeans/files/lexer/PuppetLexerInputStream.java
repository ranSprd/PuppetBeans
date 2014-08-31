package net.puppetbeans.files.lexer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import net.puppetbeans.files.jcclexer.JavaCharStream;
import org.netbeans.spi.lexer.LexerInput;

/**
 *
 * @author ran
 */
public class PuppetLexerInputStream extends JavaCharStream {

    private LexerInput input;

    static boolean staticFlag;

    public PuppetLexerInputStream(LexerInput input) {
        super(new ByteArrayInputStream("not supported".getBytes()));
        this.input = input;
    }

//    PuppetLexerInputStream(Reader stream, int i, int i0) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    PuppetLexerInputStream(InputStream stream, String encoding, int i, int i0) throws UnsupportedEncodingException {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
    @Override
    public char BeginToken() throws IOException {
        return readChar();
    }

    @Override
    public String GetImage() {
        return input.readText().toString();
    }

    @Override
    public char[] GetSuffix(int len) {
        if (len > input.readLength()) {
            throw new IllegalArgumentException();
        }
        return input.readText(input.readLength() - len, input.readLength()).toString().toCharArray();
    }

    public void ReInit(Reader stream, int i, int i0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void ReInit(InputStream stream, String encoding, int i, int i0) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void backup(int i) {
        input.backup(i);
    }

    @Override
    public int getBeginColumn() {
        return 0;
    }

    @Override
    public int getBeginLine() {
        return 0;
    }

    @Override
    public int getEndColumn() {
        return 0;
    }

    @Override
    public int getEndLine() {
        return 0;
    }

    @Override
    public char readChar() throws IOException {
        int result = input.read();
        if (result == LexerInput.EOF) {
            throw new IOException("LexerInput EOF");
        }
        return (char) result;
    }

}
