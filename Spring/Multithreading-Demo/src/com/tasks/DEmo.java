package com.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Student
{
	private int id;
	private String name;
	
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public Student(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
}
class SortByid implements Comparator<Student>
{
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}
}
class SortByName implements Comparator<Student>
{
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
}

public class DEmo {
	
	public static void main(String...args)
	{
		Student student1=new Student(151, "shubham");
		Student student2=new Student(155, "sagar");
		Student student3=new Student(184, "harish");
		Student student4=new Student(111, "tushar");
		Student student5=new Student(124, "kishor");
		Student student6=new Student(112, "pappu");
		
		SortByid byid=new SortByid();
		
		SortByName byName=new SortByName();
		
		ArrayList<Student> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(student1,student2,student3,student4,student5,student6));
		
		System.out.println("----without sort-----");
		for(Student student : list)
		{
			System.out.println("id::"+student.getId()+"::name::"+student.getName());
		}
		list.sort(byid);
		
		System.out.println("----with id sort-----");
		for(Student student : list)
		{
			System.out.println("id::"+student.getId()+"::name::"+student.getName());
		}
		
		list.sort(byName);
		
		System.out.println("----with name sort-----");
		for(Student student : list)
		{
			System.out.println("id::"+student.getId()+"::name::"+student.getName());
		}
		
		
		
		
	}

}
