package kr.co.work;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	UserDAO userDao;
	
	@GetMapping("/login")
	public String loginForm()
	{
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		//id와 pw 확인
		if(!loginCheck(id, pwd))
		{
			//일치하지 않으면 로그인폼으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg=" + msg;
		}
		
		//2. 쿠키
		
		if(rememberId)
		{
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		}
		
		else
		{
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		//3. 세션
		HttpSession session = request.getSession();
		//세션 id를 저장
		session.setAttribute("id",  id);
		
		//4. 뷰이동
		toURL = toURL == null || toURL.equals("")? "/" : toURL;
		//일치하면 로그인 후 화면(홈화면)으로 이동
		return "redirect:" + toURL;
	}
	
	private boolean loginCheck(String id, String pwd)
	{
		User user = userDao.selectUser(id);
		if(user==null) return false;
		return user.getUser_pw().equals(pwd);
	}
	
	@GetMapping("/logout")
	private String logout(HttpSession session)
	{
		//세션 종료
		session.invalidate();
		return "redirect:/";
	}

}
