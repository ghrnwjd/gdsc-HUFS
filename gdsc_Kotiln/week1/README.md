# ***Kotlin Basic***

## ***Variable Type***

`var` 타입과 `val` 타입이 있다.

```
var name = "호영"
name = "호영2" // 가능

val name2 = "호영"
name2 = "호영2" // ERROR
```

`var` 타입은 변할 수 있는 값에 사용되며 위 코드와 같이 `val`타입의 변수를 재정의하면 `Val cannot be reassigned` 에러가 발생한다.

코틀린에서는 변수의 타입을 추론하는 언어이다. ( 파이썬과 비슷한 것 같다. )
또한 변수의 타입을 직접 설정해줄 수 있다.

```
val myByte: Byte = 13
val myShort: Short = 125
val myInt: Int = 123123123
val myLong: Long = 12_039_812_309_487_120
val myFloat: Float = 13.37F
val myDouble: Double = 3.14159265358979323846
var isSunny: Boolean = true
```

`Character` 타입과 `String` 타입은 자바와 마찬가지로 `''`과 `""`으로 구분한다.

```
// Characters
val letterChar = 'A'
val digitChar = '1'
 
// Strings
val myStr = "Hello World"
var firCharInStr = myStr[0] // Character Type
var lastCharInStr = myStr[myStr.length - 1]

// cf
String myStr = "Hello World";
char firCharInStr = myStr.charAt(0);
```

## ***Operators***

연산자는 자바와 동일하다
* 산술 연산자 : `+`, `-`, `*`, `/`, `%`
* 비교 연산자 : `==`, `!=`, `<=` `>=` 
* 할당 연산자 : `+=`, `-=`, `*=`, `/=`, `%=`
* 증감/감소 연산자 : `++`, `--`

## ***While, For***
반복문 역시 자바와 비슷하지만 조금 달랐다.

- 자바
```
while(조건) {
    실행문
}

for(초기화, 조건, 증감)
```

- 코틀린
```
while(조건) {
    실행문
}

// case1
for (i in 1..10) {
    실행문
}

// case2
for(i in 1 until 10) {
    실행문
}

// case3
for(i in 1 until 10 step 2) {
    실행문
}
```

`for` 반복문은 자바보다는 파이썬에 더욱 가까운 느낌이다.
`print` 역시 자바의 경우 변수를 출력하기 위해선 `+` 로 연결하였는데 `$`을 사용하여 바로 출력할 수 있는 점이 파이썬과 유사해보인다.

```
// Java
for(int i = 1; i <= 10; i++ ) {
    System.out.println("현재 값은 " + i + "입니다.");
}

// Kotlin
for (i in 1..10) {
    println("현재 값은 $i 입니다.")
}
```



## ***Nullable***

Java에서 가장 많이 발생하는 오류 중 하나로 `NPE (NullPointerException)` 이며 코틀린에선 이 에러를 제거하기 위해 Nullable 타입을 지원한다.

코틀린의 기본 값은 `Non-Null` 타입이다.

```
var nullable: String? = null (컴파일 성공, Nullable 타입)
var nonNull: String = null (컴파일 에러, Non-Null 타입)

val nullableList: List<Int?> = listOf(1, 3, 5, null, 9)
```

## 코틀린에서 NPE가 발생하는 경우
 - 자바 라이브러리를 사용하면 NPE 발생 가능

>자바에서는 Non-Null 타입이 존재하지 않기때문에 Nullable 타입으로 리턴 됨.

```
String getString() {
    String str = "";
    return str;
}

var str1: String = getString() // 컴파일 에러 발생.

var str2: String = getString()!! // 컴파일이 성공되지만 리턴되는 값이 null 이면 NPE가 발생함.
```

`!!` 은 NPE가 발생하지 않도록 null 이 아님을 보장할 수 있을 때 사용

## Safe Call


```
var a: String? = null
print(a?.length)
```
위의 경우 null을 출력하며 NPE를 발생시키지 않는다.

```
print(a?.b?.c?.d?.length)
```
a,b,c,d 중 하나라도 null 이면 null을 출력한다.

null 일 경우 default 값을 할당하고 싶을 때
```
// Java
String s = null;
int len = a != null ? a.length : -1(default);
```
으로 작성 할 수 있지만 코틀린에서는 삼항연산자를 지원하지 않기 때문에 if 문을 사용한다.

```
// Kotlin
String s = null;
val l = if (s == null) -1 else s.length

// Use Elvis Operator ( ?: )
val l2 = s?.length ?: -1

```

### 자바에서 Nullable 타입은 없는 걸까

`Optional` 클래스가 존재한다.

```
public final class Optional<T> {

    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;
    
    private Optional() {
        this.value = null;
    }
    
     public T orElse(T other) {
        return value != null ? value : other;
    }

    public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }
}
```

`orElse` 나 `orElseGet` 메소드를 보면 코틀린에서 `if-else` 문법과 비슷하게 적용된다는 것을 알 수 있다.