package by.egoramel.ft.parser.impl;

import by.egoramel.ft.parser.ListParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ListParserImpl implements ListParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String WHOLE_NUMBER_REGEX = "\\b\\d+\\b";

    @Override
    public int[] parseData(final List<String> stringList) {
        LOGGER.info("Starting data parsing from rows.");
        final List<Integer> numbers = new ArrayList<>();

        for (final String row: stringList) {
            LOGGER.debug("Parsing row: '{}'.", row);
            final List<Integer> numbersFromRow = extractNumbers(row);
            numbers.addAll(numbersFromRow);
        }

        LOGGER.info("Data parsing completed. Found {} numbers.", numbers.size());
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<Integer> extractNumbers(final String row) {
        final List<Integer> numbers = new ArrayList<>();
        final Pattern pattern = Pattern.compile(WHOLE_NUMBER_REGEX);
        final Matcher matcher = pattern.matcher(row);

        while (matcher.find()) {
            final String numberStr = matcher.group();
            LOGGER.debug("Found number string: '{}'.", numberStr);
            final int parsedNumber = Integer.parseInt(numberStr);
            numbers.add(parsedNumber);
        }

        LOGGER.debug("Extracted numbers from row: '{}'.", row);
        return numbers;
    }
}