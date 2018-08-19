package main;

import Modelos.Usuario;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String args[]) throws Exception {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(2000), 0);
            httpServer.createContext("/", new HttpServlet());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    static class HttpServlet implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            try {
                int RESPONSE_CODE = 200;
                String response = new Usuario().findAll().toString();
                he.sendResponseHeaders(RESPONSE_CODE, response.length());

                OutputStream outputStream = he.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();

            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
