package org.asciidoctor.extension;

import org.asciidoctor.ast.DocumentRuby;
import org.jruby.RubyRegexp;
import org.jruby.util.ByteList;

public abstract class InlineMacroProcessor extends MacroProcessor {

    protected RubyRegexp regexp;
    
    public InlineMacroProcessor(String macroName, DocumentRuby documentRuby) {
        super(macroName, documentRuby);
        ByteList pattern = ByteList.create(macroName + ":(\\S+?)\\[.*?\\]");
        regexp = RubyRegexp.newRegexp(rubyRuntime, pattern);
    }
    
    public RubyRegexp regexp() {
        return regexp;
    }

}
