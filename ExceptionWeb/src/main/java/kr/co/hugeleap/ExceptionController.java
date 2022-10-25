package kr.co.hugeleap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController
{
	@RequestMapping("/ex")
	public void ezen(Model m) throws Exception
	{
		
	}
	
	@RequestMapping("/ex2")
	public String ezen2(Model m) throws Exception
	{
		try
		{
			throw new Exception("예외가 발생했습니다.");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping("/ex3")
	public String ezen3(Model m) throws Exception
	{
		throw new NullPointerException("널포인트 예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex4")
	public void ezen4(Model m) throws Exception
	{
		try
		{
			throw new Exception("예외가 발생했습니다.");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
