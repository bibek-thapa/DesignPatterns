package com.example.recursivegenerics;

class Person 
{
	String name;
	String position;
	@Override
	public String toString() {
		return "Person [name=" + name + ", position=" + position + "]";
	}
}


class PersonBuilder<SELF extends PersonBuilder<SELF>>
{
	
	Person person = new Person();
	
	public SELF withName(String name) 
	{
		person.name = name;
		return self();
	}
	
	public Person build() 
	{
		return person;
	}
	
	public SELF self() 
	{
		return (SELF)this ;
	}

}


class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>
{
	public EmployeeBuilder withPosition(String position) 
	{
		person.position = position;
		return self();
	}

	@Override
	public EmployeeBuilder self() {
		return this;
	}
	
	


}



public class RecursiveGenerics {

	public static void main(String[] args)
	{
		EmployeeBuilder eb = new EmployeeBuilder();
		Person bibek = eb.withName("Bibek").withPosition("admin").build();
		System.out.println(bibek);

	}

}
