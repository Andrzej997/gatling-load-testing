package pl.polsl

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost/gateway")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pl,en-US;q=0.7,en;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0")





	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/noauth/images/top20"))

	// trapez zmienny

//	setUp(
//		scn.inject(constantConcurrentUsers(100) during (10 minutes)).protocols(httpProtocol).throttle(
//			jumpToRps(0),
//			holdFor(10 seconds),
//			reachRps(10) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(20) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(30) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(40) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(40) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(30) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(20) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(10) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(20) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(30) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(40) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(5 seconds),
//			reachRps(40) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(25) in (10 seconds),
//			holdFor(15 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//		)
//	)

// pomiar trapezoidalny
//	setUp(
//		scn.inject(constantConcurrentUsers(100) during (30 minutes)).protocols(httpProtocol).throttle(
//			jumpToRps(0),
//			holdFor(50 seconds),
//			reachRps(2) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(4) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(6) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(8) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(10) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(8) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(6) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(4) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(2) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(6) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(10) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(6) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(2) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(10) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(10) in (50 seconds),
//			holdFor(50 seconds),
//			reachRps(0) in (50 seconds),
//			holdFor(50 seconds),
//		)
//	)


	// piła - stała średnia
//	setUp(
//		scn.inject(constantConcurrentUsers(100) during (9 minutes)).protocols(httpProtocol).throttle(
//			jumpToRps(0),
//			holdFor(10 seconds),
//			reachRps(25) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(75) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(25) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(10) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(10) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(25) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(75) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(100) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(75) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(25) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(25) in (10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			holdFor(10 seconds),
//			holdFor(10 seconds)
//		)
//	)

	// pomiar piłokształtny
//	setUp(
//		scn.inject(constantConcurrentUsers(100) during (30 minutes)).protocols(httpProtocol).throttle(
//			jumpToRps(0),
//			holdFor(10 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//			reachRps(12) in (50 seconds),
//			reachRps(0) in (50 seconds),
//		)
//	)

//	setUp(
//			scn.inject(constantConcurrentUsers(100) during (30 minutes)).protocols(httpProtocol).throttle(
//				jumpToRps(0),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//				reachRps(12) in (50 seconds),
//				holdFor(50 seconds),
//				reachRps(0) in (50 seconds),
//				holdFor(10 seconds),
//			)
//		)

// 1. Całkiem niezłe, model otwarty - użytkownik wylatuje z systemu po wykonaniu scenariusza
//	setUp(
//		scn.inject(
//			nothingFor(10 seconds),
//			rampUsers(1000) during (10 seconds),
//			rampUsers(0) during(10 seconds),
//			nothingFor(10 seconds),
//			rampUsers(1000) during (10 seconds),
//			rampUsers(0) during(10 seconds),
//			nothingFor(10 seconds),
//			rampUsers(1000) during (10 seconds),
//			rampUsers(0) during(10 seconds),
//			nothingFor(10 seconds),
//			rampUsers(1000) during (10 seconds),
//			rampUsers(0) during(10 seconds),
//			nothingFor(10 seconds),
//			rampUsers(1000) during (10 seconds),
//			rampUsers(0) during(10 seconds),
//			nothingFor(10 seconds),
//			nothingFor(30 seconds)
//		).protocols(httpProtocol)
//	)

//	setUp(scn.inject(constantUsersPerSec(10) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (10 seconds),
//		holdFor(1 minute),
//		jumpToRps(1),
//		holdFor(1 minute),
//		reachRps(10) in (5 second),
//		holdFor(5 second),
//		jumpToRps(1),
//		holdFor(30 seconds),
//		reachRps(10) in (1 minute),
//		holdFor(1 minute),
//		jumpToRps(0),
//		holdFor(1 minute),
//		jumpToRps(10),
//		holdFor(1 minute),
//		jumpToRps(1),
//		holdFor(3 minutes)
//	);

//	 ciągły 10 na sekundę
//		setUp(scn.inject(constantUsersPerSec(30) during (30 minutes)).protocols(httpProtocol)).throttle(
//			reachRps(10) in (1 seconds),
//			holdFor(10 minute),
//			jumpToRps(0)
//		);
//
//	setUp(scn.inject(constantUsersPerSec(30) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(20) in (1 seconds),
//		holdFor(10 minute),
//		jumpToRps(0)
//	);
//
//	setUp(scn.inject(constantUsersPerSec(30) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(30) in (1 seconds),
//		holdFor(10 minute),
//		jumpToRps(0)
//	);
//
//
//	setUp(scn.inject(constantUsersPerSec(100) during (60 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(1) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(2) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(3) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(4) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(5) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(6) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(7) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(8) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(9) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(10) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(12) in (1 seconds),
//		holdFor(4 minutes),
//		reachRps(14) in (1 seconds),
//		holdFor(4 minutes),
//		jumpToRps(0)
//	);

//	setUp(scn.inject(constantUsersPerSec(100) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (1 seconds),
//		holdFor(4 minute),
//		reachRps(15) in (1 seconds),
//		holdFor(4 minute)
//	);
//
//	setUp(scn.inject(constantUsersPerSec(200) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(70) in (1 seconds),
//		holdFor(10 minute),
//		jumpToRps(0)
//	);

