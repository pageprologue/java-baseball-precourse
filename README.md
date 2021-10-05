# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항

### 게임 설명

숫자 야구 게임은 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

### 기능 목록

* 야구공(Ball)
    - [x] 랜덤한 숫자로 야구공을 생성한다.
    - [x] 입력받은 숫자로 야구공을 생성한다.
    - [x] 야구공 숫자가 1 ~ 9 사이의 값이 아니면 예외가 발생한다.

* 한 회차의 야구공(Balls)
    - [x] 랜덤으로 중복되지 않는 3개의 야구공을 생성한다.
    - [x] 입력받은 값으로 중복되지 않는 3개의 야구공을 생성한다.
    - [x] 야구공의 숫자가 중복되거나 야구공의 개수가 3개가 아닌 경우 예외가 발생한다.

* 플레이어(Player)
    - [x] 랜덤으로 중복되지 않는 3개의 야구공을 가진 투수(Pitcher)를 생성한다.
    - [x] 입력받은 값으로 중복되지 않는 3개의 야구공을 가진 타자(Batter)를 생성한다.
    - [x] 입력받은 값으로 타자의 야구공을 변경한다.

* 회차(Inning)
    - [x] 플레이어를 초기화 한다.
    - [x] 야구공 숫자를 입력받아 타자의 야구공을 변경한다.
    - [x] 투수와 타자의 야구공 숫자를 비교하여 득점 결과를 계산한다.
    -
* 득점 결과(Score)
    - [x] 같은 수가 같은 자리에 있으면 스트라이크이다.
    - [x] 같은 수가 다른 자리에 있으면 볼이다.
    - [x] 같은 수가 전혀 없으면 낫싱이다.

* 야구 게임(BaseballGame)
    - [x] 타자와 투수의 야구공을 회차를 비교하여 득점 결과를 산출한다.
    - [x] 타자가 투수의 야구공 숫자를 모두 맞히면(3스트라이크) 게임이 종료된다.

* 게임 상태
    - [x] 게임 상태가 Ready 일 때 게임을 시작할 수 있다.
    - [x] 게임 상태가 Start 또는 Playing 일 때 게임을 진행할 수 있다.
    - [x] 게임 상태가 Start 또는 Playing 일 때 게임을 종료할 수 있다.
    - [x] 게임 상태가 Finish 일 때 게임을 다시 시작(준비)할 수 있다.

* 입력
    - [x] 사용자는 타자로써 3개의 숫자를 입력한다.
    - [x] 다시 게임을 시작하거나 게임을 완전히 종료하기 위해 1 또는 2를 입력한다.
    - [x] 입력 값이 올바르지 않은 경우, 다시 입력을 받는다.

* 출력
    - [x] 입력을 위한 안내 메시지를 출력한다.
    - [x] 득점 결과를 출력한다.
    - [x] 입력 값이 올바르지 않은 경우, [ERROR]로 시작하는 에러 메시지를 출력한다.
