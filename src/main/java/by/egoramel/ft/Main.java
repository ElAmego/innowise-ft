package by.egoramel.ft;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import by.egoramel.ft.repository.CustomIntArrayRepository;
import by.egoramel.ft.repository.impl.CustomIntArrayRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws CustomIntArrayException {
        final CustomIntArrayFactory customIntArrayFactory = new CustomIntArrayFactoryImpl();
        final CustomIntArray customIntArray = customIntArrayFactory.createFromFileCustomIntArray(1L);
        final CustomIntArrayRepository customIntArrayRepository = CustomIntArrayRepositoryImpl.getInstance();

        customIntArrayRepository.save(customIntArray);
        LOGGER.info(customIntArrayRepository.findByMaxGreaterThan(5));
    }
}