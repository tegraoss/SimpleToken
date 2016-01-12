package me.tegra.simpletoken;

import java.util.ArrayList;
import java.util.List;

import me.tegra.simpletoken.filter.FilterInterface;
import me.tegra.simpletoken.filter.Reverse;

public class ReverseTokenFactory {

	public static SimpleTokenInterface create() {
		List<FilterInterface> filters = new ArrayList<FilterInterface>();
		filters.add(new Reverse());

		return new SimpleToken(filters);
	}

}
