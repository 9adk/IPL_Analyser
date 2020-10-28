package com.indianPremierLeague;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.CSVReader.CSVBuilderException;
import com.google.gson.Gson;

public class IPLAnalysisTest {
	IPLAnalyser iPLAnalyser;
	private static final String MOST_RUNS = "C:\\Users\\adity\\eclipse-workspace\\Final_IPL\\lib\\MostRuns.csv";
	private static final String MOST_WKTS = "C:\\Users\\adity\\eclipse-workspace\\Final_IPL\\lib\\MostWkts.csv";

	@Before
	public void setUp() {
		iPLAnalyser = new IPLAnalyser();
	}

	/**
	 * TestCase for checking the file is properly loaded or not
	 */
	@Test
	public void givenFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {
		try {
			int count = iPLAnalyser.loadDataOfRuns(MOST_RUNS);
			assertEquals(101, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TestCase for checking the file is properly loaded or not
	 */
	@Test
	public void givenWKTSFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {
		try {
			int count = iPLAnalyser.loadDataOfWickets(MOST_WKTS);
			assertEquals(99, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sorting the data based on best batting average
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnAverage_ShouldReturnTrue() throws IOException, CSVBuilderException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String sortedCSVData = iPLAnalyser.getAverageWiseSortedData();
		MostRunsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostRunsCSV[].class);
		assertEquals(83.2, iplCSV[0].avg, 0.0);
	}

	/**
	 * Sorting the data based on top Striking rate
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnSR_ShouldReturnTrue() throws IOException, CSVBuilderException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String sortedCSVData = iPLAnalyser.getSRWiseSortedData();
		MostRunsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostRunsCSV[].class);
		assertEquals(333.33f, iplCSV[0].strikeRate, 0.0);
	}

}
