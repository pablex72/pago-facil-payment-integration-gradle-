import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
public class Cash_payment_client {
    public static void main(String[] args) {
        try {
            String url = "https://sandbox.pagofacil.tech/cash/charge";
            URL endpoint = new URL(url);
            HttpsURLConnection client = (HttpsURLConnection)endpoint.openConnection();
            client.setRequestMethod("POST");
            String params =
                    "branch_key=ba3b2748672431ebeebeed1327c14959a94a74be" +
                            "&user_key=ce4287a4093e4fca1928f2cde9bf041ee7de8292" +
                            "&order_id=tienda_pedro_005" +
                            "&product=camara fotografica de 15 mega " +
                            "&amount=6500.99" +
                            "&store_code=OXXO" +
                            "&customer=pedro perez" +
                            "&email=pedro@pagofacil.net";
            client.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(client.getOutputStream());
            writer.writeBytes(params);
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream())
            );
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } catch (Exception exception) {
            System.out.println("EXCEPTION: " + exception.getMessage());
        }
    }
//
//    {"branch_key":"ba3b2748672431ebeebeed1327c14959a94a74be",
//            "user_key":"ce4287a4093e4fca1928f2cde9bf041ee7de8292",
//            "order_id":"tienda_pedro_001",
//            "product":"camara fotografica de 15 mega pixeles",
//            "amount":"6500.99",
//            "store_code":"OXXO",
//            "customer":"pedro perez",
//            "email":"pedro@pagofacil.net"}
//
//    {
//        "branch_key":"e147ee31531d815e2308d",
//            "user_key":"f541b3f11f0f9b3fb3349",
//            "order_id":"75464",
//            "product":"Playera",
//            "amount":"2.0",
//            "store_code":"SANTANDER",
//            "customer":"11",
//            "email":"pruebas@pagofacil.net"
//    }

}