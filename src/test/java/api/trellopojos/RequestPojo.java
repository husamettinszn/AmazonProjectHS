package api.trellopojos;

import io.restassured.response.Response;

public class RequestPojo {
    //Encaptilation-Data Hiring
    //De_serialosation: JSON tipinde gelen datalari JAVA objelerine cevirmek demektir.
    //ResponsePojo respPojo = response.as(ResponsePojo.class);

   public String name;
   public String key;
   public String token;

    public RequestPojo() {
    }

    public RequestPojo(String name, String key, String token) {
        this.name = name;
        this.key = key;
        this.token = token;
    }

    @Override
    public String toString() {
        return "RequestPojo{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
