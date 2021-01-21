package com.cos.springboot.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.service.PostService;

//클라이언트 http 요청시에 @Controller, @RestController가 붙은 클래스가 메모리(IoC Container)에 로딩

@Controller
public class PostController {
	
	//DI (Dependency Injection                                               @Autowired랑 같은효과
	private PostService postService;
	
	public PostController(PostService postService) {
this.postService = postService;
	}
	
	
	// Model 객체 제공
	@GetMapping("/post") //응답을 뭘로할지 데이터 타입을 결정한다. // text/plain으로 응답한다 json이면 json
	public String findAll(Model model) { // 컨트롤러의 함수의 파라메터는 톰켓이 가지고 있는 객체 + IoC컨테이너가 가지고 있는 객체
		//1. DB에 데이터 가져오기
		//2. request 값 담기
		List<Post> posts = postService.글목록();
		model.addAttribute("posts",posts);
		System.out.println(posts);
		return "post/list"; 		//3. RequestDispathcer 사용 //
	}
	
	@GetMapping("/post/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.글상세보기(id));
		return "post/detail";
	}
	
	@PostMapping("/post")
	public String save(Post post) {//x-www-form-urlencoded
		System.out.println("post : " + post);
		
		Post postEntity = postService.글저장(post);
		System.out.println(postEntity);
		return "redirect:/post"; //response.sendRedirect
	}
}