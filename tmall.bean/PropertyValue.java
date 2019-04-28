/* @ By: Bo Fan  
 * Date: 04/25/2019
 * MockTmall Project
 * PropertyValue Class
 * */
package tmall.bean;

public class PropertyValue {
	
	private String value;
	private Product product;
	private Property property;
	private int id;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	

}
