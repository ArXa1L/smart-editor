package ru.arxa1l.smarteditor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

/**
 * Уберинтелектуальный дополнятор слов
 */
public class SmartCompleter {

    /**
     * Осуществляет обработку входящего потока ввода. Вывод осуществляется в стандартный поток
     * вывода.
     *
     * @param is Поток ввода
     * @throws IOException Может возникнуть при доступе к потоку вывода
     */
    void process(final InputStream is) throws IOException {
        process(is, System.out);
    }

    /**
     * Осуществляет обработку входящего потока ввода
     *
     * @param is Поток ввода
     * @param os Поток вывода
     * @throws IOException Может возникнуть при доступе к потоку вывода
     */
    private void process(final InputStream is, final OutputStream os) throws IOException {

        final Scanner scanner = new Scanner(is);

        // Индексирование
        final SmartVocabularyIndexer indexer = new SmartVocabularyIndexer();
        indexer.process(scanner);

        // Проверка на соответствие формату
        if (!scanner.hasNextLine()) {
            throw new IllegalStateException("Unexpected end of data");
        }
        int dataLength = Integer.valueOf(scanner.nextLine());

        // Чтение блока данных
        final List<String> dataList = new ArrayList<>(dataLength);
        for (int i = 0; i < dataLength; i++) {
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Unexpected end of data");
            }
            dataList.add(scanner.nextLine());
        }

        // Обработка данных и вывод
        for (final String dataRecord : dataList) {
            final SortedSet<SmartWord> words = indexer.getIndexRecord(dataRecord);

            if (words != null) {
                for (final SmartWord word : words) {
                    os.write(word.toString().getBytes());
                }

                os.write("\n".getBytes());
            }
        }
    }
}
