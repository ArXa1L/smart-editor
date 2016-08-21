package ru.arxa1l.smarteditor;

import java.io.IOException;

/**
 * Облачный текстовый редактор
 */
public class SmartEditor {
    public static void main(String[] args) throws IOException {
        final SmartCompleter smartCompleter = new SmartCompleter();
        smartCompleter.process(System.in);
    }
}
