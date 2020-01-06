### 모듈 프로젝트 1차

- 자유 주제 5개조 (4~5명 편성)

- 1월 9일 (목) 16:00 부터 발표

  프로젝트 결과물, 발표자료 별도 작성/제출



#### 조원

정용현, 강규현, 김진우, 조원상



#### 0. 목표

사용자가 원하는 키워드에 관한 정보(뉴스, 블로그, 동영상 등)을 한 페이지로 보고싶다.

그리하여.. **다나와보SHOW** 으로 명한다.



#### 1. 크롤링

> ##### Target
>
> - 썸네일URL
> - 제목
> - 설명
> - 링크URL



- 네이버 `진우`
  - **뉴스**
  - 블로그
- 다음카카오 `규현`
  - **뉴스**
  - 블로그
  - 동영상
- 티스토리
  - 블로그
- 유튜브 `규현`
  - **컨텐츠**
- 구글 `원상`
  - **뉴스**
- 블로터 뉴스 `용현`
- ZD넷 뉴스`용현`
- ...



#### 2. Spring + bootstrap template + login + DB

##### bootstrap template

https://startbootstrap.com/previews/shop-homepage/

##### User DB

- USER
  - ID
  - PW
  - EMAIL
  - KEYWORD[5]
  - Using Site

##### Crawled DB

- Contents
  - Title
  - Thumbnail
  - Description
  - Link
  - Ref. Site



##### 실시간 크롤링DB 업데이트

- Spring Boot websocket



#### 3. View page

- Keyword 크롤링 정보 표시
- 로그아웃
- 키워드별 특정 div 새로고침



#### 4. Keyword setting  page

- 키워드 추가 / 삭제
- 검색 유형 선택
- 저장
- 특정 div 새로고침



#### 5. User setting page

- 사용자 정보 수정
- 저장
- 탈퇴
- 키워드별 특정 div 새로고침



#### 6. 디버깅



#### 7. 발표 자료 준비