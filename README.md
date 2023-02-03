# 1. 프로젝트 명
classicgame을 플레이할 수 있는 사이트 만들기

# 2. 설명
* main page
* ![main](https://user-images.githubusercontent.com/105897325/216531546-6c0a1eb3-62d1-401a-9100-d0de4bafd35e.png)
  * 로그인 또는 회원가입 버튼을 누르면 signUp.html 또는 login.html으로 이동
  * 게임 아이콘을 누르면 해당 게임의 page로 이동
    * 여러 아이콘이 존재하지만 실제로 가능한 게임은 tetris, 2048, snake 3가지

* login page
* ![login](https://user-images.githubusercontent.com/105897325/216531626-d4bda4dc-a234-46a8-9e44-d3f8af85eaf3.png)
* ![classicgame rest api](https://user-images.githubusercontent.com/105897325/216531682-2f2e8318-f65d-4744-aacf-fabf09bac091.png)
  * 로그인 페이지의 가독성과 관리, 보수를 수월하게 하기 위해 css와 js를 분리
  * restful api를 사용하여 다른 팀원과 개발 시 혼선을 줄임
* user table
* ![user](https://user-images.githubusercontent.com/105897325/216531721-86aadcb4-f72d-4674-8451-5b4be37765b1.png)
  * @Entity를 사용해 해당 클래스를  jpa로 관리
  * id에 @Id를 붙여 pk(primary key)로 선언
* UserServiceImpl
* ![service 기능](https://user-images.githubusercontent.com/105897325/216531765-911c4772-c682-4e34-9678-6afd7a4f2c1f.png)
  * @Service : 캡슐화 없이 모델 내 단독 인터페이스로써 제공되는 동작을 의미
  * getUser method : 입력받은 정보 중 id값을 추출 후 db에 동일한 id값이 존재하는지 확인
    * 만약 존재한다면 해당 id의 정보를 반환
    * 존재하지 않는다면 null값을 반환
  * insertUser method : 유저의 정보를 저장하는 메소드
    * getUser method에 id값을 전송 후 받은 값이 null이면 저장, null이 아니면 실패
* UserController
* ![classicgame login controller](https://user-images.githubusercontent.com/105897325/216531836-5db14a49-7b06-4543-836c-9155e22a1094.png)
  * @RestController : @Controller + @ResponseBody 가 합쳐진 형태로 Json 형태로 객체 데이터를 반환
  * @PostMapping("/login") : login page에서 post방식으로 login action을 요청을 보냈고 이를 받아 수행하기 위해 사용
  * userService의 getUser에 데이터를 넣어 정보를 받아 findUser에 저장
    * findUser가 null이면 db에 해당 id의 정보가 없다는 의미
    * findUser의 데이터 중 pw에 관한 정보가 입력받은 정보의 pw와 동일하다면 입력이 올바르다는 의미
    * 둘 중 하나 이상이 성립이 안된다면 로그인 불가

* 게임 page
  * 코드의 가독성과 관리, 보수를 수월하게 하기 위해 html, css, js로 분리
  * 게임 종료 시 alert로 점수 알림 후 main page로 이동

# 3. 느낀점
수업 때 배운 내용을 활용하여 원하는 프로젝트를 진행하기 때문에 어려움 없을것이라 생각하였지만 필요 기능을 생각하고 코드를 구현하는 과정에서 많은 시행착오를 겪어 자신의 어리석음을 깨닫게 되었다.

# 4. 앞으로의 목표
user의 pw를 저장할 때 변형작업 없이 그대로 저장을 하여 보안이 상당히 취약하다는 단점이 있다.
spring security를 사용하여 pw를 변환 후 저장하는 방법을 공부 후 적용하여 보안을 강화해야겠다.
