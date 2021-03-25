## QnA
This is a document to note down some questions raised by our friends in Group 1 during Lab 2 session (25 March 2021).

**Content**

* [Q1: What is the difference between **`class Circle <E extends Comparable<E>>`** and **`class Circle implements Comparable<Circle>`** ?](#q1-what-is-the-difference-between-class-circle-e-extends-comparablee-and-class-circle-implements-comparablecircle)

* [Q2: Why generic type `extends` Comparable but class `implements` Comparable?](#q2-why-generic-type-extends-comparable-but-class-implements-comparable)

* [Q3: Inner class?](#q3-inner-class)

To be updated...

### Q1: What is the difference between **`class Circle <E extends Comparable<E>>`** and **`class Circle implements Comparable<Circle>`**?

**Short answer** :  
`class Circle <E extends Comparable<E>>` means the generic type `E` in class `Circle` is comparable while `class Circle implements Comparable<Circle>` means the class `Circle` is comparable. Be aware of what is the thing that being comparable here.

**Explanation** :  
Let's look at the following example:  
*Sample 1*
```java
1.  public class Circle implements Comparable<Circle>{
2.     Double radius;
3.
4.     public Circle(double radius) {
5.         this.radius = radius;
6.     }
7.     
8.     @Override
9.     public int compareTo(Circle o) {
10.         return radius.compareTo(o.radius);
11.     }
12. }
```
*Sample 1* presents a class named `Circle` and this class is implementing `Comparable` interface and thus it must override `compareTo` method (the only abstract function in `Comparable` interface).  

Inside the `compareTo` method *(line 10)*, we compare `radius` variable of this class with `radius` variable of another object of this class.  

In this way, we can compare two `Circle` objects using `compareTo` method and when we are comparing two `Circle` objects, we are actually comparing their `Double` variables, aka. `radius` of those two `Circle` objects.  

You can notice here we are able to use `compareTo` method to compare two `Double` (`radius`) as well because `Double` class in Java do implement `Comparable` interfaces too. One worth notice thing here is that if I choose to declare my `radius` variable of `double` (primitive type) instead of `Double`, then I won't be able to use `compareTo` method anymore (We will talk about it later).  

*Sample 2*
```java
1. public class Circle<E extends Comparable<E>>{
2.     E radius;
3.    
4.     public Circle(E radius) {
5.         this.radius = radius;
6.     }
7. }
```
In this second example (*Sample 2*), it presents a **generic** class named `Circle` with generic type `E` that extends `Comparable` interface. This simply means we expect someone create `Circle` class object with a type that is comparable but `Circle` object itself **is not comparable**. That's why we can't override `compareTo` method in `Circle` class.  

For illustrations, I can create a `Circle` object of type `Integer` (ex. `Circle<Integer> circleInt = new Circle(9)`) or a `Circle` object of type `Double` (ex. `Circle<Double> circleDouble = new Circle(9.1)`) but I can't use `compareTo` method to compare two `Circle` objects. Note here, both `Integer` and `Double` that I substitute to generic type of `Circle` class are comparable classes. This means I can't create a `Circle` object of type `ArrayList` (ex. `Circle<ArrayList<Integer>>`) as well because `ArrayList` class is not comparable. It gives you compile time error.  

However, you can define your own `compareTo` method in the `Circle` class in *Sample 2* but do aware that the `compareTo` method that you self-defined is not the same as other `compareTo` methods in other classes that implements `Comparable` interface, for example, the one in *Sample 1*.

*Sample 3*
```java
1.  public class Circle<E extends Comparable<E>>{
2.      E radius;
3.      
4.      public Circle(E radius) {
5.          this.radius = radius;
6.      }
7.      
8.      public int compareTo(Circle<E> o) {
9.          return radius.compareTo(o.radius);
10.     }
11. }
```

As you can see here, `compareTo` method in *Sample 3* is different from the one in *Sample 1*. 

Why I say they are different despite they have the exact same signature and same implementation?

Consider following situations, where we have a static method, `max` that accept two objects of generic type `E` and we compare the two objects and return the one larger.

*Sample 4*
```java
1. public static <E extends Comparable<E>> E max(E o1, E o2) {
2.     if(o1.compareTo(o2) > 0)
3.         return o1;
4.     else
5.         return o2;
6. }
```
From the method signature, you should notice that this method is expecting the objects passed into this method are comparable (*line1* `<E extends Comparable<E>>`). Because we specified that generic type `E` must be comparable, thus we are safe to make assumption that objects passed in had implemented `compareTo` method and we can use it to figure out which object is larger as shown in *line2*.

In this case, I can pass in two `Circle` objects into this method and get the object with larger `radius` if I define my `Circle` class like the one in *Sample 1* but it won't work for the case of *Sample 3* although *Sample 3* `Circle` class also have `compareTo` method. This is because although *Sample 3* `Circle` class have `compareTo` method, but the class itself is not comparable (doesn't implements `Comparable` interface).

Let say if you want to edit your `max` method in *Sample 4* so that it can be used for *Sample 3* `Circle` class object, then you have to edit it to the following example:

*Sample 5*
```java
1. public static Circle max(Circle o1, Circle o2) {
2.     if(o1.compareTo(o2) > 0)
3.         return o1;
4.     else
5.         return o2;
6. }
```
Please aware of the changes in *line 1*, compared to that of *Sample 4*. *Sample 5* `max` method is editted specifically for `Circle` class objects only (it is not generic anymore).

So, after such a long explanation, let us summarize again on the difference: 
> `class Circle <E extends Comparable<E>>` means the generic type `E` in class `Circle` is comparable but not the class while `class Circle implements Comparable<Circle>` means the class `Circle` is comparable. Be aware of what is the thing that being comparable here.

If you understood the above concept fully, then you should now be able to tell that

`class Circle <E extends Comparable<E>> implements Comparable<Circle<E>>`

is actually means the class `Circle` itself is comparable and generic type `E` in this class is also comparable.

### Q2: Why generic type `extends` Comparable but class `implements` Comparable?

### Q3: Inner class?