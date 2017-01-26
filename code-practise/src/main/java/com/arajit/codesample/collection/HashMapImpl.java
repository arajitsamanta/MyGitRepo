package com.arajit.codesample.collection;

public class HashMapImpl<K,V>
{
	private double loadFactor = 0.75;

	private Entry[] table;

	private int elemCount=15;
	
	HashMapImpl(){
		table=new Entry[elemCount];
        for (int i = 0; i < elemCount; i++)
            table[i] = null;
	}

	public  class Entry<K,V>
	{
		K key;
		V value;
		Entry<K,V> next;
		
		Entry(K key,V value){
			this.key=key;
			this.value=value;
		}		
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public Entry<K, V> getNext() {
			return next;
		}
		public void setNext(Entry<K, V> next) {
			this.next = next;
		}	
	}

	/**
	 * Insert your super-mega-hash-function below :)
	 */
	static int hash(int h)
	{
	    h ^= (h >>> 20) ^ (h >>> 12);
	    return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public void put(K key, V value) {
		System.out.println("elemCount & table length:"+elemCount + " : "+ (table.length*loadFactor));
		if (elemCount > table.length * loadFactor)
			resize();
		int index = hash(key.hashCode()) % table.length;
		if (table[index] == null)
			table[index] = new Entry<K, V>(key, value);
		else {
			Entry<K, V> cur = table[index];
			/*while (true) {
				if (cur.getKey().equals(key)) {
					cur.setValue(value);
					break;
				}
				if (cur.getNext() == null)
					break;
				cur = cur.getNext();
			}
			cur.setNext(new Entry<K, V>(key, value));
			*/
            while (cur.next != null && !cur.key.equals(key))
            	cur = cur.next;
            if (cur.key.equals(key))
            	cur.value = value;
            else
            	cur.next = new Entry(key, value);
			
		}
	}

	public V get(K key) {
		int index = hash(key.hashCode()) % table.length;
		if (table[index] == null)
			return null;
		else {
			Entry cur = table[index];
			while (true) {
				if (cur.getKey().equals(key)) {
					return (V) cur.getValue();
				}
				if (cur.getNext() == null)
					break;
				cur = cur.getNext();
			}
			return null;
		}
	}

	public void resize() {
		int newSize = (int) ((int)table.length * 1.5);
		Entry[] newTable = new Entry[newSize];
		for (int i = 0; i < table.length; i++)
			newTable[i] = table[i];
		table = newTable;
	}
	
    public void printMap()
    {
        for (int i = 0; i < elemCount; i++)
        {
            System.out.print("\nBucket "+ (i + 1) +" : ");
            Entry entry = table[i];
            while (entry != null)
            {
                System.out.print(entry.value +" ");
                entry = entry.next;
            }         
        }

    }



	public static void main(String[] args){{
		HashMapImpl<Integer,String> hashMap=new HashMapImpl<Integer,String>();
		hashMap.put(1, "arajit");
		hashMap.put(2, "samanta");
		hashMap.put(3, "bekar");
		hashMap.put(1, "arajit1");
		System.out.println(hashMap.get(1));
		
		hashMap.printMap();
	}
		
	}

}
