# Unit Testing

## 단위 테스트의 목표

### 단위 테스트의 목표

- 단위 테스트가 더 나은 설계로 이어질 수는 있지만, 이는 부수적 효과이며 주 목표는 아니다
- 단위 테스트의 목표는 **소프트웨어 프로젝트의 지속가능한 성장을 가능하게 하는 것**이다



### 코드 커버리지

- 코드 커버리지 (테스트 커버리지) = 제품 코드 라인 수 / 전체 라인 수
- 커버리지 지표는 괜찮은 부정 지표이지만 좋은 긍정 지표는 아니다
  - 코드 커버리지가 낮으면 테스트가 충분치 않다는 좋은 증거지만
    코드 커버리지가 높다고 양질의 테스트코드라는 것은 보장하지 않는다
  - [예시](https://github.com/devMuscle/TIL/blob/main/unit-testing/unit-testing/src/test/java/me/devMuscle/unittesting/IsStringLongTest.java)
    - isStringLong1 의 경우 코드 커버리지가 80% 이지만
      isStringLong2 의 경우 코드 커버리지가 100% 이다
    - 테스트 스위트를 개선하지 않았지만 커버리지 숫자가 변화 하였다





## 도서

- [단위 테스트](https://product.kyobobook.co.kr/detail/S000001805070)

