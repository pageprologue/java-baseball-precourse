# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항 
### 게임 설명
숫자 야구 게임은 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

### 기능 목록
* 야구공(Ball)
  - [ ] 야구공 숫자는 1 ~ 9 까지 서로 다른 임의의 숫자이다.
  - [ ] 야구공 숫자가 1 ~ 9 사이의 값이 아니면 예외가 발생한다.
  
* 회차(Inning)
  - [ ] 3개의 야구공을 갖는 회차를 생성한다.
  - [ ] 야구공의 숫자가 중복이거나 야구공의 개수가 3개가 아닌 경우 예외가 발생한다.

* 투수(Pitcher)
  - [ ] 투수(컴퓨터)인 경우, 자동으로 회차를 생성한다.

* 타자(Batter)
  - [ ] 타자(사용자)인 경우, 수동으로 회차를 생성한다.
  
* 득점 결과(InningScore)
  - [ ] 투수와 타자의 야구공 숫자를 비교한다.
    - [ ] 같은 수가 같은 자리에 있으면 스트라이크이다.
    - [ ] 같은 수가 다른 자리에 있으면 볼이다.
    - [ ] 같은 수가 전혀 없으면 낫싱이다.
    
* 야구 게임(BaseballGame)
  - [ ] 타자와 투수의 회차를 비교하여 득점 결과를 산출한다.
  - [ ] 타자가 투수의 야구공 숫자를 모두 맞히면(3스트라이크) 게임이 종료된다.

* 입력 
  - [ ] 사용자는 타자로써 3개의 숫자를 입력한다.
  - [ ] 다시 게임을 시작하거나 게임을 완전히 종료하기 위해 1 또는 2를 입력한다.
  - [ ] 입력 값이 올바르지 않은 경우, 다시 입력을 받는다.

* 출력
  - [ ] 입력을 위한 안내 메시지를 출력한다.
  - [ ] 득점 결과를 출력한다.
  - [ ] 입력 값이 올바르지 않은 경우, [ERROR]로 시작하는 에러 메시지를 출력한다.
