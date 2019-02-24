package com.javalesson.exceptions;

import java.io.Closeable;
import java.io.FileNotFoundException;

public interface SwelfClosable extends Closeable {
    @Override
    void close() throws FileNotFoundException;
}
