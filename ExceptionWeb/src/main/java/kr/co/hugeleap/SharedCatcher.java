package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SharedCatcher
{
//	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String catcher(Exception ex, Model m)
	{
		System.out.println("cather() in SharedCatcher");
		System.out.println("m = " + m.getAttribute("msg"));
		
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String catcher2(Exception ex, Model m)
	{
		m.addAttribute("ex", ex);
		return "error";
	}

}
