package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

@Deprecated
public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    public RFC2965DomainAttributeHandler() {
        throw new RuntimeException("Stub!");
    }

    public void parse(SetCookie cookie, String domain) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    public boolean domainMatch(String host, String domain) {
        throw new RuntimeException("Stub!");
    }

    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    public boolean match(Cookie cookie, CookieOrigin origin) {
        throw new RuntimeException("Stub!");
    }
}
