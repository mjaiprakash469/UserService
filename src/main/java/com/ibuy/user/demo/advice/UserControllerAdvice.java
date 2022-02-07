package com.ibuy.user.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibuy.user.demo.exception.PurchaseItenNotFoundException;

public class UserControllerAdvice {

	 @ExceptionHandler(PurchaseItenNotFoundException.class)
		public ResponseEntity<String> emtyHandler(PurchaseItenNotFoundException purchaseItenNotFoundException){
			return new ResponseEntity<String>("Invalid Username or Password", HttpStatus.BAD_REQUEST);
		}

}
