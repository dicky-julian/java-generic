import static utils.Output.*;

public class GenericClass {
    public static void main(String[] args) {
        SingleGeneric<String> singleGeneric = new SingleGeneric<>("sample text");
        String text = singleGeneric.getText();

        println("My text: " + text);

        MultipleGeneric<String, String> multipleGeneric = new MultipleGeneric<>("Marsha", "Lenathea");
        println("My Name: " + multipleGeneric.getName());
    }
}

class SingleGeneric<T> {
    private T text;

    public SingleGeneric(T text) {
        this.text = text;
    }

    public T getText() {
        return text;
    }

    public void setText(T text) {
        this.text = text;
    }
}

class MultipleGeneric<T, U> {
    private T firstName;
    private U lastName;

    public MultipleGeneric(T firstName, U lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}