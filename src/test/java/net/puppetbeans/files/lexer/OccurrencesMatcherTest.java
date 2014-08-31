package net.puppetbeans.files.lexer;

import net.puppetbeans.highlighter.MarkOccurrencesHighlighter;
import org.testng.annotations.Test;

/**
 *
 * @author ran
 */
public class OccurrencesMatcherTest {
    
    public OccurrencesMatcherTest() {
    }

     @Test
     public void testRegExPattern() {
        String selection = "foo(bär".replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)");
         System.out.println(selection);
         
//         MarkOccurrencesHighlighter.getPattern("foo(bär");
     }
}
