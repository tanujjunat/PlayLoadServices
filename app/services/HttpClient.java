package services;

import play.mvc.*;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.ws.*;

public class HttpClient implements WSBodyReadables, WSBodyWritables {

	private final WSClient wsClient;
	
	@Inject
	public HttpClient(WSClient wsClient) {
		this.wsClient = wsClient;
	}
	
	public VehiclePollutionData getDBData() {
		VehiclePollutionData data = null;
		WSRequest request = wsClient.url("https://tutorial-a111.restdb.io/rest/alert");
		WSRequest complexRequest = request.addHeader("content-type", "application/json")
				.addHeader("x-apikey", "d426afcf53d499d49217ce81b06b7cb3bb559")
				.addHeader("cache-control", "no-cache")
                .setRequestTimeout(Duration.of(5000, ChronoUnit.MILLIS));
		CompletionStage<WSResponse> responsePromise = complexRequest.get();
		CompletionStage<String> responsePromiseAsString = responsePromise.thenApply(r -> r.getBody(string()));
		
		try {
			String responseString = responsePromiseAsString.toCompletableFuture().get();
			ObjectMapper objectM = new ObjectMapper();
			responseString = responseString.substring(1);
			responseString = responseString.substring(0, responseString.length() - 1);
			System.out.println(responseString);
			data = objectM.readValue(responseString, VehiclePollutionData.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
}
