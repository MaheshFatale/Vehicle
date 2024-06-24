package in.mahesh.exceptionhandler;

import org.slf4j.LoggerFactory;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	private org.slf4j.Logger logger=LoggerFactory.getLogger(AppExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public String handleAE(Exception ae)
	{
		String msg=ae.getMessage();
		logger.error(msg);
		return "errorPage";
	}
}
