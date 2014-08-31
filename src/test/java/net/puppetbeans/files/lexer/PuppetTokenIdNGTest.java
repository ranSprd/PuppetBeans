package net.puppetbeans.files.lexer;

import java.io.ByteArrayInputStream;
import net.puppetbeans.files.jcclexer.JavaCharStream;
import net.puppetbeans.files.jcclexer.PuppetManifestParserTokenManager;
import net.puppetbeans.files.jcclexer.Token;

/**
 *
 * @author ran
 */
public class PuppetTokenIdNGTest {
    

    @org.testng.annotations.Test
    public void testTokenStream() {
        PuppetManifestParserTokenManager tokenStream = new PuppetManifestParserTokenManager(
                        new JavaCharStream( new ByteArrayInputStream( 
                                "# comment \nuser {'katie':\n ensure => absent,\n } ".getBytes())) );
        
        Token token = tokenStream.getNextToken();
        while (token != null && !token.image.isEmpty()) {
            System.out.println("TOKEN >" +token +"< :" + token.kind +":");
            token = tokenStream.getNextToken();
        }
    }

    
}
