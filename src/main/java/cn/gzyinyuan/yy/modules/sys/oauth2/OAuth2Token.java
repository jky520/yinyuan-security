package cn.gzyinyuan.yy.modules.sys.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 * Created by DT人 on 2017/9/7 11:21.
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    public String getPrincipal() {
        return token;
    }

    public Object getCredentials() {
        return token;
    }
}
