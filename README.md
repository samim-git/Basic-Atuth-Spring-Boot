# Basic Atuthentication Spring Boot
## Data JPA, MySQL
This project shows how to configure basic auth to secure our rest API and basic transaction on Data JPA. You can use this project as a templete to create your own Spring Project using Basic Autentication, Data JPA, and SQL connector.


## Security Configuration
Add the following functions to your security configuration file
<b><u>Note: </u><b> to not allow the spring to save the session for each request then add the <b><i>SessionCreationPolicy.STATELESS</i></b>
<code>
  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().authenticationEntryPoint(basicAuthEntryPoint).and().authorizeRequests().anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("samim")
                .password(getPasswordEncoder().encode("samimjan"))
                .authorities("ROLE_USER");
    }  
</code>
