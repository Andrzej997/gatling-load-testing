package pl.polsl

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:9004")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pl,en-US;q=0.7,en;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0")





	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/noauth/images/top10"))

// pomiar trapezoidalny
//	setUp(
//		scn.inject(constantConcurrentUsers(100) during (10 minutes)).protocols(httpProtocol).throttle(
//			jumpToRps(0),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(50) in (10 seconds),
//			holdFor(10 seconds),
//			reachRps(0) in (10 seconds),
//			holdFor(10 seconds),
//		)
//	)



	// pomiar piłokształtny
	setUp(
		scn.inject(constantConcurrentUsers(100) during (9 minutes)).protocols(httpProtocol).throttle(
			jumpToRps(0),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			reachRps(50) in (10 seconds),
			reachRps(0) in (10 seconds),
			holdFor(10 seconds),
			holdFor(10 seconds),
			holdFor(10 seconds)
		)
	)

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
}
