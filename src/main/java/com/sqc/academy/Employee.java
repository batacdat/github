package com.sqc.academy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;




@Setter
@Getter
@NoArgsConstructor  //tạo constructor ko có tham số
@AllArgsConstructor //tạo constructor có tham số
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)  // tất cả các trường của class sẽ có access level là private
public class Employee {

    int id;
    String name;
    LocalDate birthday;
    String sex;
     Float salary;


}














