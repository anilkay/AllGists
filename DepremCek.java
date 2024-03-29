import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
/*
@author
Anil Kaynar
 */
public class DepremCek {

    private final String RASATHANE_URL = "http://www.koeri.boun.edu.tr/scripts/lst1.asp";
    private final int BUYUKLUK_BASLANGIC = 60;
    private final int BUYUKLUK_SON = 63;
    private final int YER_BASLANGIC = 71;
    private final int YER_SON = 110;

    public List<Deprem> getDepremList() {
        String body = null;
        try {
            body = httpResponseResult();
        } catch (IOException e) {
            //e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            //e.printStackTrace();
            return null;
        }
        String depremler = cleanOutput(body);
        //System.out.println(depremler); //Fazlalıkları attık bakalım.
        return createDepremList(depremler);
    }

   /* public static void main(String[]args){

        DepremCek depremCek=new DepremCek();
        List<Deprem> depremList=depremCek.getDepremList();
        depremList.forEach(i->{
            System.out.println(i.toString());
        });
    }*/

    private String httpResponseResult() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().
                followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(RASATHANE_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println("Response: " + response.statusCode());
        return response.body();
    }

    private String cleanOutput(String body) {
        int firstindex = body.indexOf("<pre>");
        int lastindex = body.lastIndexOf("</pre>");
        String depremler = body.substring(firstindex, lastindex);
        int first2 = depremler.indexOf("2");
        return depremler.substring(first2).trim();

    }

    private List createDepremList(String cleardepremler) {

        String[] depremlertektek = cleardepremler.split("\n");
        List<Deprem> depremList = new ArrayList<>();
        for (String dep : depremlertektek) {
            String buyukluk = dep.substring(BUYUKLUK_BASLANGIC, BUYUKLUK_SON);
            double buyuklukdouble = Double.parseDouble(buyukluk);
            String yer = dep.substring(YER_BASLANGIC, YER_SON);
            Deprem tempDeprem = new Deprem(yer, buyuklukdouble);
            depremList.add(tempDeprem);
        }
        return depremList;
    }
}

class Deprem {
    private String Yer;
    private double Buyukluk;

    Deprem(String yer, double buyukluk) {
        Yer = yer;
        Buyukluk = buyukluk;
    }

    @Override
    public String toString() {
        return Yer + "  " + Buyukluk;
    }

    public String getYer() {
        return Yer;
    }

    public double getBuyukluk() {
        return Buyukluk;
    }
}
