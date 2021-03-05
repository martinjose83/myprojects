import java.util.Comparator;

public class ComparatorDsply implements Comparator<Thing> {

	@Override
	public int compare(Thing o1, Thing o2) {
		if((o1 instanceof Geography)&&(!(o2 instanceof Geography)) )return 1;
		if((!(o1 instanceof Geography))&&(o2 instanceof Geography) )return -1;	
		return 0;
			
		
		
	}

}
