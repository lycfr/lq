package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

public class DocumentType extends Node {
    private static final String NAME = "name";
    private static final String PUBLIC_ID = "publicId";
    private static final String SYSTEM_ID = "systemId";

    public DocumentType(String name, String publicId, String systemId, String baseUri) {
        super(baseUri);
        attr("name", name);
        attr(PUBLIC_ID, publicId);
        attr(SYSTEM_ID, systemId);
    }

    public String nodeName() {
        return "#doctype";
    }

    /* access modifiers changed from: package-private */
    public void outerHtmlHead(StringBuilder accum, int depth, Document.OutputSettings out) {
        if (out.syntax() != Document.OutputSettings.Syntax.html || has(PUBLIC_ID) || has(SYSTEM_ID)) {
            accum.append("<!DOCTYPE");
        } else {
            accum.append("<!doctype");
        }
        if (has("name")) {
            accum.append(" ").append(attr("name"));
        }
        if (has(PUBLIC_ID)) {
            accum.append(" PUBLIC \"").append(attr(PUBLIC_ID)).append('\"');
        }
        if (has(SYSTEM_ID)) {
            accum.append(" \"").append(attr(SYSTEM_ID)).append('\"');
        }
        accum.append('>');
    }

    /* access modifiers changed from: package-private */
    public void outerHtmlTail(StringBuilder accum, int depth, Document.OutputSettings out) {
    }

    private boolean has(String attribute) {
        return !StringUtil.isBlank(attr(attribute));
    }
}
