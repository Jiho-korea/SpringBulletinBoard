package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBulletinBoard.exception.NonExistentPageException;
import springBulletinBoard.service.PostListService;
import springBulletinBoard.vo.BoardRequest;
import springBulletinBoard.vo.Post;

@Controller
public class BoardController {
	PostListService postListService;

	public void setPostListService(PostListService postListService) {
		this.postListService = postListService;
	}

	@RequestMapping("/board/list")
	public String boardList(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "title", required = false) String title, Model model) {
		boolean nextPage = false;
		nextPage = postListService.nextPage(pageNumber);

		try {
			BoardRequest boardRequest = new BoardRequest(pageNumber, title);
			List<Post> postList = postListService.postList(boardRequest);
			model.addAttribute("pageNumber", pageNumber);
			model.addAttribute("nextPage", nextPage);
			model.addAttribute("postList", postList);
			return "board/boardPage";
		} catch (NonExistentPageException e) {
			e.printStackTrace();
			return "redirect:/main";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main";
		}
	}
}
