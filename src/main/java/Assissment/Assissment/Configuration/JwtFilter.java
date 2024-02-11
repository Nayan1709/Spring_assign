package Assissment.Assissment.Configuration;

import Assissment.Assissment.Service.TokenService;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;
@Configuration
public class JwtFilter extends GenericFilterBean {
    private TokenService tokenService;
    public JwtFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        String token = httpServletRequest.getHeader("Authorization");
        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return ;
        }
        //specific APIs without token
        if(allowRequestWithoutToken(httpServletRequest)) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req,res);
        }
        else {
            Integer userId = new Integer(tokenService.getUserIdToken(token));
            httpServletRequest.setAttribute("userId", userId);
            filterChain.doFilter(req,res);
        }
    }
    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getRequestURI());
        if ((httpServletRequest.getRequestURI().contains("/user") ||
                httpServletRequest.getRequestURI().contains("/product")) && (!httpServletRequest.getRequestURI().contains("/delete"))){
            return true;
        }
        return false;
    }
}
