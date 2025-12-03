package by.egoramel.ft.factory.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.parser.ListParser;
import by.egoramel.ft.parser.FileParser;
import by.egoramel.ft.parser.impl.ListParserImpl;
import by.egoramel.ft.parser.impl.FileParserImpl;
import by.egoramel.ft.repository.CustomIntArrayRepository;
import by.egoramel.ft.repository.impl.CustomIntArrayRepositoryImpl;
import by.egoramel.ft.validator.CustomIntArrayValidator;
import by.egoramel.ft.validator.impl.CustomIntArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public final class CustomIntArrayFactoryImpl implements CustomIntArrayFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private final CustomIntArrayRepository customIntArrayRepository = CustomIntArrayRepositoryImpl.getInstance();

    public CustomIntArray createWithSizeCustomIntArray(final int size, final long id) throws CustomIntArrayException {
        LOGGER.debug("Attempt to create CustomIntArray with size {}.", size);

        final CustomIntArrayValidator customIntArrayValidator = new CustomIntArrayValidatorImpl();
        final boolean isValidate = customIntArrayValidator.minimumSizeValidation(size);

        if (!isValidate) {
            throw new CustomIntArrayException("Attempt to create an array with the size < 0.");
        }


        LOGGER.trace("Creating CustomIntArray with size {} and ID {}.", size, id);
        final CustomIntArray customIntArray = new CustomIntArray(size, id);

        LOGGER.debug("Saving CustomIntArray with ID {} to repository.", id);
        customIntArrayRepository.save(customIntArray);

        return customIntArray;
    }

    public CustomIntArray createFromArrayCustomIntArray(final int[] initialArray, final long id)
            throws CustomIntArrayException {
        LOGGER.debug("Attempt to create a CustomIntArray from an array {}.", Arrays.toString(initialArray));

        final CustomIntArrayValidator customIntArrayValidator = new CustomIntArrayValidatorImpl();
        final boolean isValidate = customIntArrayValidator.initialArrayValidation(initialArray);

        if (!isValidate) {
            throw new CustomIntArrayException("Attempt to create a CustomIntArray from an empty or null array.");
        }

        LOGGER.trace("Creating CustomIntArray from array with ID {}.", id);
        final CustomIntArray customIntArray = new CustomIntArray(initialArray, id);

        LOGGER.debug("Saving CustomIntArray from array with ID {} to repository.", id);
        customIntArrayRepository.save(customIntArray);

        return customIntArray;
    }

    public CustomIntArray createFromFileCustomIntArray(final long id) throws CustomIntArrayException {
        LOGGER.debug("Attempt to create CustomIntArray from a file.");

        final FileParser fileParser = new FileParserImpl();
        LOGGER.trace("Parsing file.");

        final List<String> stringList = fileParser.parseRow();
        final ListParser listParser = new ListParserImpl();

        LOGGER.debug("Parsing data from a string list.");
        final int[] arrayFromFile = listParser.parseData(stringList);

        LOGGER.info("CustomIntArray created successfully from a file. Array size: {}.", arrayFromFile.length);

        final CustomIntArray customIntArray = new CustomIntArray(arrayFromFile, id);
        LOGGER.debug("Saving file-based CustomIntArray with ID {} to repository.", id);
        customIntArrayRepository.save(customIntArray);

        return customIntArray;
    }
}