//		setUp(scn.inject(constantUsersPerSec(200) during (30 minutes)).protocols(httpProtocol)).throttle(
//			reachRps(13) in (1 seconds),
//			holdFor(20 minute),
//			jumpToRps(0)
//		);

     // TEST 1
//			setUp(scn.inject(constantUsersPerSec(200) during (30 minutes)).protocols(httpProtocol)).throttle(
//				reachRps(13) in (1 seconds),
//				holdFor(2 minute),
//				reachRps(1) in (1 seconds),
//				holdFor(5 minute),
//				reachRps(13) in (1 seconds),
//				holdFor(2 minute),
//				reachRps(1) in (1 seconds),
//				holdFor(5 minute),
//				reachRps(13) in (1 seconds),
//				holdFor(2 minute),
//				reachRps(1) in (1 seconds),
//				holdFor(5 minute),
//				jumpToRps(0)
//			);

	// TEST 2
//	setUp(scn.inject(constantUsersPerSec(200) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//		holdFor(2 minutes),
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//		holdFor(2 minutes),
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//		holdFor(2 minutes),
//	);

	// TEST 3
//	setUp(scn.inject(constantUsersPerSec(200) during (30 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//		reachRps(13) in (3 minutes),
//		reachRps(1) in (3 minutes),
//	);

	// TEST 4
	setUp(scn.inject(constantUsersPerSec(200) during (30 minutes)).protocols(httpProtocol)).throttle(
		reachRps(13) in (2 minutes),
		holdFor(2 minutes),
		reachRps(1) in (2 minutes),
		holdFor(1 minutes),
		reachRps(13) in (2 minutes),
		holdFor(2 minutes),
		reachRps(1) in (2 minutes),
		holdFor(1 minutes),
		reachRps(13) in (2 minutes),
		holdFor(2 minutes),
		reachRps(1) in (2 minutes),
	);

	// 1 profil uczacy
//		setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//			reachRps(10) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(10) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			holdFor(3 minutes),// koniec rozgrzewki
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//			reachRps(13) in (3 minutes),
//			reachRps(0) in (3 minutes),
//		);

	// 2 profil uczacy
//	setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		holdFor(3 minutes),// koniec rozgrzewki
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//		reachRps(13) in (1 minutes),
//		holdFor(30 seconds),
//		reachRps(0) in (1 minutes),
//		holdFor(30 seconds), // 3m
//	);

	// 3 profil uczacy
//	setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		holdFor(3 minutes),// koniec rozgrzewki
//		reachRps(8) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(12) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(8) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(8) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(12) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//		reachRps(8) in (3 minutes),
//		reachRps(0) in (3 minutes), // 6m
//	);

	// 4 profil uczacy
//	setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		holdFor(3 minutes),// koniec rozgrzewki
//		reachRps(9) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(11) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(13) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(11) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(9) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(9) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(11) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(13) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(11) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//		reachRps(9) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (2 minutes),
//		holdFor(1 minutes), // 6m
//	);

	// 5 profil uczacy
//	setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		holdFor(3 minutes),// koniec rozgrzewki
//		reachRps(8) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(10) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(12) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(10) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(8) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(8) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(10) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(12) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(10) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//		reachRps(8) in (0 seconds),
//		holdFor(3 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(3 minutes), // 6m
//	);

	// 6 profil uczacy - schody
//	setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		holdFor(3 minutes),// koniec rozgrzewki
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(12) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(1 minutes), // 15m
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(12) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(1 minutes), // 15m
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(12) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(1 minutes), // 15m
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(12) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(10) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(8) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(6) in (0 seconds),
//		holdFor(2 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(1 minutes), // 15m
//	);

	// 7 profil uczacy - trojkat
//			setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				holdFor(3 minutes),// koniec rozgrzewki
//				reachRps(5) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(5) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(5) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(5) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(5) in (3 minutes),
//				reachRps(0) in (3 minutes),
//				reachRps(10) in (3 minutes),
//				reachRps(0) in (3 minutes),
//			);

//	setUp(scn.inject(constantConcurrentUsers(200) during (75 minutes)).protocols(httpProtocol)).throttle(
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		reachRps(10) in (3 minutes),
//		reachRps(0) in (3 minutes),
//		holdFor(3 minutes),// koniec rozgrzewki
//		reachRps(8) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(10) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(12) in(2 minutes),
//		holdFor(1 minutes),
//		reachRps(10) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(8) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(5 minutes), // 20m
//		reachRps(8) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(10) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(12) in(2 minutes),
//		holdFor(1 minutes),
//		reachRps(10) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(8) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(5 minutes), // 20m
//		reachRps(8) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(10) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(12) in(2 minutes),
//		holdFor(1 minutes),
//		reachRps(10) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(8) in (2 minutes),
//		holdFor(1 minutes),
//		reachRps(0) in (0 seconds),
//		holdFor(5 minutes), // 20m
//	);
}
