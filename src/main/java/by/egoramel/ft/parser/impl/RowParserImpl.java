package by.egoramel.ft.parser.impl;

import by.egoramel.ft.exception.ParserException;
import by.egoramel.ft.parser.RowParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RowParserImpl implements RowParser {
    private final static Logger LOGGER = LogManager.getLogger(RowParserImpl.class);
    private final String fileUrl = "src/main/resources/parameters.txt";

    @Override
    public List<String> parseRow() {
        LOGGER.info("Starting to read file: {}", fileUrl);
        try (final FileReader fileReader = new FileReader(fileUrl);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            final List<String> rows = new ArrayList<>();

            while (bufferedReader.ready()) {
                LOGGER.debug("Read line.");
                rows.add(bufferedReader.readLine());
            }

            LOGGER.info("File reading completed.");
            return rows;
        } catch (final IOException e) {
            throw new ParserException(e);
        }
    }
}