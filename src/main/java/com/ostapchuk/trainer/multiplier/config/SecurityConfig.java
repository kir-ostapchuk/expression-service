package com.ostapchuk.trainer.multiplier.config;

public class SecurityConfig {
}

//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//
//    @Autowired
//    public KeycloakClientRequestFactory keycloakClientRequestFactory;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//        http.csrf().disable();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    @Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//
//    @Bean
//    public KeycloakConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public KeycloakRestTemplate keycloakRestTemplate() {
//        return new KeycloakRestTemplate(keycloakClientRequestFactory);
//    }
//}