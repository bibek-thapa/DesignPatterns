package com.example.ocp;

import java.util.List;
import java.util.stream.Stream;

/*
 * Open Closed Principle:
 * 
 * Class and method should be open for the extension but closed for the modification
 *
 * When everytime the user requests to put the new features, we should extend the 
 * class in such a way that we can fulfill the user's request by extending the class
 * but modifying the class should be big noo.
 * 
 * The way I am making everything in same file is because I have never written code
 * in such a way and I want to see how it goes. I would always prefer to make the 
 * separate classes and enum classes
 * 
 * Streams are wrappers around a data source allowing us to operate with the data and 
 * making bulk processing convenient and fast
 * 
 * A stream does not store data and is not a data structure. It never modifies the 
 * underlying data source.
 * 
 */



enum Color
{
	GREEN, BLACK,BLUE
}

enum Size
{
	SMALL,MEDIUM,LARGE,HUGE
}

class Product
{
	String name;
	Color color;
	Size size;
	
	
	public Product(String name , Color color , Size size ) 
	{
		this.name = name;
		this.color = color;
		this.size = size;
	}

}


/*
 * Class ProductFilter is the old way to filter. If the customer wants to add the other feature
 * for e.g. he wants to add the quality. Now there will be 3 for individual size,color and quality.
 * other will be size and color, size and quality, color and quality and combined of quality,size
 * and color. So the number of the methods will increase and the developer has to modify on the 
 * methods which is not good.
 * 
 * So the classes or methods should be open for the extension , not for modification is violated.
 * It is also not the good design pattern as the classes needs to be keep changing when the new 
 * feature is added.
 * 
 * 3 criteria = 7 methods so its not good design
 * 
 * 
 * */

class ProductFilter
{
	public Stream<Product> filterByColor(List<Product> products , Color color)
	{
		return products.stream().filter(p -> p.color == color);
	}
	
	public Stream<Product> filterBySize(List<Product> products , Size size)
	{
		return products.stream().filter(p -> p.size == size);
	}
	
	
	public Stream<Product> filterByColorAndSize(List<Product> products ,Size size, Color color)
	{
		return products.stream().filter(p -> p.color == color && p.size == size);
	}
	
	

}
//---------------------------------------------------------------------------------------//

interface Specification<T>
{
	boolean isSatisfied(T item);

}

interface Filter<T>
{
	Stream<T> filter(List<T> items , Specification<T> spec);
}

class ColorSpecification implements Specification<Product>
{
	private Color color;
	
	public ColorSpecification(Color color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product p) {
		return p.color == color;
	}	
}


class SizeSpecification implements Specification<Product>
{
	private Size size;
	
	 public SizeSpecification(Size size) {
		this.size = size;
	}
		
	@Override
	public boolean isSatisfied(Product p) {
	
		return p.size == size;
	}
	

}


class BetterFilter implements Filter<Product>
{

	@Override
	public Stream<Product> filter(List<Product> products, Specification<Product> spec) {
		return products.stream().filter(p -> spec.isSatisfied(p));	
	}
	


}

/*
 * And Specification is gem. It can compare any two parameters of the given type. So it can compare 
 * the size and color. If we have other object like House then we can compare the parameters of 
 * the House too. So any object can be passed besides the products and it will do fine beside the 
 * object Product. 
 * 
 * 
 * */



class AndSpecification<T> implements Specification<T>
{
	private Specification<T> first , second ;
	
	
	public AndSpecification(Specification<T> first , Specification<T> second) {
		this.first = first;
		this.second = second;
		
	}
	
	
	@Override
	public boolean isSatisfied(T item) {
		
		return first.isSatisfied(item) && second.isSatisfied(item);
	}
	



}






class OCP
{
	public static void main(String[] args) 
	{
		Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
	    Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
	    Product house = new Product("House", Color.BLUE, Size.LARGE);
	    
	    List<Product> products = List.of(apple,tree,house);
	    
	    ProductFilter pf = new ProductFilter();
	    
	    System.out.println("Finding by the Green products");
	    pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(p.name + " is green" ));
	    System.out.println("");
	    
	    System.out.println("Finding by the Green Product and Large Size");
	    pf.filterByColorAndSize(products, Size.LARGE, Color.BLUE).forEach(p -> System.out.println(p.name + " is blue and large"));
	    System.out.println("");
	    
	    
	    
	    System.out.println("Finding the green products by New way of OCP ");
	    BetterFilter bf = new BetterFilter();
	    bf.filter(products, new ColorSpecification(Color.GREEN)).forEach
	    (
	    		p->System.out.println(p.name + " is green")
	    );
	    
	    System.out.println();
	    System.out.println("Finding the green and large product by New way of OCP");
	    
	    /*
	     * New thing I learned over her is in AndSpecification . When I did not put the diamond
	     * operator than it was not working. But when I put the diamond operator  or 
	     * Product inside the diamond operator like  <Product> over there it 
	     * worked fine.
	     * 
	     * */
	    
	    bf.filter(products,new AndSpecification<>(new ColorSpecification(Color.GREEN), new SizeSpecification(Size.LARGE))).
	    forEach
	    (p->System.out.println(p.name + " is green and large"));
	    
	    
	    
	}



}


