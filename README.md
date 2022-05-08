### Java Generic
allows us to control parameter type for class or method and change it according our needs.
#
#### **Generic Class**
```
public static class MyClass<T> {
  private T myProp;
  
  public T myFunction() {
    return myProp;
  }
}
```

```
public static void main(String[] args) {
  // pass "String" as parameter type
  MyClass<String> myClass = new MyClass<>();
  
  String data = myClass.myFunction();
}
```
Generic index (just as behavior, not mandatory) for parameter type :

> E - Element (Collection or data structure)  
> K - Key  
> N - Number  
> T - Type  
> V - Value  
> S, U, V, etc - 2nd, 3rd, 4th types ...

#
#### **Generic Method**

```
public <T> int count(T[] datas) {
  return datas.length;
}
```

```
int[] numbers = {1, 2, 3, 4, 5};
int numLength = <int>count(numbers);

// or without define type, automatically detect int by array of number
int numLength = count(numbers);

// <T> will be String, according on parameter type (datas);
String[] texts = {"Marsha", "Lenathea", "Lavia"};
int textLength = count(texts);
```
#
#### **Invariant**
means that we cant substitute subtype (child) with supertype (parent).

```
// code below will error, cause String != Object, 
   although String is an instance of Object.
   
MyData<String> dataString = new MyData<>("Marsha");
❌ MyData<Object> dataObject = dataString;

MyData<Object> dataObject = new MyData<>(100);
❌ MyData<Integer> dataInteger = dataObject;
```

#
#### **Covariant**
means that we can substitute subtype (child) with supertype (parent), with keyword :

> ?extends ParentClass

:::warning
Covariant is read-only, so we cant write data generic.
:::

```
public static void main(String[] args) {
  MyData<String> data = new MyData<>("Marsha");
  process(data);
}

public static void process(MyData<? extends Object> data) {
  // we can do this with extends ParentClass
     String -> Object
     
  Object object = data.getData(); // read only
  ❌ data.setData("Lenathea"); // cant do write data
}
```
#
#### **Contravariant**
it's the opposite of Covariant, which we can substitute supertype (parent) with subtype (child), with keyword :

> ?super SubClass

:::warning
we can do read-write in Contravariant, but we must be careful when get (read) data.
:::

```
public static void main(String[] args) {
  MyData<Object> objectData = new MyData<>("Marsha");
  ✅ MyData<?super String> stringData = objectData;
}

public static void process(MyData<? super String> myData){
  myData.setData("Lenathea");
}
```
