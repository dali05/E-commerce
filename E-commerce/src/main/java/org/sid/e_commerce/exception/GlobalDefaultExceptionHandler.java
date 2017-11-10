package org.sid.e_commerce.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice 
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		ModelAndView mv = new  ModelAndView("error");
		mv.addObject("errorTitle","the page is not constructed");
		mv.addObject("errorDescription","the page you are looking for is not available now");
		mv.addObject("title","404 Error page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundExeption.class)
	public ModelAndView handlerProductFoundException(){
		ModelAndView mv = new  ModelAndView("error");
		mv.addObject("errorTitle","product not available");
		mv.addObject("errorDescription","the product you are looking for is not available now");
		mv.addObject("title","product unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		ModelAndView mv = new  ModelAndView("error");
		mv.addObject("errorTitle","contact your administrator");
		mv.addObject("errorDescription",ex.getCause());
		mv.addObject("title","Error");
		return mv;
	}
}
