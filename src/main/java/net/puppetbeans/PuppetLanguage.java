package net.puppetbeans;

import net.puppetbeans.files.lexer.PuppetTokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;

@LanguageRegistration(mimeType = "text/x-puppet-manifest")
public class PuppetLanguage extends DefaultLanguageConfig {

    @Override
    public Language<PuppetTokenId> getLexerLanguage() {
        return PuppetTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Puppet File";
    }

}