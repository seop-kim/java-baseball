# 숫자 야구 게임 (REFACTORING)

## 리팩토링 History

- String 은 상수화, 연관성 있는 상수는 enum으로 분리
- business 와 ui 로직 분리
- 변수와 매개 변수, 함수 등 이름 수정
- 불필요한 코드 제거
- 10줄 이내로 코드 수정


## 기능 목록
### Business

- [X] 컴퓨터는 1 ~ 9의 서로 다른 임의의 수 3개를 생성한다.
- [X] 플레이어의 입력 값이 정상인지 확인한다.
    - [X] 3자리의 값인지 확인한다.
    - [X] 숫자만을 입력했는지 확인한다.
    - [X] 중복 값이 있는지 확인한다.


- [X] 컴퓨터의 랜덤 값과 플레이어의 입력 값을 비교한다.
    - [X] 스트라이크의 수를 확인한다.
    - [X] 볼의 수를 확인한다.

### UI

- [X] 비교한 값의 결과를 출력한다.
- [X] 게임에 필요한 메세지를 출력한다.

## 기능 요구 사항

- 컴퓨터는 1~9 사이의 서로 다른 수로 이루어진 3개의 값을 생성한다.
- 플레이어로 부터 1~9 사이의 서로 다른 수로 이루어진 3개의 값을 받는다.
- 플레이어가 잘 못된 값을 입력하면 `IllegalArgumentException` 을 발생시킨 후 종료시킨다.
- 플레이어가 입력한 값을 컴퓨터의 랜덤 값과 각각 비교한다.
    - 값이 같고 같은 자리에 있으면 `스트라이크`
    - 값이 값으나 다른 자리에 있으면 `볼`
    - 같은 값이 하나도 없으면 `낫싱`


- 비교한 결과 값을 볼, 스트라이크 순으로 출력한다.
    - 값이 0일 경우 출력하지 않으며 볼, 스트라이크 둘 다 0 이면 낫싱이다.


- 3스트라이크일 시 게임은 종료되며 재시작 여부를 받는다.
    - 재시작 : 1, 종료 : 2

## 프로그래밍 요구 사항

- Project의 최상의 README의 요구 사항을 기본으로 전제한다.

## 추가된 프로그래밍 요구 사항

- 입력은 UI 로직에서만 받을 수 있다.
- 함수는 선언부부터 길이가 10줄을 초과하지 않는다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 객체는 메세지를 호출하여 상태 값을 변경시킨다.
- 발생할 수 있는 예외 상황에 대해 테스트 코드를 작성한다.
- 비즈니스 로직과 UI 로직을 분리한다.
- 연관성 있는 상수는 enum을 활용한다.
- 객체의 상태 접근을 제한한다. (private 함수를 테스트 하고자 한다면 클래스 분리를 고려해도 된다.)
- 필드의 수를 줄이기 위해 노력한다.
- commit은 Git 컨벤션 가이드를 준수한다.

~~~
리팩토링 전 README

기능목록정의
===
Summary
--
    interface를 사용하여 기능을 정의하고 구현체를 만들어 기능을 구현한다.

사용자
--
    1. 사용자의 입력을 요청하는 함수
        - method : requestInputData
        - return : String

    2. 입력 값이 3자리인지 확인하는 함수
        - method : inputLengthCheck
        - param : String input
        - return : boolean

    3. 입력 값이 숫자인지 확인하는 함수
        - method : inputCheckInt
        - param : String input
        - return : boolean

    4. 입력 값을 int 배열로 변환하는 함수
        - method : inputToIntArr 
        - param : String input
        - return : int[]

    5. 입력 값 자릿 값 별로 1~9인지 확인하는 함수
        - method : intArrValidation 
        - param : int[] intArr
        - return : boolean

    6. int 배열을 List<Integer>로 반환해주는 함수
        - method : intArrToCollectionList
        - param : int[] intArr
        - return : List<Integer> 

    7. List<Integer> 안에 중복 값이 있는지 확인하는 함수
        - method : collectionListValidation
        - param : List<Integer> list
        - return : boolean

    8. 입력 값을 위 [사용자 1~6번] 항목을 거쳐 List<Integer>를 반환하는 함수
        - method : createUserNumList
        - param : String input
        - return : List<Integer>

컴퓨터
--
    1. 랜덤한 값을 뽑는 함수
        - method : getRandomNumber
        - return : int

    2. List<Integer> 안에 매개변수로 준 value 값이 있는지 확인하는 함수
        - method : collectionListCheckValue
        - param : int value, List<Integer> list
        - return : boolean

    3. List에 randomNumber를 넣는 함수
        - method :  컴퓨터 기능 함수 구현
        - param : List<Integer> list, int randomNum 
        
    4. [컴퓨터 1~2번] 항목을 통해 유효성 검사를 하여 랜덤한 3개의 중복되지 않는 값을 가진 List<Integer> 반환하는 함수
        - method : createRandomList
        - return : List<Integer>
게임
--
    1. 사용자가 입력한 값과 컴퓨터의 랜덤 값을 비교하여 동일한 값이 몇 개 있는 반환한다. 이것을 ballScore로 사용한다.
        - method : userNumListAndComNumListCheckBallCount
        - param : List<Integer> userNumList, List<Integer> computerNumList
        - return : int
        
    2. 사용자가 입력한 값과 컴퓨터의 랜덤 값을 비교하여 동일한 값이 같은 위치에 몇 개 있는 반환한다. 이것을 strikeScore로 사용한다.
        - method : userNumListAndComNumListCheckStrikeCount
        - param : List<Integer> userNumList, List<Integer> computerNumList
        - return : int

    3. 게임을 계속 할건지 확인한다.
        - method : again
        - param : String input
        - return : boolean

    4. 매개변수로 strikeScore, ballScore 를 주면 콘솔에 Score를 print해주는 함수
        - method : printScoreMsg
        - int strikeScore, int ballScore

    5. 게임 시작 시 안내 메시지를 console에 print 해주는 함수
        - method : printGameStartMsg
 
    6. 유저의 입력을 요청하는 print 함수 
        - method : printInputRequestMsg

에러
--
    1. 사용자가 입력한 값이 문제가 있을 경우 IllegalArgumentException 발생시키는 클래스 구현
        - class : UserInputException