package com.cos.springboot.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository 생략 가능
public interface PostRepository extends JpaRepository<Post, Integer> { //테이블명, 기본키 자료형

}
