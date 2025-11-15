package com.application.inventApp.Controller.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseOK {

  private String message;
  private List<String> data;

  public ResponseOK(String message) {
    this.message = message;
  }

  public ResponseOK(List<String> data) {
    this.data = data;
  }


  @Override
  public String toString() {
    return "ResponseOK{" +
        "message='" + message + '\'' +
        '}';
  }

}
