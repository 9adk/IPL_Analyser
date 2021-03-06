package com.indianPremierLeague.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.CSVReader.CSVBuilderException;
import com.google.gson.Gson;
import com.indianpremierleague.analyser.*;

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
	 * 
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenFileData_IfMatchNumberOfRecords_ShouldReturnTrue() throws IPLAnalyserException {
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
	 * 
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWKTSFileData_IfMatchNumberOfRecords_ShouldReturnTrue() throws IPLAnalyserException {
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
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenRunsData_WhenSortedOnAverage_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
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
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenRunsData_WhenSortedOnSR_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String sortedCSVData = iPLAnalyser.getSRWiseSortedData();
		MostRunsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostRunsCSV[].class);
		assertEquals(333.33f, iplCSV[0].strikeRate, 0.0);
	}

	/**
	 * TestCase for player with maximum no of fours and sixes
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenRunsData_WhenSortedOn4sand6s_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String sortedCSVData = iPLAnalyser.getSortedDataOnNoOfFoursAndSixes();
		MostRunsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostRunsCSV[].class);
		assertEquals("Andre Russell", iplCSV[0].playerName);
	}

	/**
	 * StrikeRate using the fours and sixes data
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenRunsData_WhenSortedOnStrikeRateWithSixandFour_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String name = iPLAnalyser.getSortedDataOnStrikeRateOnSixAndFour();
		assertEquals("Andre Russell", name);
	}

	/**
	 * Player with best average and strike rate
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenRunsData_WhenSortedOnAverageAndStrikeRate_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String sortedCSVData = iPLAnalyser.getSortedOnAverageAndStrikeRate();
		MostRunsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostRunsCSV[].class);
		assertEquals("Andre Russell", iplCSV[0].playerName);
	}

	/**
	 * Player with maximum runs and best average
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenRunsData_WhenSortedOnMaxRunsAndStrikeRate_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		String sortedCSVData = iPLAnalyser.getSortedOnMaxRunsAndStrikeRate();
		MostRunsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostRunsCSV[].class);
		assertEquals("Andre Russell", iplCSV[0].playerName);
	}

	/**
	 * Player with best bowling averages
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnBowlingAvg_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		String sortedCSVData = iPLAnalyser.getSortedOnBowlingAvg();
		MostWktsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostWktsCSV[].class);
		assertEquals("Anukul Roy", iplCSV[0].playerName);
	}

	/**
	 * Player with best striking rate
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnBowlingStrikeRate_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		String sortedCSVData = iPLAnalyser.getSortedOnBowlingStrikeRate();
		MostWktsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostWktsCSV[].class);
		assertEquals("Alzarri Joseph", iplCSV[0].playerName);
	}

	/**
	 * Player with good economy
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnBowlingEconomy_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		String sortedCSVData = iPLAnalyser.getSortedOnBowlingEconomy();
		MostWktsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostWktsCSV[].class);
		assertEquals("Shivam Dube", iplCSV[0].playerName);
	}

	/**
	 * Player with strike rate with 4w and 5w
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnStrikeRateAnd4wOR5w_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		String sortedCSVData = iPLAnalyser.getSortedOnStrikeRateAnd4wOr5w();
		MostWktsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostWktsCSV[].class);
		assertEquals("Alzarri Joseph", iplCSV[0].playerName);
	}

	/**
	 * Player with best average and great strike rate
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnBowlingAvgAndStrikeRate_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		String sortedCSVData = iPLAnalyser.getSortedOnBowlingAvgAndStrikeRate();
		MostWktsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostWktsCSV[].class);
		assertEquals("Alzarri Joseph", iplCSV[0].playerName);
	}

	/**
	 * Player with max wickets and bowling average
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnMaxWicketsAndBowlingAvg_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		String sortedCSVData = iPLAnalyser.getSortedOnMaxWicketsAndBowlingAvg();
		MostWktsCSV[] iplCSV = new Gson().fromJson(sortedCSVData, MostWktsCSV[].class);
		assertEquals("Kagiso Rabada", iplCSV[0].playerName);
		assertEquals("Khaleel Ahmed", iplCSV[1].playerName);

	}

	/**
	 * Player with best batting and bowling average
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnBattingAndBowlingAvg_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		List<String> sortedCSVData = iPLAnalyser.getSortedOnBestBattingAndBowlingAvg();
		assertEquals("Andre Russell", sortedCSVData.get(0));
		assertEquals("Marcus Stoinis", sortedCSVData.get(1));

	}

	/**
	 * Finding the best All Rounder
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnMaxRunsAndWkts_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfWickets(MOST_WKTS);
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		List<String> sortedCSVData = iPLAnalyser.getSortedOnMaxRunsAndWkts();
		assertEquals("Andre Russell", sortedCSVData.get(0));
		assertEquals("Hardik Pandya", sortedCSVData.get(1));

	}

	/**
	 * Finding player with max hundreds and best averages
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnMaxHundredsAndBattingAverage_ShouldReturnTrue()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		List<MostRunsCSV> sortedCSVData = iPLAnalyser.getSortedOnMaxHundredsAndBattingAverage();
		assertEquals("David Warner", sortedCSVData.get(0).playerName);
		assertEquals("Jonny Bairstow", sortedCSVData.get(1).playerName);
	}

	/**
	 * Finding player with zero hundreds but best averages
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 * @throws IPLAnalyserException
	 */
	@Test
	public void givenWktsData_WhenSortedOnZeroCenturiesAndBestBattingAvg()
			throws IOException, CSVBuilderException, IPLAnalyserException {
		iPLAnalyser.loadDataOfRuns(MOST_RUNS);
		List<MostRunsCSV> sortedCSVData = iPLAnalyser.getSortedOnZeroCenturiesAndBestBattingAvg();
		assertEquals("Marcus Stoinis", sortedCSVData.get(0).playerName);
	}

}
