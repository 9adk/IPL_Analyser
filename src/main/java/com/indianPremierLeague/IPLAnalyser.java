package com.indianPremierLeague;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import com.CSVReader.CSVBuilderException;
import com.CSVReader.CSVBuilderFactory;
import com.CSVReader.ICSVBuilder;
import com.google.gson.Gson;

public class IPLAnalyser {
	List<MostRunsCSV> csvRunsList = null;
	List<MostWktsCSV> csvWktsList = null;

	public int loadDataOfRuns(String CSVFile) throws IOException, CSVBuilderException {
		Reader reader = Files.newBufferedReader(Paths.get(CSVFile));
		ICSVBuilder<MostRunsCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		csvRunsList = csvBuilder.getCSVFileList(reader, MostRunsCSV.class);
		return csvRunsList.size();
	}

	public int loadDataOfWickets(String CSVFile) throws IOException, CSVBuilderException {
		Reader reader = Files.newBufferedReader(Paths.get(CSVFile));
		ICSVBuilder<MostWktsCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		csvWktsList = csvBuilder.getCSVFileList(reader, MostWktsCSV.class);
		return csvWktsList.size();
	}

}
