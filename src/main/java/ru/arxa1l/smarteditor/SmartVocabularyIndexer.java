package ru.arxa1l.smarteditor;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Индексатор словаря
 */
public class SmartVocabularyIndexer {

    private SortedMap<String, SortedSet<SmartWord>> index = new TreeMap<>();

    /**
     * Осуществляет индексирование словаря
     */
    void process(final Scanner scanner) {
        if (!scanner.hasNextLine()) {
            throw new IllegalStateException("Vocabulary is empty");
        }

        final int vocLength = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < vocLength; i++) {

            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Unexpected end of vocabulary");
            }
            final String[] vocRecord = scanner.nextLine().split(" ");

            if (vocRecord.length != 2)
                throw new IllegalStateException("Word is corrupt");

            final String key = vocRecord[0];
            final int value = Integer.valueOf(vocRecord[1]);

            // Добавляем индексы
            final SmartWord word = new SmartWord(key, value);
            for (int l = 1; l <= key.length(); l++) {
                final String subkey = key.substring(0, l);

                SortedSet<SmartWord> indexRecord = index.get(subkey);
                if (indexRecord == null) {
                    indexRecord = new TreeSet<>();
                    index.put(subkey, indexRecord);
                }

                if (!indexRecord.add(word))
                    throw new IllegalStateException("Cannot add record to index!");

                if (indexRecord.size() >= 10) {
                    indexRecord.remove(indexRecord.last());
                }
            }
        }
    }

    /**
     * Осуществляет поиск по индексу
     *
     * @param key ключевое слово
     * @return Список с десятью наиболее часто встречающимися словами
     */
    SortedSet<SmartWord> getIndexRecord(String key) {
        return index.get(key);
    }
}
