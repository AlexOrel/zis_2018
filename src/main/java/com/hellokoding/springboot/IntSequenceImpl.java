package com.hellokoding.springboot;

public class IntSequenceImpl implements IntSequence {

    // Текущая позиция. Изначально ставим равной нулю, так как начинаем обход последовательности с первого элемента
    private int currentPosition = 0;


    // Массив, который хранит элементы
    private int[] elements;


    // Конструктор для создания объекта. Принимает на вход массив с элементами последовательности
    public IntSequenceImpl(int[] elements) {
    }

    // Проверка на наличие следующего элемента
    public boolean hasNext () {
        // Проверяем признак последнего элемента
        if(currentPosition >= elements.length - 1) {
            return false;
        }
        return true;
    }

    public int next() {
        // Переход к следующему элементу
        currentPosition++;
        // Возвращаем следующий элемент
        return elements[currentPosition];
    }

    public static IntSequence of (int ... args) {

        //Сразу возвращаем анонимный класс
        return new IntSequence() {
            private int currentPosition = 0;
            private int[] elements  = args;

            // Внутри анонимного класса реализуем метод hasNext аналогичным образом
            @Override
            public boolean hasNext() {
                if(currentPosition >= elements.length - 1) {
                    return false;
                }
                return true;
            }
            // Внутри анонимного класса реализуем метод next аналогичным образом
            @Override
            public int next() {
                // Переход к следующему элементу
                currentPosition++;
                // Возвращаем следующий элемент
                return elements[currentPosition];
            }
        };
    }

}
