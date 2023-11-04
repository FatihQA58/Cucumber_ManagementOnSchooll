package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.RoomPojo;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.MedunnaRoomStepDefinitions.roomId;
import static stepdefinitions.MedunnaRoomStepDefinitions.roomNumberFaker;

public class ApiRoomStepDefinitions {
    Response response;
    RoomPojo expectedData;
    @Given("send get request to url")
    public void sendGetRequestToUrl() {
       //Set the url
        spec.pathParams("first","api","second","rooms")
                .queryParams("sort","createdDate,desc");

        //Set the expected data

        //Send the request and get the response
        response=given(spec).get("{first}/{second}");
        //response.prettyPrint();

        //Do Assertion
        Object actualRoomType= response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomType").get(0);//Gelen body icinden bizim olusturdugumuz odanin numarasi ile filtreleme yapiyoruz.
        Object actualStatus= response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.status").get(0);//Filtrelenen body den gerekli datatyi nokta sonrasina belirterek aliyoruz.
        Object actualPrice=response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.price").get(0);
        Object actualDescription=response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.description").get(0);
        Object actualRoomNumber=response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomNumber").get(0);

        assertEquals(roomNumberFaker,actualRoomNumber);
        assertEquals("SUITE",actualRoomType);
        assertEquals(true,actualStatus);
        assertEquals("123.0",actualPrice+"");
        assertEquals("Created By Cucumber Framework",actualDescription);

    }
    @When("validate body")
    public void validate_body() {

    }
    @Given("send get request to url by id")
    public void sendGetRequestToUrlById() {
        //Set the URL -->https://medunna.com/api/rooms/833030
        spec.pathParams("first","api","second","rooms","third",roomId);

        //Set the expected data
        expectedData=new RoomPojo(roomNumberFaker,"SUITE",true,123.00,"Created By Cucumber Framework");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        response=given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @When("validate response body")
    public void validateresponseBody() throws JsonProcessingException {
        RoomPojo actualData=new ObjectMapper().readValue(response.asString(),RoomPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
    }


}
