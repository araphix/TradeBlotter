package tradeBlotter.ejb;

import static org.junit.Assert.*;

import java.util.ArrayList;


import java.util.List;

import org.junit.Test;

public class TradeBlotterTest {


//	@Test
//	public void testDummyDataGenerator() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetStockQuery() {
		List<String> stockList = new ArrayList<String>();
		TradeBlotter testTradeblotterObject = new TradeBlotter();
		
		stockList = testTradeblotterObject.getStockQuery();
		
		
				
		
		
	}

	@Test
	public void testGetFxQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBondQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTBillQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateTradeId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSide() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTerms() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTraderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirm() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrderDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testConcatZero() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBetween() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayTradeInformation() {
		fail("Not yet implemented");
	}

}
