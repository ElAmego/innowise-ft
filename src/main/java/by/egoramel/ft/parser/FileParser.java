package by.egoramel.ft.parser;

import by.egoramel.ft.exception.CustomIntArrayException;

import java.util.List;

public interface FileParser {
    List<String> parseRow() throws CustomIntArrayException;
}