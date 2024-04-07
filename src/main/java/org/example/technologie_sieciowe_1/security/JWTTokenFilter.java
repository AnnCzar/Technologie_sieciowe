//package org.example.technologie_sieciowe_1.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.technologie_sieciowe_1.service.JwtService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class JWTTokenFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//
//    @Autowired
//    public JWTTokenFilter(JwtService jwtService) {
//
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            final String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);
//            final String key;
//            if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
//                filterChain.doFilter(request, response);
//                return;
//
//            }
//
//            key = headerAuth.substring(7);
//            final String username = jwtService.extractUsername(key);
//            final String role = jwtService.extractRole(key).name();
//            if (username != null && !username.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
//                if (jwtService.isTokenValid(key)) {
//                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority(role)));
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    securityContext.setAuthentication(authenticationToken);
//                    SecurityContextHolder.setContext(securityContext);
//                }
//            }
//            filterChain.doFilter(request, response);
//        } catch (Exception e) {
//            filterChain.doFilter(request, response);
//        }
//
//    }
//
//
//}
package org.example.technologie_sieciowe_1.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.technologie_sieciowe_1.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

//@Component
//public class JWTTokenFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//
//    @Autowired
//    public JWTTokenFilter(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            final String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//            if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
//                final String token = headerAuth.substring(7);
//                final String username = jwtService.extractUsername(token);
//                final String role = jwtService.extractRole(token).name();
//
//                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    if (jwtService.isTokenValid(token)) {
//                        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//
//                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                                username,
//                                null,
//                                List.of(new SimpleGrantedAuthority(role))
//                        );
//                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                        securityContext.setAuthentication(authenticationToken);
//                        SecurityContextHolder.setContext(securityContext);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            // Log the exception or handle it appropriately
//            logger.error("Error occurred while processing JWT token", e);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
//@Component
//public class JWTTokenFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//
//    @Autowired
//    public JWTTokenFilter(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            final String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//            if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
//                final String token = headerAuth.substring(7);
//
//                if (jwtService.isTokenValid(token)) {
//                    String username = jwtService.extractUsername(token);
//                    String role = jwtService.extractRole(token).name();
//
//                    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                                username, null, List.of(new SimpleGrantedAuthority(role))
//                        );
//                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            // Obsługa błędów parsowania lub weryfikacji tokena JWT
////            logger.error("Error processing JWT token", e);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
@Component
public class JWTTokenFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    @Autowired
    public JWTTokenFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            final String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
                final String token = headerAuth.substring(7);

                if (jwtService.isTokenValid(token)) {
                    String username = jwtService.extractUsername(token);
                    String role = jwtService.extractRole(token).name();

                    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                username, null, List.of(new SimpleGrantedAuthority(role))
                        );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }
        } catch (Exception e) {
            // Obsługa błędów parsowania lub weryfikacji tokena JWT
            logger.error("Error processing JWT token", e);
        }

        filterChain.doFilter(request, response);
    }
}
