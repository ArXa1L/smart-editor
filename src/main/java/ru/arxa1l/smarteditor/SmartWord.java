package ru.arxa1l.smarteditor;

/**
 * Слово. Содержит тест и частоту повторения в японских текстах
 */
public class SmartWord implements Comparable<SmartWord> {

    private final String key;
    private final int value;

    SmartWord(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(SmartWord o) {
        final int valueCompareResult = Integer.compare(o.getValue(), this.value);
        if (valueCompareResult != 0)
            return valueCompareResult;
        else
            return o.getKey().compareTo(this.key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmartWord word = (SmartWord) o;

        return key != null ? key.equals(word.key) : word.key == null;

    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        return key + ' ' + value + "\n";
    }
}
