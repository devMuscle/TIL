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