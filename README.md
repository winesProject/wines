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
  내용
<br/>
</details>
<details>
<summary>💥 서정헌 </summary>
  내용
<br/>
</details>
<details>
<summary>💥 박유진 </summary>
 1. </br>
   
```문제``` 로그인하고 리뷰를 작성하면 DB에 작성자가 담기지 않았고 그래서 화면에도 뜨지 않았다.
   </br>
   
```해결``` MEMBER 이름 변수명을 nickname에서 username으로 변경해주었다.
  </br>
```문제``` 윈도우와 맥의 이미지 폴더 경로가 달라서 이미지 업로드가 되지 않았다. 

</br>

```해결``` File Handler에서 절대 경로를 재설정해주고 윈도우와 맥의 이미지 경로를 다르게 각각 작성했다.

<br/>
</details>
