# 🍷 wine's
- Wine's는 와인을 좋아하고 관심있는 사람들이 모여 정보를 공유할 수 있는 웹사이트입니다.
<p align="center"><img width="700" src="https://github.com/winesProject/wines/assets/133175842/38a04926-d61b-4ceb-893c-c65b0d799f79"></p>

## 1. 프로젝트 소개
### [기획배경]
> 실제로 와인을 마셔본 사람들의 맛 평가와 먹어봤을때 어울리는 음식 등 이러한 리뷰들을 통해 </br>와인을 잘 알지못하는 사람들도
> 와인을 쉽게 접하며 즐길수 있도록 하면 어떨까? 라는 생각이 들어 프로젝트를 기획하게되었습니다.
</br>

## 🕰️ 프로젝트 기간
2023-12-08 ~ 2024-01-05
<br>

## 2. 프로젝트 구조
```
   src
    ├── main
    │   ├── generated
    │   ├── java
    │   │   └── com
    │   │       └── std
    │   │           └── sbb
    │   │               ├── domain
    │   │               │   ├── answer
    │   │               │   │   ├── controller
    │   │               │   │   ├── entity
    │   │               │   │   ├── form
    │   │               │   │   ├── repository
    │   │               │   │   └── service
    │   │               │   ├── email
    │   │               │   │   ├── controller
    │   │               │   │   └── service
    │   │               │   ├── member
    │   │               │   │   ├── controller
    │   │               │   │   ├── entity
    │   │               │   │   ├── form
    │   │               │   │   ├── repository
    │   │               │   │   └── service
    │   │               │   ├── question
    │   │               │   │   ├── controller
    │   │               │   │   ├── entity
    │   │               │   │   ├── form
    │   │               │   │   ├── repository
    │   │               │   │   └── service
    │   │               │   ├── review
    │   │               │   │   ├── controller
    │   │               │   │   ├── entity
    │   │               │   │   ├── form
    │   │               │   │   ├── repository
    │   │               │   │   └── service
    │   │               │   ├── taste
    │   │               │   │   ├── entity
    │   │               │   │   ├── form
    │   │               │   │   ├── repository
    │   │               │   │   └── service
    │   │               │   └── wine
    │   │               │       ├── controller
    │   │               │       ├── entity
    │   │               │       ├── form
    │   │               │       ├── repository
    │   │               │       ├── searchType
    │   │               │       └── service
    │   │               └── global
    │   │                   ├── imagesfile
    │   │                   │   ├── config
    │   │                   │   ├── controller
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   ├── initDate
    │   │                   ├── jpa
    │   │                   ├── rq
    │   │                   ├── security
    │   │                   └── standard
    │   │                       └── utill
    │   └── resources
    │       ├── static
    │       │   └── images
    │       └── templates
    └── test
        └── java
            └── com
                └── std
                    └── sbb

```
## 3. 개발환경
<div align="center">
<p style="font-size:20px;">💻 Tech Stack 💻</p>
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white"/>
<img src="https://img.shields.io/badge/Tailwindcss-06B6D4?style=flat&logo=Tailwindcss&logoColor=white"/>
<img src="https://img.shields.io/badge/JavaScript-f7df1e?style=flat&logo=JavaScript&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white"/>
<br/>
<img src="https://img.shields.io/badge/mariadb-003545?style=flat&logo=mariadb&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479a1?style=flat&logo=mysql&logoColor=white"/> 
<img src="https://img.shields.io/badge/Springboot-6DB33F?style=flat&logo=Springboot&logoColor=white"/>

<br/>
<br/>
  
<p style="font-size:20px;">🛠 Tools 🛠</p>
<img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&181717=white"/>
<img src="https://img.shields.io/badge/intellijidea-000000?style=flat&logo=intellijidea&logoColor=white">
<img src="https://img.shields.io/badge/dbeaver-382923?style=flat&logo=dbeaver&logoColor=white">
</div>

## 4. ERD 설계
<p align="center"><img width="900" src="https://github.com/winesProject/wines/assets/133175842/34e4b2cd-c5a7-4591-9a34-5d633dfe5956"></p>

## 5. 시연 영상

## 6. 트러블 슈팅
<details>
<summary>💥 최경현 </summary>
    </br>
   
  #### <1> </br>   <b>이미지 업로드</b>

```문제``` 이미지 업로드와 동시에 변환을 시키는데 경로 설정, 파일 변경, 전송 실패 등등.. 여러 문제가 발생하였다. 이미지 업로드 트러블을 해결하기 위해서 디버깅 및, 검색을 이용해 문제를 해결하였다.
</br>
```해결``` Ex )enctype="multipart/form-data" 문제나 public void addResourceHandlers(ResourceHandlerRegistry registry) 파일에서의 경로 설정 혹은, file handler에서의 파일 저장 방법 등.. 을 이용하여 여러 문제를 해결하였다.

 #### <2> </br>  <b>소셜 로그인</b>

```문제``` 소셜 로그인을 진행 하면서 application 설정오류 및 여러 문제가 발생하였다.
</br>
```해결``` application과 notprod를 잘 비교하면서 수정하였고, 문제를 해결하였다.

 #### <3> </br> <b>찜 목록 구현</b>

