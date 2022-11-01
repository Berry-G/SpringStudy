package kr.co.work;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController
{
	@Autowired
	UserDAO userDao;
	

	final int FAIL = 0;

	// @RequestMapping대신에 @GetMapping,@PostMapping 사용 가능(데이터를 적게 먹음)

//	@RequestMapping(value="/register/add2", method = {RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping(value="/register/add2")
	@GetMapping("/add") // Get방식만 쓸 경우
	public String register()
	{
		return "registerForm"; // \webapp\WEB-INF\views\registerForm.jsp
	}

	@InitBinder
	public void registerValidate(WebDataBinder binder)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		// UserValdiator를 WebDataBinder의 로컬 validator로 등록(수동)
		binder.setValidator(new UserValidator());
	}

	@PostMapping("/add")
	public String save(@Valid User user, BindingResult result, Model m) throws UnsupportedEncodingException
	{
		// 1. 유효성 검사 => 관심사로 분리
		System.out.println("result = " + result);
		System.out.println("user = " + user);

		// 2. DB에 새 회원 정보를 저장
		// User 객체를 검증한 결과 에러가 있으면 (필수입력 미기재, ...), registerForm을 이용해 에러를 보여주어야 함
		if(!result.hasErrors())
		{

			int rowCnt = userDao.insertUser(user);
			if(rowCnt != FAIL)
			{

				return "registerInfo";
			}

		}
				return "registerForm";
	}

	private boolean isValid(User user)
	{
		// 현재 유효하지 못하게 false로 설정함
		return false;
	}

	public String save(User user)
	{
		return "registerInfo"; // \webapp\WEB-INF\views\registerInfo.jsp
	}
}
