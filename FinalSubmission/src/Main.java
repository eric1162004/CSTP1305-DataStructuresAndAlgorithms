public class Main {
    public static void main(String[] args) {
        var list = new MyList<String>();
        list.add("a"); // add a
        list.add("b"); // add b
        list.add("c"); // add c

        list.erase("b"); // remove b
        list.erase("a"); // remove a
        list.erase("c"); // remove c
        list.erase("c");  // do noting if the entry has been removed

        list.add("a"); // add back "a"
        list.replace("a", "aa"); // "a" should be replaced with "aa"
        list.replace("e", "ee"); // "e" does not exist so return;

        list.add("b"); // add back "b"
        list.add("c"); // add back "c"

        System.out.println(list.get(-1));
        System.out.println(list.get(0)); // should print "aa"
        System.out.println(list.get(1)); // print "b"
        System.out.println(list.get(2)); // print "c"
        System.out.println(list.get(3)); // print null

        System.out.println(list.has("aa")); // true
        System.out.println(list.has("ff")); // false

        System.out.println(list.count()); // 3
        System.out.println(list.isEmpty()); //false

        list.removeAll();
        System.out.println(list.count()); // 0
        System.out.println(list.isEmpty()); //true

        // Testing for MyDoubleEndedList

        System.out.println("Testing for myDoubleEndedList");

        var dList = new MyDoubleEndedList<String>();
        dList.addFirst("a");
        dList.addFirst("aa");
        dList.addLast("b");
        dList.addLast("bb");

        System.out.println(dList.count()); // 4
        System.out.println(dList.getFirst()); // print aa
        System.out.println(dList.getLast()); // print bb
        dList.removeFirst();
        dList.removeLast();
        System.out.println(dList.count()); // 2


        System.out.println("end");


    }
}

