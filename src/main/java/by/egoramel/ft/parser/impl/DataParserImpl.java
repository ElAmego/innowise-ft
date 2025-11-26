package by.egoramel.ft.parser.impl;

import by.egoramel.ft.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParserImpl implements DataParser {
    private final static Logger LOGGER = LogManager.getLogger(DataParserImpl.class);
    private final String regex = "\\b\\d+\\b";

    @Override
    public int[] parseData(final List<String> stringList) {
        LOGGER.info("Starting data parsing from rows.");
        final List<Integer> numbers = new ArrayList<>();

        for (final String row: stringList) {
            LOGGER.debug("Parsing row: '{}'.", row);
            numbers.addAll(extractNumbers(row));
        }

        LOGGER.info("Data parsing completed. Found {} numbers.", numbers.size());
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> extractNumbers(final String row) {
        final List<Integer> nums = new ArrayList<>();
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(row);

        while (matcher.find()) {
            final String numberStr = matcher.group();
            LOGGER.debug("Found number string: '{}'.", numberStr);
            nums.add(Integer.parseInt(numberStr));
        }

        LOGGER.debug("Extracted numbers from row: '{}'.", row);
        return nums;
    }
}