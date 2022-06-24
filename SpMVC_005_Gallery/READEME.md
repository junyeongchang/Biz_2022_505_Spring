

* 파일 업로드를 구현하기 위하여 별도의 디펜던시 를 가져오기
```
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
```

## 파일 업로드를 위한 bean 설정
* 파일 업로드를 위한 bean은 root-context.xml 에 작성한다.
* 	<!-- Root Context: defines shared resources visible to all other web components -->
	<!-- 
	여기는 프로젝트 전반에서 component(controller, Service, Dao) 와 함께
	다양한 package 의 클래스들이 공통으로 사용할 bean을 설정하는 부분
	여기에 작성하는 bean 중에 대표적인 부분이 파일 업로드와 관련된 bean
	 -->

	 한개의 파일 업로드 제한 용량
	 여러개의 파일을 업로드 할때 전체 제한 용량

## Upload를 위한 form 설정
```
	<form method="post" class="bbs_write" enctype="multiipart/form-data">
```
* 파일 업로드를 하기 위해서는 form tag의 method 를반드시 POST로 설정해야 한다.