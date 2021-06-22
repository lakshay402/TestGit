package com.graphql.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GraphQLQueryTest {

	@Test
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

	@Test
	public void getAllUsersTest() {
		RestAssured.baseURI = "https://hasura.io";
		String query = "{\"query\":\"{\\n  users(limit: 10) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":null}";

		given().log().all()
			.contentType("application/json")
			.header("Authorization",
				"Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwZDIwZDg1MDlmOGI0MDA2OGM2ODU1YSJ9LCJuaWNrbmFtZSI6InRvbTEyM2dyZXk0NTYiLCJuYW1lIjoidG9tMTIzZ3JleTQ1NkBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvZmQzMWNiZTM5NDRlYmMwMzNjNDIxMDE4NzlmNGY3YjQ_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZ0by5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMS0wNi0yMlQxNjoxOToxOC45MjBaIiwiaXNzIjoiaHR0cHM6Ly9ncmFwaHFsLXR1dG9yaWFscy5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NjBkMjBkODUwOWY4YjQwMDY4YzY4NTVhIiwiYXVkIjoiUDM4cW5GbzFsRkFRSnJ6a3VuLS13RXpxbGpWTkdjV1ciLCJpYXQiOjE2MjQzNzg3NjEsImV4cCI6MTYyNDQxNDc2MSwiYXRfaGFzaCI6IjlqQzQ1RXhlQzBWZ2hMcVRuTDlSb1EiLCJub25jZSI6Imx5YTV0ek1SY3QxUE5IYX44M2dFX2gxS0t3eGhpY2ZtIn0.o5IpiiWP-p93iS6ZlCCR_bBossPzNKD0BX7zKLJUi7_4h4LPmdmeghcjAxYOKli8kqrtMoHsOG8X5Fl52zamTP2L_yUJstCWoahAQo2O5VK2aeYXGApO3gt0FksPkvGhY_u1sT8AxMwoZtphaVsQow8rRdmBFvUXzEJsA-i50pVBV-3Gj-SLm7wYS4iUU38EYLLJZD_z751NJo9TLD2dFd4U2257RZL5pnYAWtiuBEwHbCd3Ri0ZVJ6Xyb5MtDlDWUqIJvFtiwLtcNSTdKlSZFRcMa907n2ay4D80xqw4uLOCLeQgzFde1mjG0fqVvON23r4jKE0HjedAicQw5-xgQ")
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
	
	
	@Test(dataProvider = "getQueryData")
	public void getAllUsersTestWithDataTest(String limit, String name, String title) {
		RestAssured.baseURI = "https://hasura.io";
		String query = "{\"query\": \"{\\n  users(limit: "+limit+", where: {name: {_eq: \\\""+name+"\\\"}}) {\\n    id\\n    name\\n    todos(where: {title: {_eq: \\\""+title+"\\\"}}) {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\": null}";

		given().log().all()
			.contentType("application/json")
			.header("Authorization",
				"Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwZDIwZDg1MDlmOGI0MDA2OGM2ODU1YSJ9LCJuaWNrbmFtZSI6InRvbTEyM2dyZXk0NTYiLCJuYW1lIjoidG9tMTIzZ3JleTQ1NkBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvZmQzMWNiZTM5NDRlYmMwMzNjNDIxMDE4NzlmNGY3YjQ_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZ0by5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMS0wNi0yMlQxNjoxOToxOC45MjBaIiwiaXNzIjoiaHR0cHM6Ly9ncmFwaHFsLXR1dG9yaWFscy5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NjBkMjBkODUwOWY4YjQwMDY4YzY4NTVhIiwiYXVkIjoiUDM4cW5GbzFsRkFRSnJ6a3VuLS13RXpxbGpWTkdjV1ciLCJpYXQiOjE2MjQzNzg3NjEsImV4cCI6MTYyNDQxNDc2MSwiYXRfaGFzaCI6IjlqQzQ1RXhlQzBWZ2hMcVRuTDlSb1EiLCJub25jZSI6Imx5YTV0ek1SY3QxUE5IYX44M2dFX2gxS0t3eGhpY2ZtIn0.o5IpiiWP-p93iS6ZlCCR_bBossPzNKD0BX7zKLJUi7_4h4LPmdmeghcjAxYOKli8kqrtMoHsOG8X5Fl52zamTP2L_yUJstCWoahAQo2O5VK2aeYXGApO3gt0FksPkvGhY_u1sT8AxMwoZtphaVsQow8rRdmBFvUXzEJsA-i50pVBV-3Gj-SLm7wYS4iUU38EYLLJZD_z751NJo9TLD2dFd4U2257RZL5pnYAWtiuBEwHbCd3Ri0ZVJ6Xyb5MtDlDWUqIJvFtiwLtcNSTdKlSZFRcMa907n2ay4D80xqw4uLOCLeQgzFde1mjG0fqVvON23r4jKE0HjedAicQw5-xgQ")
				.body(query)
				.when().log().all()
					.post("/learn/graphql")
					.then().log().all()
						.assertThat().statusCode(200);
							

	}

	
}
