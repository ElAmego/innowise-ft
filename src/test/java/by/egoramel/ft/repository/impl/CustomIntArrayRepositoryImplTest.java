package by.egoramel.ft.repository.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import by.egoramel.ft.repository.CustomIntArrayRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayRepositoryImplTest {
    private CustomIntArrayFactory customIntArrayFactory;
    private CustomIntArrayRepository customIntArrayRepository;

    @BeforeEach
    void setUp() {
        customIntArrayFactory = new CustomIntArrayFactoryImpl();
        customIntArrayRepository = CustomIntArrayRepositoryImpl.getInstance();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should add new array to repository.")
    void shouldSetCorrectValue() throws CustomIntArrayException {
        final CustomIntArray array = customIntArrayFactory.createWithSizeCustomIntArray(5, 1L);
        final int expectLength = 1;

        final int resultLength = customIntArrayRepository.getRepositorySize();

        assertEquals(expectLength, resultLength, "Length of repository should be 1.");
    }

    @Test
    @DisplayName("Should remove array from repository.")
    void shouldRemoveCorrectValue() throws CustomIntArrayException {
        final CustomIntArray array = customIntArrayFactory.createWithSizeCustomIntArray(5, 2L);
        final int expectLength = 0;

        customIntArrayRepository.remove(array);
        final int resultLength = customIntArrayRepository.getRepositorySize();

        assertEquals(expectLength, resultLength, "Length of repository should be 0.");
    }
}