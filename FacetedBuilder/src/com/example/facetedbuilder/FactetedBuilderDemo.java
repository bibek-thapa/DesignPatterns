package com.example.facetedbuilder;

class Person 
{
	// address
	  public String streetAddress, postcode, city;

	  // employment
	  public String companyName, position;
	  public int annualIncome;

	  @Override
	  public String toString()
	  {
	    return "Person{" +
	      "streetAddress='" + streetAddress + '\'' +
	      ", postcode='" + postcode + '\'' +
	      ", city='" + city + '\'' +
	      ", companyName='" + companyName + '\'' +
	      ", position='" + position + '\'' +
	      ", annualIncome=" + annualIncome +
	      '}';
	  }


}

class PersonBuilder
{
	Person person = new Person();
	
	public PersonAddressBuilder lives() 
	{
		return new PersonAddressBuilder(person);
	}
	
	public PersonJobBuilder works() 
	{
		return new PersonJobBuilder(person);
	}
	
	public Person build() 
	{
		return person;
	}
	
	


}

class PersonAddressBuilder extends PersonBuilder
{
	
	

	public PersonAddressBuilder(Person person)
	{
		this.person = person;
	}
	
	public PersonAddressBuilder at(String address) 
	{
		person.streetAddress = address;
		return this;
	}
	
	public PersonAddressBuilder withPostCode(String postcode) 
	{
		person.postcode = postcode;
		return this;
	}

	public PersonAddressBuilder atCity(String city) 
	{
		person.city = city;
		return this;
	}
}


class PersonJobBuilder extends PersonBuilder
{

	  
	  
	public PersonJobBuilder(Person person) 
	{
		this.person = person;
	}
	
	public PersonJobBuilder at(String companyName) 
	{
		person.companyName = companyName;
		return this;
	}
	
	public PersonJobBuilder asA(String position) 
	{
		person.position =  position;
		return this;
	}
	
	public PersonJobBuilder earns(int annualIncome) 
	{
		person.annualIncome = annualIncome;
		return this;
	}
	

}







public class FactetedBuilderDemo {

	public static void main(String[] args) {
		
		PersonBuilder pb = new PersonBuilder();
		Person person = 
				pb.lives().
				at("119 Texas")
				.withPostCode("44600")
				.atCity("Texas")
				.works()
				.asA("Engineer")
				.at("AMAZON")
				.earns(140000)
				.build();
		
		System.out.println(person);

	}

}
