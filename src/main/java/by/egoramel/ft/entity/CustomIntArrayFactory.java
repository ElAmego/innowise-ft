package by.egoramel.ft.entity;

import by.egoramel.ft.parser.DataParser;
import by.egoramel.ft.parser.RowParser;
import by.egoramel.ft.parser.impl.DataParserImpl;
import by.egoramel.ft.parser.impl.RowParserImpl;
import by.egoramel.ft.validator.CustomIntArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static by.egoramel.ft.validator.CustomIntArrayValidator.validateStringList;

@SuppressWarnings("unused")
public final class CustomIntArrayFactory {
    private static final int EMPTY_ARRAY_SIZE = 0;
    private static final Logger LOGGER = LogManager.getLogger(CustomIntArrayFactory.class);

    private CustomIntArrayFactory() {}

    public static CustomIntArray createEmptyCustomIntArray() {
        LOGGER.debug("Attempt to create empty CustomIntArray.");
        return new CustomIntArray(EMPTY_ARRAY_SIZE);
    }

    public static CustomIntArray createWithSizeCustomIntArray(final int size) {
        LOGGER.debug("Attempt to create CustomIntArray with size {}.", size);
        CustomIntArrayValidator.validationOnNegativeSize(size);
        return new CustomIntArray(size);
    }

    public static CustomIntArray createFromArrayCustomIntArray(final int[] initialArray) {
        LOGGER.debug("Attempt to create CustomIntArray from {}.", Arrays.toString(initialArray));
        CustomIntArrayValidator.validateArray(initialArray);
        return new CustomIntArray(initialArray);
    }

    public static CustomIntArray createFromFileCustomIntArray() {
        LOGGER.debug("Attempt to create CustomIntArray from a file.");
        final RowParser rowParser = new RowParserImpl();
        final List<String> stringList = rowParser.parseRow();

        validateStringList(stringList);

        final DataParser dataParser = new DataParserImpl();
        LOGGER.debug("Parsing data from string list.");
        final int[] arrayFromFile = dataParser.parseData(stringList);

        CustomIntArrayValidator.validateArray(arrayFromFile);

        LOGGER.info("CustomIntArray created successfully from file. Array size: {}", arrayFromFile.length);

        return new CustomIntArray(arrayFromFile);
    }
}