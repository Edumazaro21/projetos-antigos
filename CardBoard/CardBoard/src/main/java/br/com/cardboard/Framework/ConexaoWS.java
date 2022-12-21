package br.com.cardboard.Framework;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoWS {

    public static String get(String path) {
        return get(path, "", "GET");
    }


    public static String get(String path, String parametros, String method) {
        StringBuffer content = new StringBuffer();
        try {

            URL obj = new URL("http://localhost:8080/" + path);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod(method);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(!parametros.isEmpty());
            
            if (!parametros.isEmpty()) {
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(parametros);
                wr.flush();
                wr.close();
            }

            int responseCode = con.getResponseCode();
            System.out.println("\nSending '" + method + "' request to URL : " + path);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content.toString();
    }

}
