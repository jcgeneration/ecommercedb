package org.generation.ecommercedb.jwt.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean{
	public static String secret ="CH7-perritos-y-gatitos-97-con-chilaquiles-verdes";
    @Override
    public void doFilter( ServletRequest request, ServletResponse response,
                          FilterChain filterChain )
            throws IOException, ServletException  {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String authHeader = httpServletRequest.getHeader( "authorization" );
        System.out.println("getRequestURI(): " + httpServletRequest.getRequestURI());
        System.out.println("getMethod " + httpServletRequest.getMethod());
         if ( ("POST".equals(( httpServletRequest.getMethod() ))) ||
                (("GET".equals(( httpServletRequest.getMethod() ))) && (! httpServletRequest.getRequestURI().contains("/api/productos/"))  ) ||
                ("DELETE".equals(( httpServletRequest.getMethod() )))  ||
                ("PUT".equals(( httpServletRequest.getMethod() ))) )  {
            if ( authHeader == null || !authHeader.startsWith( "Bearer " ) )  {
                throw new ServletException( "1. Invalid Token!" );
            }//if
            String token = authHeader.substring( 7 );
            try  {
                Claims claims = Jwts.parser().setSigningKey(secret)
                        .parseClaimsJws(token).getBody();
                request.setAttribute( "claims", claims );
            }  catch ( SignatureException | MalformedJwtException e ) {
                throw new ServletException( "2. Invalid Token!" );
            }//catch
        }//else
        filterChain.doFilter( request, response );
    }//doFilter

} //class JwtFilter
