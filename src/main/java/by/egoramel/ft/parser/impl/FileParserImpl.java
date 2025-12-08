package by.egoramel.ft.parser.impl;

import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileParserImpl implements FileParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String fileUrl = "data/parameters.txt";

    @Override
    public List<String> parseRow() throws CustomIntArrayException {
        LOGGER.info("Starting to read file: {}.", fileUrl);

        final Path path = Paths.get(fileUrl);
        final List<String> rowList;

        try {
            LOGGER.info("File reading completed.");
            rowList = Files.readAllLines(path);
        } catch (final IOException e) {
            throw new CustomIntArrayException(e.getMessage());
        }

        return rowList;
    }
}