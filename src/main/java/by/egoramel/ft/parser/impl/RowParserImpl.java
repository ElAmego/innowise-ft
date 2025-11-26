package by.egoramel.ft.parser.impl;

import by.egoramel.ft.exception.ParserException;
import by.egoramel.ft.parser.RowParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RowParserImpl implements RowParser {
    private final static Logger LOGGER = LogManager.getLogger(RowParserImpl.class);
    private final String fileUrl = "src/main/resources/parameters.txt";

    @Override
    public List<String> parseRow() {
        LOGGER.info("Starting to read file: {}", fileUrl);

        final Path path = Paths.get(fileUrl);

        try {
            LOGGER.info("File reading completed.");
            return Files.readAllLines(path);
        } catch (final IOException e) {
            throw new ParserException(e.getMessage());
        }
    }
}