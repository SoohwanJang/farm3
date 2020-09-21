package com.farm.web.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExamplException {

	private final static String EXCEPTION_HANDLER = "EXCEPTION_HANDLER";

	@ResponseBody

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> methodArgumentTypeMismatchException(HttpServletRequest request,
			HttpServletResponse response, MethodArgumentTypeMismatchException e) {

		return makeExceptionAttribute(request, HttpStatus.BAD_REQUEST, e, null);

	}

	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView sqlException(HttpServletRequest request, HttpServletResponse response, SQLException e) {

		makeExceptionAttribute(request, HttpStatus.INTERNAL_SERVER_ERROR, e, null);

		return new ModelAndView("/error/error");
	}

	private Map<String, Object> makeExceptionAttribute(HttpServletRequest request, HttpStatus status, Exception e,
			String message) {

		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append(e.getMessage());
		if (message != null) {
			errorMessage.append("<br>").append(message);
		}

		map.put("errorCode", status.value());
		map.put("errorCodeString", status.getReasonPhrase());
		map.put("errorClass", e.getClass().getName());
		map.put("errorMessage", e.getMessage());

		if (request != null) {
			request.setAttribute(EXCEPTION_HANDLER, map);
		}
		return map;
	}
}
