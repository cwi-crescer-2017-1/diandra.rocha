package br.com.crescer.imovie.seguranca;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Diandra Rocha
 */
public enum SocialRoles implements GrantedAuthority {

    ROLE_USER;

    @Override
    public String getAuthority() {
        return toString();
    }

    public static List<SocialRoles> valuesToList() {
        return Arrays.asList(SocialRoles.values());
    }
}
