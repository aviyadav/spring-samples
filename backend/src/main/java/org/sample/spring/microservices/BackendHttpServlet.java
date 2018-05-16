package org.sample.spring.microservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackendHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        String greeting = request.getParameter("greeting");
        
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setGreeting(greeting + " from cluster Backend");
        responseDTO.setTime(System.currentTimeMillis());
        responseDTO.setIp(getIp());
        PrintWriter out = response.getWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out, responseDTO);
    }

    private String getIp() {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BackendHttpServlet.class.getName()).log(Level.SEVERE, null, ex);
            hostname = "unknown";
        }
        
        return hostname;
    }
}
