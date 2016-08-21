package ru.arxa1l.smarteditor;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.SortedSet;

import static org.junit.Assert.assertEquals;

/**
 * Проверка работы индексатора
 */
public class SmartVocabularyIndexerTest {

    private static final String EXAMPLE_STRING = "5\naaa 30\naab 25\naba 42\nabb 99\nbaa 3";

    @Test
    public void shouldProcessIndex() {
        final InputStream inputStream = new ByteArrayInputStream(EXAMPLE_STRING.getBytes(StandardCharsets.UTF_8));

        final SmartVocabularyIndexer indexer = new SmartVocabularyIndexer();
        indexer.process(new Scanner(inputStream));

        SortedSet<SmartWord> result = indexer.getIndexRecord("a");
        assertEquals(4, result.size());

        assertEquals(99, result.first().getValue());
        assertEquals("abb", result.first().getKey());
        assertEquals(25, result.last().getValue());
        assertEquals("aab", result.last().getKey());

        result = indexer.getIndexRecord("aa");
        assertEquals(2, result.size());

        assertEquals(30, result.first().getValue());
        assertEquals("aaa", result.first().getKey());
        assertEquals(25, result.last().getValue());
        assertEquals("aab", result.last().getKey());

        result = indexer.getIndexRecord("ba");
        assertEquals(1, result.size());

        assertEquals(3, result.first().getValue());
        assertEquals("baa", result.first().getKey());
    }
}
