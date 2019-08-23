package rys.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntryList<T extends Object> {
	
	private class Entry {
		T reference;
		float count;
	}
	
	private List<Entry> entryList = new ArrayList<>();
	private float countOfAll = 0;
	private Random random = new Random();
	
	public EntryList<T> addEntry(T referenceIn, float countIn) {
		Entry entry = new Entry();
		entry.reference = referenceIn;
		entry.count = countIn;
		this.entryList.add(entry);
		this.countOfAll += countIn;
		
		return this;
	}
	
	public EntryList<T> setRandom(Random random) {
		this.random = random;
		
		return this;
	}
	
	public T getRandom() {
		float r = this.random.nextFloat() * this.countOfAll;
		
		for (Entry entry : this.entryList) {
			r -= entry.count;
			if (r <= 0) {
				return entry.reference;
			}
		}
		
		return null;
	}
	
}
