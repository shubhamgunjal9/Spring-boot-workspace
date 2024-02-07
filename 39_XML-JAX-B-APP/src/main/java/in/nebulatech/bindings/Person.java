package in.nebulatech.bindings;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private Long contact;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", contact=" + contact + "]";
	}

	public Person(Integer id, String name, Integer age, Long contact) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = contact;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
