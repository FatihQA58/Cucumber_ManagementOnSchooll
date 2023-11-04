package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationMedunna.genereteToken;

public class MedunnaBaseUrl {

    public static RequestSpecification spec;
    public static void setUp(){
        spec=new RequestSpecBuilder()
                .addHeader("Authorization","Bearer "+genereteToken())
                .setContentType(ContentType.JSON)
                .setBaseUri("https://medunna.com/").build();
    }
}
