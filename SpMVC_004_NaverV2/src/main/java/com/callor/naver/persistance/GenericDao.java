package com.callor.naver.persistance;

import java.util.List;

/*
 * SpringMVC 패턴의 프로젝트에서 DBMS와 연동을 할때는
 * 기능별로 최소한의 CRUD를 구현해야 한다.
 * 각 기능의 Service, Dao interface 에는 다음에 구현한 5가지 method가
 * (거의)반드시 필요하다.
 * 기본 5가지 CRUD 외에 업무별로 필요한 method가 있겠지만
 * 기본 5가지 CRUD 코드를 반복하여 interface 에 작성하는 것은
 * 프로젝트가 커졌을때 상당히 많은 코딩을 해야하는 문제가 있다.
 * 
 * 그래서 Service, Dao interface를 구현할때 공통으로 사용할 
 * parents interface를 생성하고
 * 기본 CRUD method는 상속받아서 사용하도록 구현한다.
 * 
 * Service, Dao interface 에는 VO 클래스와, Primary Key 칼럼의 데이터타입이 
 * 모두 다르게 포함된다.
 * 
 * 상속받을 interface 에서 자신의 VO클래스와 Primary Key 칼럼의 데이터 타입을
 * 지정할수 있도록 Generic type의 interface로 구현해 놓는다.
 * 
 * 여기에서 선언하는 Generic type이란
 * 아직 구현되지 않은 임의의 type이며
 * 이 interface를 상속받아 구현할때 비로소 구체화 된다.
 * 
 */
public interface GenericDao<V, P> {

	public List<V> selectAll();

	public V findById(P id);

	public int insert(V vo);

	public int update(V vo);

	public int delete(P id);

}
