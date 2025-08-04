package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.TVPlan.TVPackage;



class EEDTtesting {

	TVPlan test;
	
	@ParameterizedTest
	@CsvSource({
		"P1, A3, true, 300",
		"P1, A3, false, 350",
		"P1, A1, true, 200",
		"P1, A1, false, 250",
		"P1, A2, true, 200",
		"P1, A2, false, 250",
		"P1, A0, true, 100",
		"P1, A0, false, 150",
		
		"P2, A3, true, 500",
		"P2, A3, false, 550",
		"P2, A1, true, 400",
		"P2, A1, false, 450",
		"P2, A2, true, 400",
		"P2, A2, false, 450",
		"P2, A0, true, 300",
		"P2, A0, false, 350",
		
		"P3, A3, true, 600",
		"P3, A3, false, 650",
		"P3, A1, true, 500",
		"P3, A1, false, 550",
		"P3, A1, true, 500",
		"P3, A1, false, 550",
		"P3, A0, true, 400",
		"P3, A0, false, 450",
		
		"P0, A0, false, 0",
		"P4, A0, false, 0",
		"P5, A0, false, 0"
		})
		
	void test_Extended_Entry_Decision_Table(String mainPackage, String additional, boolean discount, double totalPrice) {
		boolean offline_watching = false;
		boolean live_service = false;
		TVPackage selectedPackage = null;
		
		if (mainPackage.equals("P1")) {
			selectedPackage = TVPackage.STANDARD;
		}else if (mainPackage.equals("P2")) {
			selectedPackage = TVPackage.PREMIUM;
		}else if (mainPackage.equals("P3")) {
			selectedPackage = TVPackage.FAMILY;
		}
		
		if (additional.equals("A1")) {
			offline_watching = true;
		}else if (additional.equals("A2")) {
			live_service = true;
		}else if (additional.equals("A3")) {
			offline_watching = true;
			live_service = true;
		}
		
		test = new TVPlan(offline_watching, live_service, discount);
		assertEquals(totalPrice, test.pricePerMonth(selectedPackage));
	}
}
