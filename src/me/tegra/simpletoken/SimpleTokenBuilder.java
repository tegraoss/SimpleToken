package me.tegra.simpletoken;
import me.tegra.simpletoken.filter.FilterInterface;
import me.tegra.simpletoken.filter.Reverse;

public class SimpleTokenBuilder implements Cloneable {

	SimpleToken simpleToken;
	
	public SimpleTokenBuilder() {
		simpleToken = new SimpleToken();
	}
	
	public SimpleToken Build() {
		return simpleToken;
	}
	
	public SimpleTokenBuilder addReverseFilter()  {
		FilterInterface filter = new Reverse();
		SimpleTokenBuilder newBuilder;
		try {
			newBuilder = (SimpleTokenBuilder)this.clone();
		} catch (CloneNotSupportedException ex) {
			newBuilder = this;
		}
		newBuilder.simpleToken.addFilter(filter);
		return newBuilder;
	}
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
}
