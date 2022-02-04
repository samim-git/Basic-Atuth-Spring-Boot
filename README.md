# Basic Atuthentication Spring Boot
## Data JPA, MySQL
This project shows how to configure basic auth to secure our rest API and basic transaction on Data JPA. You can use this project as a templete to create your own Spring Project using Basic Autentication, Data JPA, and SQL connector.


## Security Configuration
Add the following functions to your security configuration file.
<br/>
<b><u>Note: </u><b> to not allow the spring to save the session for each request then add the <b><i>SessionCreationPolicy.STATELESS</i></b>
  <br/>
  <br/>
```java
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
```

  ## Custom Auth Entry Point
  To handle your http error and generete your custom error response use the folloing function to your <b>CustomEntryPoint</b> class which implement <b>AuthenticationEntryPoint</b>
  <br/>
  <br/>
  ```java
  @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        JSONObject resultMap = new JSONObject();
        resultMap.put("success",false);
        resultMap.put("timestamp",new Date().getTime());
        resultMap.put("status","403");
        resultMap.put("error",authEx.getMessage());
        resultMap.put("path",request.getRequestURI());

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        response.getWriter().write(resultMap.toString());

    }
  ```
  
  <br/>
  Don't forget to add the <b>JSONObject</b> library dependency in <b>pom.xml</b> file.
	<br/>
    ![Screen Shot 2022-02-04 at 3 09 19 PM](https://user-images.githubusercontent.com/57979167/152543025-ddf2599f-3137-457f-a742-dced5e011c5a.png)

