package com.isw.server;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    protected Log logger = LogFactory.getLog(this.getClass());
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
    HttpServletResponse response, Authentication authentication)
    throws IOException {

      handle(request, response, authentication);
      clearAuthenticationAttributes(request);
  }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            logger.debug(
              "Response has already been committed. Unable to redirect to "
              + targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    protected String determineTargetUrl(Authentication authentication) {
        String Name = authentication.getName();
        boolean isParticipante = false;
        boolean isMentor= false;
        boolean isSupervisor= false;
        Collection<? extends GrantedAuthority> authorities
         = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            System.out.println(grantedAuthority.getAuthority());
            if (grantedAuthority.getAuthority().equals("participante")) {
                isParticipante = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("mentor")) {
                isMentor = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("supervisor")) {
                isSupervisor = true;
                break;
            }
        } 
        if (isParticipante) {
            return "tasks/" + Name;
        } else if (isMentor) {
            return "/proyectos";
        } else if (isSupervisor) {
            return "/proyectos";
        } else {
            throw new IllegalStateException();
        }
    }
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}