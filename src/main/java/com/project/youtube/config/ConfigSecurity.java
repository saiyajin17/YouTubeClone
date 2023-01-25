package com.project.youtube.config;
/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfiguration; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
 * import org.springframework.security.oauth2.core.OAuth2TokenValidator; import
 * org.springframework.security.oauth2.jwt.Jwt; import
 * org.springframework.security.oauth2.jwt.JwtDecoder; import
 * org.springframework.security.oauth2.jwt.JwtDecoders; import
 * org.springframework.security.oauth2.jwt.JwtValidators; import
 * org.springframework.security.oauth2.jwt.NimbusJwtDecoder; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * 
 * @EnableWebSecurity public class ConfigSecurity extends
 * WebSecurityConfiguration{
 * 
 * @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") private
 * String issuer;
 * 
 * @Value("${auth0.audience}") private String audience;
 * 
 * 
 * @SuppressWarnings("deprecation") protected void configure(HttpSecurity http)
 * throws Exception { http.authorizeRequests() .anyRequest().authenticated()
 * .and() .sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and()
 * .cors(Customizer.withDefaults()) .oauth2ResourceServer() .jwt(); }
 * 
 * 
 * 
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception {
 * 
 * http.authorizeHttpRequests() .and() .sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and()
 * .cors(Customizer.withDefaults()) .oauth2ResourceServer() .jwt(); return
 * http.build(); }
 * 
 * 
 * @Bean JwtDecoder jwtDecoder() { NimbusJwtDecoder jwtDecoder =
 * JwtDecoders.fromOidcIssuerLocation(issuer);
 * 
 * OAuth2TokenValidator<Jwt> audienceValidator = new
 * AudienceValidator(audience); OAuth2TokenValidator<Jwt> withIssuer =
 * JwtValidators.createDefaultWithIssuer(issuer); OAuth2TokenValidator<Jwt>
 * withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer,
 * audienceValidator);
 * 
 * jwtDecoder.setJwtValidator(withAudience);
 * 
 * return jwtDecoder; } }
 */