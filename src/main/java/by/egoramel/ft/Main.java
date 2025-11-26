package by.egoramel.ft;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import by.egoramel.ft.service.CustomIntArrayService;
import by.egoramel.ft.service.impl.CustomIntArrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        final CustomIntArrayService customIntArrayService = new CustomIntArrayServiceImpl();
        final CustomIntArrayFactory customIntArrayFactory = new CustomIntArrayFactoryImpl();
        final CustomIntArray customIntArray = customIntArrayFactory.createFromFileCustomIntArray();
        LOGGER.info("Sum is: {}", customIntArrayService.getSum(customIntArray));
    }
}