```문제``` 찜 목록을 구현하면서, 찜을 하는 순간 데이터가 전송이 안되는 문제와, 찜을 한 유저일 경우 찜한 상태가 유지되도록 구현하는데 문제, 나의 찜 목록에서 찜을 삭제했을 때 바로 목록이 사라지지 않는 문제가 생겼다.
</br>
```해결``` 스크립트가 html에 전송이 되지않아서 클릭이 안되는 문제를 html안에 직접 넣어줌으로써 해결하였고, 데이터가 전송이 안되는 문제는 스크립트에서 csrf토큰을 같이 전송시켜 주면서 문제를 해결하였으며, 찜한 상태를 유지시키기 위해 클릭하거나 접속할 때 마다 로그인한 회원을 비교하기 위해 entity에 클릭할 때마다 비교하기 위한 생성자 함수를 만들어서 html에서 타임리프를 사용하여서 문제를 해결하였고, 찜 목록을 삭제시키기 위해 찜을 받는 리스트의 id값을 갖고와서 해당 목록을 삭제한 리스트를 가져오는 구문을 controller에 새로 하나 만들었고, 스크립트에서 replaceWith구문을 사용하여 삭제된 해당 리스트를 다시 불러오는 식으로 문제를 해결하였다.

 #### <4> </br> <b>이메일 전송 구현</b>

```문제``` 이메일 전송을 구현하면서, 전송이 안되는 문제와, 전송은 되더라도 메일로 안받아 지는 문제 등.. 을 겪었다.
</br>
```해결``` 이메일 전송이 안되는 문제는 application에서 메일 설정을 잘못 하여서 전송이 안되었었다. 그래서 전송시키는 주최자 메일을 설정하여서 문제를 해결하였으며, 전송이 안되는 문제는 전송 시키기 전에 일단 회원가입 시 해당 메일로 회원가입이 완료되었다는 구문을 발송시키면서 예비작업을 완료하였으며, 그 다음에는 이메일로 인증을 시키기 위하여 이메일 등록을 하면은 해당 이메일로 랜덤 인증번호를 발송 시키기 위해 스크립트로 구현을 하였으며, 해당 인증번호를 받으면서 정확하게 입력하였을때, 회원가입이 진행되게 하도록 구현하였다.

#### <5> </br> <b>카테고리 구현</b>

```문제``` 카테고리를 구현하는 중에 저장된 wine값을 불러오기 위한 과정에서 문제가 많았으며, 카테고리가 되더라도 페이징이 안되는 문제를 겪었다.
</br>
```해결``` 카테고리를 구현하면서 페이징을 적용 시키기 위해 원래 wine리스트에서 페이징을 하는 곳에 직접적으로 불러오면서 동시에 null일 경우를 같이 처리하면서 문제를 해결하였다. 서비스에서 경우의 수를 만들어서 레포지토리에서 호출하였으며, 레포지토리에서는 쿼리문을 이용하여 값을 받아올 수 있도록 구현하였다. 구현은 하여도 페이징이 되지 않았었는데, 페이징을 시키기 위해서 html에서 GET형식으로 값을 요청하면서 파라미터에 직접 값을 추가해주면서 페이징을 구현시켰다.

#### <6> </br> <b>wine의 4/4분면 구현</b>

```문제``` wine자체 내에서 4/4분면 값을 저장시키는 도중에 문제가 많이 발생하였다.
</br>
```해결``` 문제를 해결하기 위해 이 값을 받는 entity를 따로 만들었으며, 라디오 버튼 값을 유지시키기 위해 유지시키는 스크립트 구문을 html에 추가하였다, 그리고 html의 복잡성을 해결하기 위해 4/4분면 라디오 버튼 html파일을 따로 만들었으며, 그 값을 불러오기 위해 id값과 name값을 따로 설정하였다.
<br/>
</details>
<details>
<summary>💥 서정헌 </summary>
  (https://velog.io/@jayjhseo/Wines-%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85)
<br/>
</details>
<details>
<summary>💥 박유진 </summary>
   </br>
   
  #### <1> </br>   
```문제``` 로그인하고 리뷰를 작성하면 DB에 작성자가 담기지 않았고 그래서 화면에도 뜨지 않았다.
 </br>
   
```해결``` MEMBER entity의 이름 변수명을 nickname에서 username으로
전부 변경해주고 원래 form에 builder를 사용했었는데 Getter와
Setter만 남기고 </br>다 삭제했다. 또 review entity에 있는 wine과
member를 manytoone으로 관계설정을 했는데 여기서 (fetch = FetchType.LAZY)를 넣어줌으로 필요할때만 가지고 와서 쓸 수 있도록 설정해주었다.

  </br>
  
  #### <2> </br>
```문제``` 윈도우와 맥의 이미지 폴더 경로가 달라서 이미지 업로드가 되지 않았다. 
</br>

```해결``` File Handler에서 절대 경로를 재설정해주고 윈도우와 맥의 이미지 경로를 각각 작성했다.
<br/>

</details>
