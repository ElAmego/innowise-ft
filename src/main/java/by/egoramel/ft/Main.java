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
        final CustomIntArrayWarehouse customIntArrayWarehouse = CustomIntArrayWarehouseImpl.getInstance();
        final CustomIntArray customIntArray1 = customIntArrayFactory.createFromFileCustomIntArray(1L);
        final CustomIntArray customIntArray2 = customIntArrayFactory.createFromArrayCustomIntArray(new int[]{1, 5, 4, 0, 3}, 2L);

        System.out.println(customIntArrayWarehouse.getMap().values());

        customIntArray1.set(0, 5);
        customIntArray2.set(0, 10);

        System.out.println(customIntArrayWarehouse.getMap().values());
    }
}
