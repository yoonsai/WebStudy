package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/*
 *  찾기용도
 *  구분자(Annotation) 다른 프로그램에게 유용한 정보를 제공하기 위해 사용되는 것으로, "주석"과 같은 의미를 가짐
 *  = 찾기 => 인덱스
 *  = if문과 동일
 *  => 어노테이션 => 위에 존재 
 *  
 *  @         @
 *  class A   class B
 *  
 *  class A
 *  {
 *     @RequestMapping("a") => 요청값이 a라면 => aaa()메소드 호출
 *     aaa()
 *     @RequestMapping("b") 
 *     bbb()
 *     @RequestMapping("c") 
 *     ccc()
 *     
 *  }
 * 
 */
@Retention(RUNTIME)
//저장 기간
/*
 *  RUNTIME
 *  ======= 프로그램 종료 시까지 유지
 *  SOURCE
 *  CLASS
 *  ======= 컴파일 후에 자동으로 메모리 해제
 */
@Target(METHOD)
// 찾기 => 찾는 구분자
/*
 *  TYPE ==> class
 *  METHOD => method
 *  FIELD => 멤버변수
 *  PARAMETER => 매개변수
 *  CONSTRUCTOR => 생성자
 *  
 *  @ => TYPE
 *  class A
 *  {
 *     @ => FIELD
 *     B b=new B();
 *     
 *     public void display(){}
 *     
 *     @ => CONSTRUCTOR
 *     A()
 *     
 *     public void aaa(@ => PARAMETER B b)
 *  }
 *  
 *  @RequestMapping("경로") => value를 이용해서 경로를 찾기
 */
public @interface RequestMapping {
	public String value();
}
