package com.hs.basicauth.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.basicauth.user.User;
import org.json.JSONObject;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

@Component
public class BasicAuthEntryPoint implements AuthenticationEntryPoint {
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

}
