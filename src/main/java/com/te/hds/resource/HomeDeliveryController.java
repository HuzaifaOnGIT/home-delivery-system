package com.te.hds.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.hds.UserConstant;
import com.te.hds.dto.ResponseMessage;
import com.te.hds.dto.UserDto;
import com.te.hds.entity.User;
import com.te.hds.service.HomeDeliveryService;

@RestController
public class HomeDeliveryController {
	
	@Autowired
	private HomeDeliveryService service;
	
	@PostMapping("/batch/add")
	public ResponseEntity<ResponseMessage> addUser(@RequestBody UserDto userDto) {

		User addUser = service.addUser(userDto);
		if (addUser != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/batch/add")
	public ResponseEntity<ResponseMessage> updateUser(@RequestBody UserDto userDto) {

		User addUser = service.updateUser(userDto);
		if (addUser != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/batch/add")
	public ResponseEntity<ResponseMessage> getUser(@RequestBody UserDto userDto) {

		User addUser = service.getUser(userDto);
		if (addUser != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/batch/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Long id) {

		service.deleteUser(id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false, UserConstant.DELETE_SUCCESS, null),
				HttpStatus.OK);
	}


}
