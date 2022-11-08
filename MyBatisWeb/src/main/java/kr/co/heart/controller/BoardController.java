package kr.co.heart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.PageResolver;
import kr.co.heart.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController
{
	@Autowired(required = false)
	BoardService boardService;

	@GetMapping("/read")
	public String read(Integer bno, Model m)
	{
		try {
			BoardDto boardDto = boardService.read(bno);
			
			m.addAttribute(boardDto);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "redirect:/board/list";
		}
		return "board";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer pageSize,
			Model m,
			HttpServletRequest request)
	{
		if(!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		try {
			int totalCnt = boardService.getCount();
			m.addAttribute("totalCnt", totalCnt);
			
			PageResolver pageResolver = new PageResolver(totalCnt, page, pageSize);
			if(page < 0 || page > pageResolver.getTotalCnt())
				page = 1;
			if(pageSize < 0 || pageSize > 50)
				page = 10;
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
			
			List<BoardDto> list = boardService.getPage(map);
			
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return "boardList";	//로그인한 상태, 게시판 목록 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request)
	{
		//1. 세션을 얻어서
		HttpSession session = request.getSession(false);
		//2. session에 id가 있는지 확인, 있으면 true 반환
		return session != null && session.getAttribute("id")!=null;
	}
}
