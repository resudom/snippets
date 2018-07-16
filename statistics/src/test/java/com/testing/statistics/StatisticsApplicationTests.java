package com.testing.statistics;

import com.testing.statistics.model.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StatisticsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatisticsApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsApplicationTests.class);

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate;
	private HttpHeaders headers;
	private ScheduledExecutorService scheduler;

	@Before
	public void before() {

		restTemplate = new TestRestTemplate();
		headers = new HttpHeaders();
		scheduler = Executors.newSingleThreadScheduledExecutor();
	}

	@After
	public void after() {

		scheduler.shutdown();
	}


	@Test
	public void testAddTransaction1() throws ExecutionException, InterruptedException {

		long currentTime = System.currentTimeMillis();
		LOGGER.info("Current Timestamp: " + currentTime);

		scheduler.schedule(new AddTransactionDelay(100, currentTime), 0, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(300, currentTime + 10000), 10000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(400, currentTime + 20000), 20000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(700, currentTime + 30000), 30000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(50, currentTime + 40000), 40000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(550, currentTime + 50000), 50000, TimeUnit.MILLISECONDS);


		ScheduledFuture<String> scheduledFuture = scheduler.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {

				return getStatisticsStr();
			}
		}, 57000, TimeUnit.MILLISECONDS );

		LOGGER.info("Timestamp before getStatistics(): " + System.currentTimeMillis());
		String responseStr = scheduledFuture.get();
		LOGGER.info("Timestamp after getStatistics(): " + System.currentTimeMillis());
		String expectedStr = "{\"sum\":2100.0,\"avg\":350.0,\"max\":700.0,\"min\":50.0,\"count\":6}";

		assertEquals("Test Failed.", expectedStr, responseStr);
	}

	@Test
	public void testAddTransaction2() throws ExecutionException, InterruptedException {


	    Thread.sleep(60000);

		long currentTime = System.currentTimeMillis();
		LOGGER.info("Current Timestamp: " + currentTime);

		scheduler.schedule(new AddTransactionDelay(700, currentTime), 0, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(50, currentTime + 10000), 10000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(400, currentTime + 20000), 20000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(300, currentTime + 30000), 30000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(350, currentTime + 40000), 40000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(550, currentTime + 50000), 50000, TimeUnit.MILLISECONDS);


		ScheduledFuture<String> scheduledFuture = scheduler.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {

				return getStatisticsStr();
			}
		}, 78000, TimeUnit.MILLISECONDS );

		LOGGER.info("Timestamp before getStatistics(): " + System.currentTimeMillis());
		String responseStr = scheduledFuture.get();
		LOGGER.info("Timestamp after getStatistics(): " + System.currentTimeMillis());
		String expectedStr = "{\"sum\":1600.0,\"avg\":400.0,\"max\":550.0,\"min\":300.0,\"count\":4}";

		assertEquals("Test Failed.", expectedStr, responseStr);
	}

	@Test
	public void testAddTransaction3() throws ExecutionException, InterruptedException {


		Thread.sleep(80000);

		long currentTime = System.currentTimeMillis();
		LOGGER.info("Current Timestamp: " + currentTime);

		scheduler.schedule(new AddTransactionDelay(100, currentTime), 0, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(300, currentTime + 10000), 10000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(400, currentTime + 20000), 20000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(600, currentTime + 30000), 30000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(50, currentTime + 40000), 40000, TimeUnit.MILLISECONDS);
		scheduler.schedule(new AddTransactionDelay(550, currentTime + 50000), 50000, TimeUnit.MILLISECONDS);


		ScheduledFuture<String> scheduledFuture = scheduler.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {

				return getStatisticsStr();
			}
		}, 78000, TimeUnit.MILLISECONDS );

		LOGGER.info("Timestamp before getStatistics(): " + System.currentTimeMillis());
		String responseStr = scheduledFuture.get();
		LOGGER.info("Timestamp after getStatistics(): " + System.currentTimeMillis());
		String expectedStr = "{\"sum\":1600.0,\"avg\":400.0,\"max\":600.0,\"min\":50.0,\"count\":4}";

		assertEquals("Test Failed.", expectedStr, responseStr);
	}


	private String getStatisticsStr() {

		HttpEntity<Void> entity = new HttpEntity<Void>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				getUrlWithPort("/statistics/statistics"),
				HttpMethod.GET, entity, String.class);
		return response.getBody();
	}

	private ResponseEntity<Void> addTestTransaction(Transaction transaction) {

		HttpEntity<Transaction> entity = new HttpEntity<Transaction>(transaction, headers);
		return restTemplate.exchange(getUrlWithPort("/statistics/transactions"),
                    HttpMethod.POST, entity, Void.class);
	}

	private String getUrlWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	class AddTransactionDelay implements Runnable {

		private double amount;
		private long timeStamp;

		public AddTransactionDelay(double amount, long timeStamp) {

			this.amount = amount;
			this.timeStamp = timeStamp;
		}

		@Override
		public void run() {

			addTestTransaction(new Transaction(amount, timeStamp));
		}
	}

}