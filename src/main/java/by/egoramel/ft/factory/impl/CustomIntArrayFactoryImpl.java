package by.egoramel.ft.factory.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.parser.ListParser;
import by.egoramel.ft.parser.FileParser;
import by.egoramel.ft.parser.impl.ListParserImpl;
import by.egoramel.ft.parser.impl.FileParserImpl;
import by.egoramel.ft.validator.CustomIntArrayValidator;
import by.egoramel.ft.validator.impl.CustomIntArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public final class CustomIntArrayFactoryImpl implements CustomIntArrayFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public CustomIntArray createWithSizeCustomIntArray(final int size) throws CustomIntArrayException {
        LOGGER.debug("Attempt to create CustomIntArray with size {}.", size);

        final CustomIntArrayValidator customIntArrayValidator = new CustomIntArrayValidatorImpl();
        final boolean isValidate = customIntArrayValidator.minimumSizeValidation(size);

        if (!isValidate) {
            throw new CustomIntArrayException("Attempt to create an array with the size < 1.");
        }

        return new CustomIntArray(size);
    }

    public CustomIntArray createFromArrayCustomIntArray(final int[] initialArray) throws CustomIntArrayException {
        LOGGER.debug("Attempt to create a CustomIntArray from an array {}.", Arrays.toString(initialArray));

        final CustomIntArrayValidator customIntArrayValidator = new CustomIntArrayValidatorImpl();
        final boolean isValidate = customIntArrayValidator.initialArrayValidation(initialArray);

        if (!isValidate) {
            throw new CustomIntArrayException("Attempt to create a CustomIntArray from an empty or null array.");
        }

        return new CustomIntArray(initialArray);
    }

    public CustomIntArray createFromFileCustomIntArray() throws CustomIntArrayException {
        LOGGER.debug("Attempt to create CustomIntArray from a file.");

        final FileParser fileParser = new FileParserImpl();
        final List<String> stringList = fileParser.parseRow();
        final ListParser listParser = new ListParserImpl();

        LOGGER.debug("Parsing data from a string list.");
        final int[] arrayFromFile = listParser.parseData(stringList);

        LOGGER.info("CustomIntArray created successfully from a file. Array size: {}", arrayFromFile.length);

        return new CustomIntArray(arrayFromFile);
    }
}