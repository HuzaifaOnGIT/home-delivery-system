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
import com.te.hds.dto.DeliveryPersonDto;
import com.te.hds.dto.ResponseMessage;
import com.te.hds.dto.UserDto;
import com.te.hds.entity.DeliveryPerson;
import com.te.hds.entity.User;
import com.te.hds.service.HomeDeliveryService;

@RestController
public class HomeDeliveryController {
	
	@Autowired
	private HomeDeliveryService service;
	
	@PostMapping("/user/add")
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

	@PostMapping("/user/update")
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
	
	@PostMapping("/user/get/{id}")
	public ResponseEntity<ResponseMessage> getUser(@PathVariable Integer id) {

		User addUser = service.getUser(id);
		if (addUser != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, addUser);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Integer id) {

		service.deleteUser(id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false, UserConstant.DELETE_SUCCESS, null),
				HttpStatus.OK);
	}

	@PostMapping("/delivery-person/add")
	public ResponseEntity<ResponseMessage> addDeliveryPerson(@RequestBody DeliveryPersonDto dto) {

		DeliveryPerson addDeliveryPerson = service.addDeliveryPerson(dto);
		if (addDeliveryPerson != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, addDeliveryPerson);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, addDeliveryPerson);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/deliveryperson/update")
	public ResponseEntity<ResponseMessage> updateDeliveryPerson(@RequestBody DeliveryPersonDto dto) {

		DeliveryPerson updateDeliveryPerson = service.updateDeliveryPerson(dto);
		if (updateDeliveryPerson != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, updateDeliveryPerson);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, updateDeliveryPerson);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/delivery-person/get/{id}")
	public ResponseEntity<ResponseMessage> getDeliveryPerson(@PathVariable Integer id) {
		
		DeliveryPerson updateDeliveryPerson = service.getDeliveryPerson(id);
		if (updateDeliveryPerson != null) {
			ResponseMessage responseMessage = new ResponseMessage(false, UserConstant.ADD_SUCCESS, updateDeliveryPerson);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			ResponseMessage responseMessage = new ResponseMessage(true, UserConstant.ADD_FAIL, updateDeliveryPerson);
			return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
		}
	}

}
