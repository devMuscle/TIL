# Unit Testing

## 단위 테스트의 목표

### 단위 테스트의 목표

- 단위 테스트가 더 나은 설계로 이어질 수는 있지만, 이는 부수적 효과이며 주 목표는 아니다
- 단위 테스트의 목표는 **소프트웨어 프로젝트의 지속가능한 성장을 가능하게 하는 것**이다



### 코드 커버리지 (Code Coverage, Test Coverage)

- **코드 커버리지 (테스트 커버리지) = 제품 코드 라인 수 / 전체 라인 수**

- 커버리지 지표는 괜찮은 부정 지표이지만 좋은 긍정 지표는 아니다

  - 코드 커버리지가 낮으면 테스트가 충분치 않다는 좋은 증거지만
    코드 커버리지가 높다고 양질의 테스트코드라는 것은 보장하지 않는다

  - [예시](https://github.com/devMuscle/TIL/blob/main/unit-testing/unit-testing/src/test/java/me/devMuscle/unittesting/TestCoverageTest.java)

    - isStringLong1 의 경우 코드 커버리지가 80% 이지만
      isStringLong2 의 경우 코드 커버리지가 100% 이다

    - 테스트 스위트를 개선하지 않았지만 커버리지 숫자가 변화 하였다

      

### 분기 커버리지 (Branch Coverage)

- 분기 커버리지는 코드 커버리지의 단점을 극복하는데 도움이 되어, 더 정확한 결과를 제공한다
- **분기 커버리지 = 통과 분기 / 전체 분기 수**



### 커버리지 지표에 대한 문제점

- **테스트 대상 시스템의 모든 가능한 결과를 검증한다고 보장할 수 없다**

  - 테스트 대상 시스템이 낸 결과가 정확히 예상되는 결과인지 확인해야 한다
  - 결과가 여러개 일 수 있다
  - 지표가 의미 있으려면, 모든 측정 지표를 검증해야 한다
  - [예시](https://github.com/devMuscle/TIL/blob/main/unit-testing/unit-testing/src/test/java/me/devMuscle/unittesting/TestCoverageTest.java)
    - isStringLong 메서드에 대한 테스트에서 return 값에 대한 검증만 하지
      wasLastStringLong 에 대입하는 결과에 대해서는 검증하지 않는다
    - 검증이 없는 테스트의 경우 언제나 통과한다

- **외부 라이브러리의 코드 경로를 고려할 수 있는 커버리지 지표는 없다**

  - 분기 커버리지 지표가 100%로 표시되며, 메서드 결과의 모든 구성 요소를 검증하지만 테스트가 완벽하지 않다
  - [예시](https://github.com/devMuscle/TIL/blob/main/unit-testing/unit-testing/src/test/java/me/devMuscle/unittesting/TestCoverageTest.java)
    - Interger.parseInt 를 수행시에 입력 매개변수에 따라 숨어있는 분기가 많다
      - Null 값
      - 빈 문자열
      - 정수가 아님
      - 너무 긴 문자열

  - 수많은 예외상황에 빠질 수 있지만, 테스트에서 모든 예외 상황을 다루는지 확인할 방법이 없다
  - 모든 코드 경로를 고려해야하는 것이 아니라
    해당 지표로는 단위 테스트가 얼마나 좋은지/나쁜지 판단할 수 없다는 것을 보여준다



### 무엇이 성공적인 테스트 스위트를 만드는가?

- 테스트 스위트가 얼마나 좋은지는 자동으로 확인할 수 없다.
  개인의 판단에 맡겨야 한다.
- 성공적인 테스트 스위트의 특성
  - **개발 주기에 통합되어 있다**
    - 이상적으로는 코드가 변경될때 마다 아무리 작은것이라도 테스트를 실행해야 한다
  - **코드베이스에서 가장 중요한 부분만을 대상으로 한다**
    - 시스템의 가장 중요한 부분에 대한 테스트 노력을 기울이고,
      다른 부분은 간략하게 또는 간접적으로 검증하는 것이 좋다
  - **최소한의 유지비로 최대의 가치를 이끌어낸다**
    - 가치가 유지비를 상회하는 테스트만 스위트에 유지하는 것이 중요하다



## 도서

- [단위 테스트](https://product.kyobobook.co.kr/detail/S000001805070)

