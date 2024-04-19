package com.example.demo.Service;

import lombok.Data;

@Data
public class ResponseStructure{
private String msg;
private boolean status;
public ResponseStructure() {

}
public ResponseStructure(String msg, boolean status) {
	super();
	this.msg = msg;
	this.status = status;
}


}
