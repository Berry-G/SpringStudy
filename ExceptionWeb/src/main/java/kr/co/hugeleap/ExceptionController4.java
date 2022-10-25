package kr.co.hugeleap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ExceptionController4
{
	@RequestMapping("/ex5")
	public void ezen(Model m) throws Exception
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
	
	@RequestMapping("/ex6")
	public String ezen2(Model m) throws Exception
	{
			throw new Exception("예외가 발생했습니다.");

	}
	
	@RequestMapping("/ex7")
	public String ezen3(Model m) throws Exception
	{
		throw new NullPointerException("널포인트 예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex8")
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
