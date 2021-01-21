package com.cos.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.domain.post.PostRepository;

@Service // 서버 실행시에 IoC에 등록
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post 글저장(Post post) {
		Post postEntity = postRepository.save(post); //Insert수행수 Insert한 행을 바로 가져와줌
		return postEntity;
	}
	
	public List<Post> 글목록(){
		return postRepository.findAll();
	}
	
	public Post 글상세보기(int id) {
		return postRepository.findById(id).get();
	}

}
