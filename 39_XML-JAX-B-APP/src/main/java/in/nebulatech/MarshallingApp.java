package in.nebulatech;

import java.io.File;
import java.time.Period;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import in.nebulatech.bindings.Person;

public class MarshallingApp {

	public static void main(String[] args) throws Exception {
		
		Person person=new Person(101,"shubham",18,8208090110l);
		
		JAXBContext instance = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = instance.createMarshaller();
		marshaller.marshal(person, new File("Person.xml"));
		System.out.println("marshallin completed....");
	}

}
