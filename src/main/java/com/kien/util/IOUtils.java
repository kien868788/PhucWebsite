package com.kien.util;

import java.io.*;

public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public static byte[] toByteArray(final InputStream inputStream) throws IOException {
        try (final ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int n;
            while ((n = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,n);
            }
            return outputStream.toByteArray();
        }
    }
}
