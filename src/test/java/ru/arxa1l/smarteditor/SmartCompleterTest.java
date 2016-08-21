package ru.arxa1l.smarteditor;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Проверка работы уберинтелектуального дополнятора слов
 */
public class SmartCompleterTest {
    @Test
    public void shouldProcess() {

        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (final InputStream is = classLoader.getResourceAsStream("test.in")) {

            final long startTime = System.currentTimeMillis();

            final SmartCompleter smartCompleter = new SmartCompleter();
            smartCompleter.process(is);

            final long endTime = System.currentTimeMillis();
            final long totalTime = endTime - startTime;

            Assert.assertTrue(totalTime < 10000);

            System.out.println("Autocomplete has been processing for " + totalTime + "ms");
        } catch (final IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
