package com.coches.util;

public interface Command<T> {
    T execute() throws Exception;
}
