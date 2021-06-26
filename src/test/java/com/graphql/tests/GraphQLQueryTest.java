package com.graphql.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pojos.GraphQLQuery;
import com.qa.pojos.QueryVariable;

import bsh.Variable;
import io.restassured.RestAssured;

public class GraphQLQueryTest {

	public String authHeader = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwZDIwZDg1MDlmOGI0MDA2OGM2ODU1YSJ9LCJuaWNrbmFtZSI6InRvbTEyM2dyZXk0NTYiLCJuYW1lIjoidG9tMTIzZ3JleTQ1NkBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvZmQzMWNiZTM5NDRlYmMwMzNjNDIxMDE4NzlmNGY3YjQ_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZ0by5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMS0wNi0yNlQwNzo0MTo1My40MzNaIiwiaXNzIjoiaHR0cHM6Ly9ncmFwaHFsLXR1dG9yaWFscy5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NjBkMjBkODUwOWY4YjQwMDY4YzY4NTVhIiwiYXVkIjoiUDM4cW5GbzFsRkFRSnJ6a3VuLS13RXpxbGpWTkdjV1ciLCJpYXQiOjE2MjQ2OTMzMTYsImV4cCI6MTYyNDcyOTMxNiwiYXRfaGFzaCI6InJ0OEdzX2d5UWNBZFBsQ0pQdmhINEEiLCJub25jZSI6Inh6c1FsYUcuTjd5WHl6bzIwb19EYnN1Z0xzNlVMZ3VGIn0.XqsE9lybxyCRctHGHnPnWVHEhk_a3oBNAdsIFS8r70StmT-tOYX-_57g-havAmjLMicVcCdA8AvubFxc0Tlk4qbzaM_zgElSr7mHAy39H5K4j1TDL3_bNdcdoWVxlMum6XPGYb6bZP3tvR6oh_GJn6fP2RWiycg77KHdEvnTH5GTpoepEIy1eY9FniOOCQl1YV-a9Urvn7GAasCt6ycWWhH22Rth2kvDHpbEhCxks00YFpbBjuek8L3SefKtKGZocRXNAMbwOBRO85QtjaeZ65bniTdgLJ3JMwGB_KktuJ8E3T8_w2kP9Oo6icXgcs8Lin9mMsHB_46LAv0UKo4mUw";
			
	
	@Test(enabled = true)
	public void getAllFilmsTest() {

		// https://swapi-graphql.netlify.app/.netlify/functions/index

		RestAssured.baseURI = "https://swapi-graphql.netlify.app";
		String query = "{\"query\":\"{\\n  allFilms {\\n    films {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":null}";

		given().log().all()
		.contentType("application/json")
		.body(query)
		.when().log().all()
				.post("/.netlify/functions/index")
				.then().log().all()
				.assertThat().statusCode(200)
				.and()
				.body("data.allFilms.films[0].title", equalTo("A New Hope"));

	}

	@Test(enabled = true)
	public void getAllUsersTest() {
		RestAssured.baseURI = "https://hasura.io";
		String query = "{\"query\":\"{\\n  users(limit: 10) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":null}";

		given().log().all()
			.contentType("application/json")
			.header("Authorization",
					authHeader)
				.body(query)
				.when().log().all()
					.post("/learn/graphql")
					.then().log().all()
						.assertThat().statusCode(200)
							.body("data.users[0].name", equalTo("tui.glen"));

	}

	@DataProvider
	public Object[][] getQueryData(){
		
		return new Object[][] {{"10", "akshayapsangi123" ,"Flutter development"}};
							
		
	}
	
	
	@Test(enabled = true , dataProvider = "getQueryData")
	public void getAllUsersTestWithDataTest(String limit, String name, String title) {
		RestAssured.baseURI = "https://hasura.io";
		String query = "{\"query\": \"{\\n  users(limit: "+limit+", where: {name: {_eq: \\\""+name+"\\\"}}) {\\n    id\\n    name\\n    todos(where: {title: {_eq: \\\""+title+"\\\"}}) {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\": null}";

		given().log().all()
			.contentType("application/json")
			.header("Authorization",
					authHeader)
				.body(query)
				.when().log().all()
					.post("/learn/graphql")
					.then().log().all()
						.assertThat().statusCode(200);
							

	}
	
	
	@Test
	public void getAllUser_WithPojoTest() {
		RestAssured.baseURI = "https://hasura.io";
		GraphQLQuery query = new GraphQLQuery();
		
		query.setQuery("query($limit:Int, $name:String!){\n"
				+ "  users(limit: $limit, where: {name: {_eq: $name}}) {\n"
				+ "    id\n"
				+ "    name\n"
				+ "  }\n"
				+ "}");
		
		QueryVariable varaible = new QueryVariable();
		varaible.setLimit(10);
		varaible.setName("tui.glen");
		
		query.setVariables(varaible);
		
		given().log().all()
			.contentType("application/json")
				.header("Authorization",
						authHeader)
				
				.body(query)
				.when().log().all()
					.post("/learn/graphql")
				.then().log().all()
					.assertThat()
						.statusCode(200)
							.and()
								.body("data.users[0].name", equalTo("tui.glen"));
			
				
		
		
	}

	
}
