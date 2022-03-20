package com.company;

import java.util.Arrays;

public class genericsList {


    public static void main(String[] args) {

        MyList<Integer> liste = new MyList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + liste.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks :" + liste.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = liste.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);

        // Liste veri türünde alt bir liste oluşturdu
        MyList<Integer> altListem = liste.subList(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 20 değeri : " + liste.contains(20));
        System.out.println("Listemde 120 değeri : " + liste.contains(120));

        // Listeyi tamamen boşaltır ve varsayılan boyutuna çevirir
        liste.clear();
        System.out.println(liste.toString());

    }

    private static class MyList<T> {
        private T[] data;
        private int size = 0;
        private int endIdx = size;  // index
        private final static int INITIAL_CAPACITY = 10;

        public MyList() {
            data = (T[]) new Object[INITIAL_CAPACITY];
        }

        public MyList(int capacity) {
            this.data = (T[]) new Object[capacity];
        }

        public void add(T node) {

            if (data.length <= size) {
                Object[] tempList = (T[]) new Object[2* data.length];

                for (int i=0; i< data.length; i++) {
                    tempList[i] = data[i];
                }

                data = (T[]) tempList;
            }
            data[endIdx++] = node;
            size++;
        }

        public T get(int index) {
            if (!(index >= 0 && index < size))
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            else {
                return data[index];
            }
        }


        public T set(int index, T node) {
            if (!(index >= 0 && index < size))
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            else {
                data[index] = node;
                return data[index];
            }
        }

        public T remove(int index) {
            if (index < 0 || index > size) {
                return null;
            } else {
                T removed = data[index];
                System.arraycopy(data, index + 1, data, index, size - index);
                size--;
                return removed;
            }
        }

        public int indexOf(T node) {
            for (int i = 0; i < size; i++)
                if (data[i] == node)
                    return i;
            return -1;
        }

        public int lastIndexOf(T node) {
            for (int i = size - 1; i >= 0; i--)
                if (data[i] == node)
                    return i;
            return -1;
        }


        public void clear() {
            for (int i = 0; i < size; i++)
                data[i] = null;
            data = Arrays.copyOf(data, INITIAL_CAPACITY);
            size = 0;
        }

        public T[] toArray() {
            T[] newArray = (T[]) new Object[size];
            for (int i = 0; i < size; i++)
                newArray[i] = data[i];
            return newArray;
        }

        public MyList<T> subList(int start, int finish) {
            if ((start < 0 || data.length <= start) && (finish < 0 || data.length <= finish))
                return null;

            MyList<T> subList = new MyList<>(finish - start);

            for (int i=start; i<finish; i++)
                subList.add((T) data[i]);

            return subList;
        }

        public boolean contains(T node) {
            for (int i = 0; i < size; i++) {
                if (data[i] == node){
                    return true;
                }
            }
            return false;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public int getCapacity() {
            return data.length;
        }

        @Override
        public String toString() {

            String result = "";

            for (int i = 0; i < size; i++) {
                if (data[i] != null) {
                    result += data[i];
                    if (i != (size - 1)) {
                        result += ",";
                    }
                }
            }
            return "[" + result + "]";
        }
    }
}
