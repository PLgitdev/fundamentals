package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //practice
        double palette = .1023912831723; // this doule represents the value of your texture
        double multiplier = .25;

        if (true) {
            palette *= 2;
            for (int i = 1; i > 8; i++) {
                //simulated condition
                /*
                palette += texture(image_smooth
                 */
            }
        }
        int[] ar = new int[]{5, 3, 1, 6, 4, 8, 2, 7};
        char[] cAr = new char[]{'a', 'b', 'e', 'w', 'a', 'g', 'h', 'h', 'g'};
        String balanced = "{}[]()";
        String unbalanced = "{{](";
        List<Integer> walleeInput = Arrays.asList(0, 1, 1, 0);
        List<Integer> walleeInput2 = Arrays.asList(1, 0, 1, 0, 1, 1, 1);
        //System.out.println(walleeCleanUp( 4, walleeInput));
        //System.out.println(walleeCleanUp( 3, walleeInput2));
        QuickSort q = new QuickSort();
        q.sort(ar, 0, ar.length - 1);
        //refactor to format better
        System.out.println(Arrays.toString(ar) + " ar has been sorted");
        System.out.println("1 is located at the " + binarySearch(ar, 0, ar.length - 1, 1) + " position of ar");
        System.out.println("This is the reverse int of  1234567: " + revInteger(1234567));
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(rotateArrayLeft(ar, 3)) + " modular arithmetic shift 3 to the left");
        HomeMadeLinkedList lL = HomeMadeLinkedList.createHomeMadeLinkedList(HomeMadeLinkedList.Node.createNode(9));
        lL.push(6);
        lL.push(5);
        lL.push(5);
        lL.push(7);
        System.out.println("Linked List before insertion: ");
        lL.printList();
        int data = 4;
        int pos = 3;
        lL.insertPos(pos, data);
        System.out.println("Linked List after insertion: ");
        lL.printList();
        System.out.println("Linked List after deletion: ");
        lL.deleteNode(5);
        lL.printList();
        lL.reverseList();
        System.out.println("Linked List after reversing: ");
        lL.printList();
        System.out.println(("Recursive reverse print: "));
        lL.reversePrint(lL.head);
        System.out.println("");
        System.out.println("Linked List after removing last element: ");
        lL.removeLast();
        lL.printList();
        HomeMadeLinkedList.Node x = lL.returnLast();
        System.out.println(x.data);
        int value = lL.returnLastValue();
        System.out.println(value);

        //reverse a list with a stack
        System.out.println("Reverse  List with a Stack: ");
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        while (list.size() > 0) {
            stack.push(list.remove(0));
        }
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        System.out.println(list);
        Scanner sc = new Scanner(System.in);
        //driver code for isBalanced
        if (isBalanced(balanced)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Unbalanced");
        }
        if (isBalanced(unbalanced)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Unbalanced");
        }
    }

    //longest word in a string
    public static String LongestWord(String sen) {
        String longest = "";
        //reg ex non word chars instead?
        StringTokenizer st = new StringTokenizer(sen, " \t\n!@#$%^&*()\\/'\"-_+=.,");
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            if (tok.length() > longest.length()) {
                longest = tok;
            }
        }
        return longest;
    }

    //read a file
        /*
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                "filename"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

    public static boolean isBalanced(String s) {
        //Create left and right delimiters
        //Create a LIFO structure to hold delimiters
        //If the current char from the string matches a right delimiter push onto structure
        //If the the current string is not a left delimiter but is a right delimiter check if the stack is empty
        //Pop the element from the LIFO structure and compare it to the current char
        //If these do not match return false
        String left = "{[(";
        String right = "}])";
        Deque<Character> buffer = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (left.indexOf(c) != -1) {
                buffer.push(c);
            } else if (right.indexOf(c) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (right.indexOf(c) != left.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    public static void print(int[] ar) {
        for (int x : ar) {
            System.out.print(x);
        }
        System.out.println();
    }

    //array manipulation -----------------------------------------------------------------------------------------------

    // length  how many to shift  index
    public static int[] reverseArray(int[] a) {
        int n = a.length;
        int[] revA = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            revA[n - 1 - i] = a[i];
        }
        return revA;
    }

    //Rotate array left
    public static int[] rotateArrayLeft(int[] a, int d) {
        int n = a.length;
        int[] rotA = new int[n];
        for (int i = 0; i < n; i++) {
            rotA[(n - d + i) % n] = a[i];
        }
        return rotA;
    }

    //Rotate array left
    public static int[] rotateArrayRight(int[] a, int d) {
        int n = a.length;
        int[] rotA = new int[n];
        for (int i = 0; i < n; i++) {
            rotA[(n + i + d) % n] = a[i];
        }
        return rotA;
    }
    //Sorting algorithms -----------------------------------------------------------------------------------------------

    //counting a  bubble sort
    static int bubbleSort(int[] a) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    //swap(a[j], a[j + 1]);
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    count++;
                }
            }
        }
        return count;
    }

    //Insertion Sort
    public static int[] insertionSortI(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int c = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > c) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = c;
        }
        return a;
    }

    //Insertions Sort overload
    public static char[] insertionSortC(char[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            char c = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > c) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = c;
        }
        return a;
    }

    //Recursive QuickSort
    public static class QuickSort {
        public void sort(int[] a, int b, int e) {
            if (b < e) {
                int pI = partition(a, b, e);
                sort(a, b, pI - 1);
                sort(a, pI + 1, e);
            }
        }

        private int partition(int[] a, int b, int e) {
            int p = a[e];
            int i = b - 1;
            for (int j = b; j < e; j++) {
                if (a[j] <= p) {
                    i++;
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
            int t = a[i + 1];
            a[i + 1] = a[e];
            a[e] = t;
            return i + 1;
        }
    }
    //Recursive Factorial Function--------------------------------------------------------------------------------------

    public static int factorial(int n) throws IllegalArgumentException {
        //check if n < 0
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        //check if n = 0
        if (n == 0) {
            return 1;
        }
        //perform n*(n-1)!
        else {
            return n * factorial(n - 1);
        }

    }

    //Searching algorithms----------------------------------------------------------------------------------------------

    //Recursive Binary Search
    public static int binarySearch(int[] a, int b, int e, int x) {
        if (b <= e) {
            int m = b + (e - b) / 2;
            if (a[m] == x) {
                return m;
            }
            if (a[m] > x) {
                return binarySearch(a, b, m - 1, x);
            } else {
                return binarySearch(a, e + 1, e, x);
            }
        } else {
            return -1;
        }
    }

    //Reverse int-------------------------------------------------------------------------------------------------------
    private static int revInteger(int k) {
        int x = 0;
        while (k != 0) {
            int n = k % 10;
            x = n + x * 10;
            k /= 10;
        }
        return x;
    }

    //Binary sum--------------------------------------------------------------------------------------------------------
    static long binarySum(long[] data, int a, int b) {
        if (a > b) {
            return 0;
        } else if (a == b) {
            return data[a];
        } else {
            int m = (a + b) / 2;
            return binarySum(data, a, m) + binarySum(data, m + 1, b);
        }
    }

    //Recursive GCD or HCF of the two integers--------------------------------------------------------------------------
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }

    //fibonacci sequence------------------------------------------------------------------------------------------------
    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     -Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
     -Lily decides to share a contiguous segment of the bar selected such that:
     -The length of the segment matches Ron's birth month, and,
     -The sum of the integers on the squares is equal to his birth day.
     -Determine how many ways she can divide the chocolate.
      -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    static int birthday(List<Integer> s, int d, int m) {
        int n = s.size();
        Integer[] intA = new Integer[n];
        intA = s.toArray(intA);
        int count = 0;
        //We look ahead m so we must balance out the loop
        for (int i = 0; i <= n - m; i++) {
            //Use the stream to iterate through the array by segments of i + m and sum up the value to compare
            if (Arrays.stream(intA, i, i + m).mapToInt(Integer::intValue)
                    .sum() == d) {
                count++;
            }
        }
        return count;
    }

    /*static int walleeCleanUp(int p , List<Integer> walleeTrack) {
        int n = walleeTrack.size() + 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(i >= (p - 1) && (i <= (p + 1)) && walleeTrack.get(i) == 1 ) {
                walleeTrack.get(p + 1) != 0) {
                count++;
            }
        } return count;
    }

     */
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      John Watson knows of an operation called a right circular rotation on an array of integers.
      One rotation operation moves the last array element to the first position and shifts all remaining elements right
      one. To test Sherlock's abilities, Watson provides Sherlock with an array of integers. Sherlock is to perform the
      rotation operation a number of times then determine the value of the element at a given position.
      For each array, perform a number of right circular rotations and return the values of the elements at the
      given indices
     */
    public static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        int[] rotA = new int[n];
        int qLength = queries.length;
        int[] q = new int[qLength];
        for (int i = 0; i < n; i++) {
            rotA[(n + i + k) % n] = a[i];
        }
        for (int i = 0; i < qLength; i++) {
            q[i] += rotA[queries[i]];
        }
        return q;
    }

    /*
     Given an array of bird sightings where every element represents a bird type id, determine the id of the most
     frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
     */
    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdFrequency = new HashMap<>();
        int max = 0;
        int birdId = 0;
        for (Integer id : arr) {
            if (birdFrequency.containsKey(id)) {
                int value = birdFrequency.get(id);
                birdFrequency.put(id, value + 1);
            } else {
                birdFrequency.put(id, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : birdFrequency.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                birdId = entry.getKey();
            }
        }
        return birdId;
    }

    /*You are choreographing a circus show with various animals. For one act, you are given two
     kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
     The first kangaroo starts at location  x1 and moves at a rate of v1 meters per jump.
     The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
     You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
     If it is possible, return YES, otherwise return NO.
     */
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String answer = "NO";
        int k1 = x1;
        int k2 = x2;
        for (int i = x1; i < x2; i++) {
            k1 += v1;
            k2 += v2;
            if (k1 == k2) {
                answer = "YES";
            }
        }
        return answer;
    }

    /*
    Two friends Anna and Brian, are deciding how to split the bill at a dinner. Each will only pay for the items they
    consume. Brian gets the check and calculates Anna's portion. You must determine if his calculation is correct.
    For example, assume the bill has the following prices: . Anna declines to eat item  which costs . If Brian
    calculates the bill correctly, Anna will pay . If he includes the cost of , he will calculate .
    In the second case, he should refund  to Anna. */
    /*

Given a sequence of  integers,  where each element is distinct and satisfies . For each  where , that is  increments
from  to , find any integer  such that  and keep a history of the values of  in a return array.
static int[] permutationEquation(int[] p) {
    return yA;
}
 */
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   - one possibility for hashmap in O(n) loop through each array of strings one time by using the HashMap to collect
   - key value pairs that represent the elements from the array and the frequency that they occur in the array.
   - These problems are common with anagrams and frequency of chars in a string an array of strings or integer array
   - these questions commonly ask if given a array can you make comparisons between the frequency of these
   - elements within the arrays for example;
   - A kidnapper wants to make a ransom note out of words in a magazine by cutting them about and re arranging them.
   - To solve the ? "yes" : "no" we wil add all the data in the array and assign it a frequency we will then again
   - through the other array and remove a occurrence each time it is encountered
   - or
   - A student is taking a cryptography class and has found anagrams to be very useful.
   - Two strings are anagrams of each other if the first string's letters can be rearranged to
   - form the second string. In other words, both strings must contain the same exact letters in the same exact
   - frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not
   - The student decides on an encryption scheme
   - that involves two large strings. The encryption is dependent on the
   - minimum number of character deletions required to make the two strings anagrams.
   - Determine this number.Given two strings,  and , that may or may not be of the same length, determine the
   - minimum number of character deletions required to make  and  anagrams. Any characters can
   - be deleted from either of the strings.
   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - */
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> h = new HashMap<>();
        //how many left
        int count = 0;
        //how many are not in there at all
        int tempA = 0;
        //fill the HashMap
        for (char c : a.toCharArray()) {
            if (h.containsKey(c)) {
                int value = h.get(c);
                h.put(c, value + 1);
            } else {
                h.put(c, 1);
            }
        }
        //remove items that exist in both a and b and count missing items
        for (char c : b.toCharArray()) {
            if (h.containsKey(c) && h.get(c) >= 1) {
                int value = h.get(c);
                h.put(c, value - 1);
            } else {
                tempA++;
            }
        }
        //count remaining items that would need to be deleted
        for (Map.Entry<Character, Integer> entry : h.entrySet()) {
            count += entry.getValue();
        }
        //return the amount of missing items plus the count of remaining in the HashMap
        return count + tempA;
    }

    public static void ransomNote(String[] mag, String[] note) {
        Map<String, Integer> m = new HashMap<>();

        for (String s : note) {
            if (m.containsKey(s)) {
                int v = m.get(s);
                m.put(s, v + 1);
            } else {
                m.put(s, 1);
            }
        }
        for (String s : mag) {
            if (m.containsKey(s)) {
                int v = m.get(s);
                if (v == 1) {
                    m.remove(s);
                } else {
                    m.put(s, v - 1);
                }
            }
        }

        String result = m.isEmpty() ? "Yes" : "No";
        System.out.println(result);
    }

    //Singly Linked List t is temp
    public static class HomeMadeLinkedList {
        Node head;

        private HomeMadeLinkedList(Node head) {
            this.head = head;
        }

        static HomeMadeLinkedList createHomeMadeLinkedList(Node head) {
            return new HomeMadeLinkedList(head);
        }

        private static class Node {
            private int data;
            private Node next;

            private Node(int data) {
                this.data = data;
                this.next = null;
            }

            public static Node createNode(int data) {
                return new Node(data);
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public boolean equals(Object o) {
            //check null
            if (o == null) {
                return false;
            }
            //check class
            if (getClass() != o.getClass()) {
                return false;
            }
            //cast to class type
            HomeMadeLinkedList other = (HomeMadeLinkedList) o;
            //check size (not in this list yet)
            //traverse list and check elements
            Node a = head;
            Node b = other.head;
            while (head.next != null) {
                //in this structure they are ints
                if (a.data == b.data) return false;
                a = a.next;
                b = b.next;
            }
            // after traversing the list successfully
            return true;

        }

        public void push(int data) {
            Node newNode = Node.createNode(data);
            newNode.next = head;
            head = newNode;
        }

        public void deleteNode(int pos) {
            if (head == null) {
                return;
            }
            Node temp = head;
            if (pos == 0) {
                head = temp.next;
                return;
            }
            while (pos - 1 > 0) {
                temp = temp.next;
                pos--;
            }
            if (temp == null || temp.next == null) {
                return;
            }
            //previous node is found with the loop above t.next 
            temp.next = temp.next.next;
        }

        public void removeLast() {
            Node head = this.head;
            if (this.head == null) {
                System.out.println("The head of the list is null");
            }
            if (head.next == null) {
                System.out.println(("This is the end of the list or next is null"));
            }
            Node secondToLast = head;
            while (secondToLast.next.next != null) {
                secondToLast = secondToLast.next;
            }
            secondToLast.next = null;
        }

        public Node returnLast() {
            Node head = this.head;
            while (head.next != null) {
                head = head.next;
            }
            return head;
        }

        public int returnLastValue() {
            Node head = this.head;
            while (head.next != null) {
                head = head.next;
            }
            return head.data;
        }

        public void insertPos(int pos, int data) {
            //if given head then head = headNode
            Node headNode = this.head;
            if (pos < 0) {
                System.out.println("Invalid position");
            }
            if (pos == 0) {
                Node newNode = Node.createNode(data);
                newNode.next = headNode;
                this.head = newNode;
            } else {
                while (pos-- >= 0) {
                    if (pos == 0) {
                        Node newNode = Node.createNode(data);
                        newNode.next = headNode.next;
                        headNode.next = newNode;
                    }
                    headNode = headNode.next;
                }
            }
        }

        public void reverseList() {
            Node tail = null;
            Node t;
            while (head != null) {
                t = head.next;
                head.next = tail;
                tail = head;
                head = t;
            }
            head = tail;
            //in hackerrank return tail
        }

        //     Complete this method;
        public void printList() {
            Node node = this.head;
            while (node != null) {
                System.out.print(node.data);
                node = node.next;
                if (node != null) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }

        public void reversePrint(Node head) {
            if (head != null) {
                reversePrint(head.next);
                System.out.print(head.data + ",");
            }
        }
    }

    public static class HomemadeDoublyLinkedList<E> {
        //sentinels
        private Node<E> header;
        private Node<E> trailer;
        //size
        private int size = 0;

        private static class Node<E> {
            private E element;
            private Node<E> prev;
            private Node<E> next;

            public Node(E e, Node<E> p, Node<E> n) {
                this.element = e;
                this.prev = p;
                this.next = n;
            }
        }

        private HomemadeDoublyLinkedList(Node<E> header, Node<E> trailer) {
            this.header = header;
            this.trailer = trailer;
            header.next = trailer;
        }

        public HomemadeDoublyLinkedList<E> createEmptyHDLL() {
            Node<E> h = new Node<>(null, null, null);
            Node<E> t = new Node<>(null, header, null);
            return new HomemadeDoublyLinkedList<>(h, t);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() {
            if (isEmpty()) {
                return null;
            }
            return header.next.element;
        }

        public E last() {
            if (isEmpty()) {
                return null;
            }
            return trailer.prev.element;
        }

        public void addFirst(E e) {
            addBetween(e, header, header.next);
        }

        public void addLast(E e) {
            addBetween(e, trailer, trailer.prev);
        }

        public E removeFirst(E e) {
            if (isEmpty()) {
                return null;
            }
            return remove(header.next);
        }

        public E removeLast(E e) {
            if (isEmpty()) {
                return null;
            }
            return remove(trailer.prev);
        }

        //O(1)
        private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.next = newest;
            successor.prev = newest;
            size++;
        }

        private E remove(Node<E> node) {
            Node<E> predecessor = node.prev;
            Node<E> successor = node.next;
            predecessor.next = successor;
            successor.prev = predecessor;
            size--;
            return node.element;
        }
    }

    public static class ArrayQueue<E> implements Queue<E> {
        //Space complexity O(N) where n is the size of the array
        private E[] data;
        private int f = 0;
        private int sz = 0;

        public ArrayQueue() {
            this(0);
        }

        public ArrayQueue(int capacity) {
            //Suppress cast warning because we are using a generic class
            @SuppressWarnings("unchecked") E[] data = (E[]) new Object[capacity];
            this.data = data;
        }

        @Override
        public int size() {
            return sz;
        }

        @Override
        public boolean isEmpty() {
            return sz == 0;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        //Time complexity: O(1)
        //Someone gets in line
        @Override
        public boolean offer(E e) {
            if (sz == data.length) return false;
            data[(f + 1) % data.length] = e;
            sz++;
            return true;
        }

        @Override
        public E remove() {
            return null;
        }

        //Time complexity: O(1)
        //Let someone in from the line
        @Override
        public E poll() {
            if (isEmpty()) return null;
            E answer = data[f];
            data[f] = null;
            f = (f + 1) % data.length;
            sz--;
            return answer;
        }

        //Time complexity: O(1)
        @Override
        public E element() {
            return null;
        }

        //Time complexity: O(1)
        @Override
        public E peek() {
            if (isEmpty()) return null;
            return data[f];
        }
    }

    //Adapter pattern
    public static class LinkedQueue<E> implements Queue<E> {
        private LinkedList<E> list;

        public LinkedQueue() {
            this.list = new LinkedList<>();
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return list.contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return list.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            //Suppress cast warning because we are using a generic class
            @SuppressWarnings("unchecked") T[] answer = (T[]) list.toArray();
            return answer;
        }

        @Override
        public boolean add(E e) {
            return list.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return list.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return list.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return list.addAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return list.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return list.retainAll(c);
        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public boolean offer(E e) {
            if (e != null) {
                list.addLast(e);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E remove() {
            if (list.isEmpty()) throw new IllegalStateException("List is empty");
            return list.removeFirst();
        }

        @Override
        public E poll() {
            return list.removeFirst();
        }

        @Override
        public E element() {
            return list.element();
        }

        @Override
        public E peek() {
            return list.peekFirst();
        }
    }

    public interface Position<E> {
        E getElement() throws IllegalStateException;
    }

    public interface PositionalList<E> {
        int size();

        boolean isEmpty();

        Position<E> first();

        Position<E> last();

        Position<E> before(Position<E> p) throws IllegalArgumentException;

        Position<E> after(Position<E> p) throws IllegalArgumentException;

        Position<E> addFirst(E e);

        Position<E> addLast(E e);

        Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

        ;

        Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

        ;

        E set(Position<E> p, E e) throws IllegalArgumentException;

        E remove(Position<E> p, E e) throws IllegalArgumentException;
    }

    public static class PositionalLinkedList<E> implements PositionalList<E> {

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public Position<E> first() {
            return position(header.next);
        }

        @Override
        public Position<E> last() {
            return position(trailer.prev);
        }

        @Override
        public Position<E> before(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return position(node.prev);
        }

        @Override
        public Position<E> after(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return position(node.next);
        }

        @Override
        public Position<E> addFirst(E e) {
            return addBetween(e, header, header.next);
        }

        @Override
        public Position<E> addLast(E e) {
            return addBetween(e, trailer.prev, trailer);
        }

        @Override
        public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return addBetween(e, node.prev, node);
        }

        @Override
        public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return addBetween(e, node, node.next);
        }

        @Override
        public E set(Position<E> p, E e) throws IllegalArgumentException {
            Node<E> node = validate(p);
            E answer = node.element;
            node.element = e;
            return answer;
        }

        @Override
        public E remove(Position<E> p, E e) throws IllegalArgumentException {
            //Validate the position
            Node<E> node = validate(p);
            Node<E> predecessor = node.prev;
            Node<E> successor = node.next;
            predecessor.next = successor;
            successor.prev = predecessor;
            size--;
            E answer = node.element;
            node.element = null;
            node.next = null;
            node.prev = null;
            return answer;
        }

        //Sentinels x
        Node<E> trailer;
        Node<E> header;

        int size = 0;

        private static class Node<E> implements Position {

            private E element;
            private Node<E> prev;
            private Node<E> next;

            private Node(Node<E> prev, Node<E> next, E element) {

                this.prev = prev;
                this.next = next;
                this.element = element;

            }

            public Node<E> getInstance(Node<E> prev, Node<E> next, E element) {
                return new Node<E>(prev, next, element);
            }

            @Override
            public Object getElement() throws IllegalStateException {
                if (next == null) {
                    throw new IllegalStateException("Position is no longer valid");
                }
                return element;
            }
        }

        private PositionalLinkedList(Node<E> header, Node<E> trailer) {
            this.header = header;
            this.trailer = trailer;
            header.next = trailer;
        }

        public PositionalLinkedList<E> getInstance() {
            Node<E> h = new Node<>(null, null, null);
            Node<E> t = new Node<>(null, header, null);
            return new PositionalLinkedList<E>(h, t);
        }

        // Private utilities  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
            Node<E> newest = new Node<>(pred, succ, e);
            pred.next = newest;
            succ.prev = newest;
            size++;
            return newest;
        }

        private Node<E> validate(Position<E> p) throws IllegalArgumentException {
            if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
            Node<E> node = (Node<E>) p; // safe cast
            if (node.next == null) {
                throw new IllegalArgumentException("position is no longer in the list");
            }
            return node;
        }

        private Position<E> position(Node<E> node) {
            if (node == header || node == trailer) {
                return null; // Deny sentinel access to user
            }
            return node;
        }

    }

    public interface Tree<E> extends Iterable<E> {
        Position<E> root();

        Position<E> parent(Position<E> p) throws IllegalArgumentException;

        Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

        int numChildren(Position<E> p) throws IllegalArgumentException;

        boolean isInternal(Position<E> p) throws IllegalArgumentException;

        boolean isExternal(Position<E> p) throws IllegalArgumentException;

        boolean isRoot(Position<E> p) throws IllegalArgumentException;

        int size();

        boolean isEmpty();

        Iterator<E> iterator();

        Iterable<Position<E>> positions();
    }

    public abstract class AbstractTree<E> implements Tree<E> {
        public int depth(Position<E> p) {
            if (isRoot(p)) {
                return 0;
            } else {
                return 1 + depth(parent(p));
            }
        }

        public int height(Position<E> p) {
            int h = 0;
            for (Position<E> c : children(p)) {
                h = Math.max(h, 1 + height(c));
            }
            return h;
        }

        @Override
        public boolean isInternal(Position<E> p) throws IllegalArgumentException {
            return numChildren(p) > 0;
        }

        @Override
        public boolean isExternal(Position<E> p) throws IllegalArgumentException {
            return numChildren(p) == 0;
        }

        @Override
        public boolean isRoot(Position<E> p) throws IllegalArgumentException {
            return p == root();
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }
    }

    public interface BinaryTree<E> extends Tree<E> {
        Position<E> left(Position<E> p) throws IllegalArgumentException;

        Position<E> right(Position<E> p) throws IllegalArgumentException;

        Position<E> sibling(Position<E> p) throws IllegalArgumentException;
    }

    public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
        public Position<E> sibling(Position<E> p) {
            Position<E> parent = parent(p);
            if (parent == null) return null;
            if (p == left(p)) return right(p);
            else return left(p);
        }

        @Override
        public int numChildren(Position<E> p) throws IllegalArgumentException {
            int count = 0;
            if (left(p) != null) count++;
            if (right(p) != null) count++;
            return count;
        }

        @Override
        public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
            List<Position<E>> snapshot = new ArrayList<>(2);
            if (left(p) != null) snapshot.add(left(p));
            if (right(p) != null) snapshot.add(right(p));
            return snapshot;
        }
    }
}
