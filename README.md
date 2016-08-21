## Облачный текстовый редактор

# Предыстория
Японцы бесконечно влюблены в технику, которая их окружает. Они внимательно следят за всеми техническими новинками и стараются пользоваться самыми современными и «умными» из них. У Дена и Сергея есть гениальный план: они хотят создать облачный текстовый редактор, который покорит японцев. Важнейшей уберинтеллектуальной функцией редактора должна стать функция автодополнения. Если пользователь набрал несколько первых букв слова, редактор должен предложить ему самые правдоподобные окончания.
Ден и Сергей уже собрали огромное количество японских текстов. Для каждого слова японского языка они посчитали число раз, которое оно встречается в текстах. Если пользователь уже ввел несколько букв, то редактор должен показать не более десяти самых часто употребляемых слов, начинающихся со введенных пользователем букв, отсортированных по убыванию частоты упоминания.
Помогите Сергею с Деном перевернуть рынок текстовых редакторов.

# Задача
Реализовать функцию автодополнения следующим образом: по началу слова необходимо выдавать список из `10` наиболее часто встречающихся слов, начинающихся с указанного префикса. Сортировать варианты автодополнения в порядке убывания частоты использования. В случае равенства частот - варианты сортируются естественным образом (по алфавиту). Если вариантов меньше `10`, то выдавать столько, сколько нашли.

# I часть
Решение должно быть в виде консольного java-приложения. Исходные данные подаются через стандартный поток ввода, а все результаты выводятся в стандартный поток вывода.

# Исходные данные
В первой строке находится единственное число N (1 ≤ N ≤ 10^5) - количество слов в словаре. Каждая из следующих N строк содержит слово wi (непустая последовательность строчных латинских букв длиной не более 15) и целое число ni (1 ≤ ni ≤ 10^6) - частота употребления слова wi. Слово и число разделены единственным пробелом. Ни одно слово не повторяется более одного раза. В (N+2)-й строке находится число M (1 ≤ M ≤ 15000). В следующих M строках содержатся слова uj (непустая последовательность строчных латинских букв длиной не более 15) - начала слов, введённых пользователем.

# Результат
Для каждой из M строк необходимо вывести наиболее употребляемые слова, начинающиеся с uj. Варианты дополнения для каждого слова необходимо разделять переводами строк.

# Пример
stdin:
```

5
kare 10
kanojo 20
karetachi 1
korosu 7
sakura 3
3
k
ka
kar
```

stdout:
```
kanojo
kare
korosu
karetachi

kanojo
kare
karetachi

kare
karetachi
```

# Дополнительные требования
* Программа должна выводить ровно то, что требуется по условиям
* Использование maven приветствуется (либо требуется иной скрипт для сборки)
* Код на Java в стиле, соответствующем рекомендациям http://google.github.io/styleguide/javaguide.html
* Приоритет на скорость работы (решение первой части должно отрабатывать не дольше 1-10 секунд на тестовом файле test.in)
* Сам алгоритм (первая часть в первую очередь) должен быть реализован без использования сторонних библиотек и фреймворков;
* Версию Java мы не ограничиваем какой-то одной (можно выбрать любую из 1.6, 1.7 и 1.8).

# Сборка
```mvn clean package```

# Запуск

### Вариант 1
```java -jar smart-editor-1.0.jar < test.in```

### Вариант 2
```java -jar smart-editor-1.0.jar``` + Вставить исходные данные из буфера обмена

### Вариант 3
```java -jar smart-editor-1.0.jar``` + Построчный ввод