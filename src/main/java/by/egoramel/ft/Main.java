package by.egoramel.ft;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import by.egoramel.ft.warehouse.impl.CustomIntArrayWarehouseImpl;

public class Main {
    public static void main(String[] args) throws CustomIntArrayException {
        final CustomIntArrayFactory customIntArrayFactory = new CustomIntArrayFactoryImpl();
        final CustomIntArrayWarehouse customIntArrayWarehouseImpl = CustomIntArrayWarehouseImpl.getInstance();
        final CustomIntArray customIntArray = customIntArrayFactory.createFromFileCustomIntArray(1L);
        System.out.println(customIntArrayWarehouseImpl.getStorage().values());
        customIntArray.set(0, -10);
        System.out.println(customIntArrayWarehouseImpl.getStorage().values());
    }
}