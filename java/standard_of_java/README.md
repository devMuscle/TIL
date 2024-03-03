# 자바의 정석 3판

[링크](https://www.yes24.com/Product/Goods/24259565)

# Chapter 10. 날짜와 시간 & 형식화

## 날짜와 시간

### Calendar 와 Date

- **Date**는 날짜와 시간을 다룰 목적으로 JDK1.0 부터 제공되는 클래스다
- **Calendar**는 날짜와 시간을 다룰 목적으로 JDK1.1 부터 제공되는 클래스다
  - getInstance() 메서드를 호출해 인스턴스를 반환 받는 형식을 사용한다
    - **최소한의 변경으로 프로그램이 동작하기 위함이다.**
      즉, 다른 종류의 인스턴스를 필요로 하는 경우에 코드를 변경해야 하는데
      메서드를 통해서 얻어오면 코드를 변경하지 않아도 된다.
  - 날짜 시간을 조정하는 메서드, 시간상의 전후를 비교하는 메서드를 제공한다

## 형식화 클래스

### Decimal Format

숫자를 형식화 하는데 사용한다

```java
double number = 1234567.89;
DecimalFormat df = new DecimalFormat("#.#E0");
String result = df.format(number);

System.out.println("result = " + result);
```



### SimpleDateFormat

날짜 데이터를 원하는 형태로 출력하게 도와준다

```java
Date today = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
String result = df.format(today);
```

parse를 이용해서 format에 맞춰져있는 String 형태의 날짜 정보를 Date로 추출할 수 있다

```java
Date date = df.parse("1999년-1월-12일");
```



### ChoiceFormat

특정 범위에 속하는 값을 문자열로 반환해준다.
연속적 또는 불연속적 범위의 값들을 if 문이나 switch 문 보다 쉽게 처리할 수도 있다.

```java
double[] limits = {60,70,80,90}; //낮은 값부터 큰 값의 순서로 작성해야 함
//limits, grades 간의 순서와 개수를 맞추어야 한다.
String[] grades = {"D", "C", "B", "A"};

int[] scores = {100, 95, 88, 80, 62, 60, 70};

ChoiceFormat form = new ChoiceFormat(limits, grades);

for(int score : scores) {
    System.out.println(score + " : " + form.format(score));
}

String pattern = "60#D|70#C|80<B|90#A";

ChoiceFormat form2 = new ChoiceFormat(pattern);

System.out.println("= form2 =");
for(int score : scores) {
    System.out.println(score + " : " + form2.format(score));
}
```



### MessageFormat

데이터를 정해진 형식에 맞게 출력할 수 있도록 도와준다

```java
String msg = "Name: {0} \nTel: {1} \nAge:{2} \nBirthday: {3}";

Object[] arguments = {"홍지표", "010-1234-5678", "25", "03-01"};

String result = MessageFormat.format(msg, arguments);
System.out.println(result);

//같은 형식에서 우너하는 값 추출
String[] data = {"INSERT ('홍지표', '010-123-456', '25', '12-25')", "INSERT ('김자바', '010-456-789', '99', '03-01')"};

String pattern = "INSERT ({0}, {1}, {2}, {3})";
MessageFormat mf = new MessageFormat(pattern);

System.out.println("= parse example =");

for(String datum : data) {
  Object[] extractData = mf.parse(datum);

  for(Object extractDatum : extractData) {
      System.out.print(extractDatum + " ");
  }
  System.out.println();
}
```



## java.time 패키지

JDK1.8 부터 추가된 패키지다.

기존 Calendar 클래스는 변경 가능하므로, **멀티 쓰레드 환경에서 안전하지 못하다.**
이 점을 보완하고자 java.time에는 String 처럼 불변한 객체를 다룬다.
그래서 기존의 객체를 변경하지 않고 새로운 객체를 반환하는 형식을 사용한다. 

**LocalDate**

- 날짜를 다룰때 사용하는 클래스다

**LocalTime**

- 시간을 다룰때 사용하는 클래스다

**LocalDateTime**

- 날짜, 시간을 모두 다룰때 사용하는 클래스다

**Instant**

- 에포크 타임부터 경과된 시간을 나노초 단위로 표현한다.

**ZonedDateTime**

- LocalDateTime에 시간대를 추가한 클래스다.

**Period**

- 날짜의 차이를 다루는 클래스다

**Duration**

- 시간의 차이를 다루는 클래스다

**DateTimeFormatter**

- 날짜와 시간을 형식화 하는데 사용한다



# Chapter 11. 컬렉션 프레임웍

## 컬렉션 프레임웍 (Collection Framework)

컬렉션 프레임웍이란 ‘데이터 군을 저장하는 클래스들을 표준화한 설계’를 뜻한다.
다수의 데이터를 다루는데 필요한 다양하고 풍부한 클새들을 제공해서 편리하다.
또한 인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화되어 있기 때문에
사용법을 익히기에도 편리하고 재사용성이 높은 코드를 작성할 수 있다.

### 컬렉션 프레임웍의 핵심 인터페이스

컬렉션 프레임웍에서는 컬렉션을 크게 3타입이 존재하여 3개의 인터페이스를 정의햇다.
`List`와 `Set` 의 공통된 부분을 다시 뽑아서 `Collection` 을 추가로 정의 하였다.

**List**

- 순서가 있는 데이터의 집합, 데이터의 중복을 허용

**Set**

- 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않음

**Map**

- key, value의 쌍으로 이루어진 데이터의 집합
- 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다.

**Collection 인터페이스**

컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하기 위해 기본적인 메서드 정의
보통 성공시 true, 실패시 false를 반환.
Java API 문서에 `Object` 가 아닌 `E` 로 표현되어 있는데 이는 제네릭스에 의한 표기

**List 인터페이스**

중복을 허용하면서 저장 순서가 유지되는 컬렉션을 구현하는데 사용된다.

**Set 인터페이스**

중복을 허용하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현하는데 사용된다.
구현한 클래스로는 `HashSet`, `TreeSet` 등이 있다.

**Map 인터페이스**

key, value를 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는 데 사용된다.
키는 중복될 수 없지만, 값은 중복을 허용, 중복된 키를 저장하면 마지막에 저장된 값이
남게 된다.
구현한 클래스로는 `HashTable`, `HashMap`, `LinkedHashMap`, `SortedMap`, `TreeMap`등

**Map.Entry 인터페이스**

`Map` 인터페이스의 내부 인터페이스이다. 저장되는 key-value 쌍을 다루기 위해
내부적으로 정의해놓았다. 보다 객체지향적으로 설계하도록 유도하기 위한 것이다.

### `ArrayList`

기존의 `Vector` 를 개선한 것으로 구현원리와 기능이 거의 동일하다.
`Object` 배열을 이용해서 데이터를 순차적으로 저장하고, 더 이상 저장할 공간이 없으면
더 큰 새로운 배열을 생성해서 내용을 복사한다.

`ArrayList` 나 `Vector` 같이 배열을 이용한 자료구조는 데이털르 읽어오고 저장하는
효율이 좋지만, 용량을 변경해야 할 때는 새로운 배열을 생성한 후 기존의 배열로부터
새로 생성된 배열로 데이터를 복사해야하기 때문에 상당히 효율이 떨어진다.
그래서 처음 생성할때 충분한 용량의 인스턴스를 생성하는것이 좋다.

### `LinkedList`

배열은 가장 기본적인 형태의 자료구조로 구조가 가단하며 사용하기 쉽고 데이터를
읽어오는데 걸리는 시간이 가장 빠르다는 장점을 가지고 있지만 단점도 있다.

1. **크기를 변경할 수 없다.**
    - 새로운 배열을 생성해서 데이터를 복사하는 작업이 필요하다.
    - 실행속도 향상을 위해 충분히 큰 크기의 배열을 생성하면 메모리가 낭비 된다.
2. **비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다.**
    - 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는 것은 빠르지만
    데이터를 중간에 추가하려면, 빈자리를 만들기 위해 다른 데이터들을 복사해서 이동해야 한다.

이러한 단점을 보완하기 위해서 `Liked List` 라는 자료구조가 고안되었다.
배열은 모든 데이터가 연속적으로 존재하지만 `LinkedList` 는 불연속적으로 존재하는 데이터를 서로 연결(link)한 형태로 구성되어 있다.



**결론**

1. **순차적으로 추가/삭제하는 경우에는 `ArrayList`가 `LinkedList`보다 빠르다.**
    - 저장공간 부족으로 새로운  `ArrayList` 를 생성해야 하는 경우
    `LinkedList` 가 더 빠를 수 있으니 초기 용량을 잘 확보하자.
    - `ArrayList` 는 마지막 데이터부터 삭제할 경우 각 요소들의 재배치가 필요하지 않기 떄문에 상당히 빠르다. (요소의 값을 null로 바꾸면 됨)
2. **중간 데이터를 추가/삭제하는 경우에는 `LinkedList` 가 `ArrayList` 보다 빠르다.**
    - 중간 요소를 삭제하는 경우 `LinkedList` 가 더 빠르다.
    `LinkedList` 는 연결만 변경해주면 되지만, `LinkedList` 는 추가 공간 확보나
    빈 공간을 채워야하기 때문이다.

|   컬렉션   | 읽기(접근시간) | 추가/삭제 |                           비고                           |
| :--------: | :------------: | :-------: | :------------------------------------------------------: |
| ArrayList  |     빠르다     |  느리다   | 순차적인 추가삭제는 더 빠름.<br />비효율적인 메모리 사용 |
| LinkedList |     느리다     |  빠르다   |            데이터가 많을수록 접근성이 떨어짐             |

