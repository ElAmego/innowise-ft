package by.egoramel.ft.factory.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.parser.DataParser;
import by.egoramel.ft.parser.RowParser;
import by.egoramel.ft.parser.impl.DataParserImpl;
import by.egoramel.ft.parser.impl.RowParserImpl;
import by.egoramel.ft.validator.CustomIntArrayValidator;
import by.egoramel.ft.validator.impl.CustomIntArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public final class CustomIntArrayFactoryImpl implements CustomIntArrayFactory {
    private static final Logger LOGGER = LogManager.getLogger(CustomIntArrayFactoryImpl.class);
    private final CustomIntArrayValidator customIntArrayValidator = new CustomIntArrayValidatorImpl();
    private static final int EMPTY_ARRAY_SIZE = 0;

    public CustomIntArray createEmptyCustomIntArray() {
        LOGGER.debug("Attempt to create empty CustomIntArray.");
        return new CustomIntArray(EMPTY_ARRAY_SIZE);
    }

    public CustomIntArray createWithSizeCustomIntArray(final int size) {
        LOGGER.debug("Attempt to create CustomIntArray with size {}.", size);
        customIntArrayValidator.validationOnNegativeSize(size);
        return new CustomIntArray(size);
    }

    public CustomIntArray createFromArrayCustomIntArray(final int[] initialArray) {
        LOGGER.debug("Attempt to create CustomIntArray from {}.", Arrays.toString(initialArray));
        customIntArrayValidator.validateArray(initialArray);
        return new CustomIntArray(initialArray);
    }

    public CustomIntArray createFromFileCustomIntArray() {
        LOGGER.debug("Attempt to create CustomIntArray from a file.");
        final RowParser rowParser = new RowParserImpl();
        final List<String> stringList = rowParser.parseRow();

        customIntArrayValidator.validateStringList(stringList);

        final DataParser dataParser = new DataParserImpl();
        LOGGER.debug("Parsing data from string list.");
        final int[] arrayFromFile = dataParser.parseData(stringList);

        customIntArrayValidator.validateArray(arrayFromFile);

        LOGGER.info("CustomIntArray created successfully from file. Array size: {}", arrayFromFile.length);

        return new CustomIntArray(arrayFromFile);
    }
}