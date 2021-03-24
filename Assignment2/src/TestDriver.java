public class TestDriver {
    public static void main (String[] args) throws InvalidKeyException {

        MyDictionary d = new MyDictionary();

        d.Add("one", 1);
        d.Add("two", 2);
        d.Add("three", 3);

        d.Remove("one");
        d.Remove("twodsfd"); // try to remove key that doesn't exist
        d.Remove("two");
        d.Remove("three");
        d.Remove("two"); // this key has already been removed
        d.Remove("one");

        d.Add("one", 1);
        d.Add("two", 2);
        d.Add("three", 3);

        d.Remove("three");

        System.out.println(d.Contains("one")); //T
        System.out.println(d.Contains("two")); //T
        System.out.println(d.Contains("three")); //F
        System.out.println(d.GetValue("one")); // 1
        System.out.println(d.GetValue("two")); // 2
        System.out.println(d.GetValue("three")); // null
        System.out.println(d.IsEmpty()); // F

        try{
            d.Add("one", 1); // adding a duplicated key here
        }catch (InvalidKeyException e){
            System.out.println(e.getMessage()); //Key already exists
        }

    }
}
