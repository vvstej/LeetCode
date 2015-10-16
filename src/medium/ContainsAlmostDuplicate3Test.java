package medium;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class ContainsAlmostDuplicate3Test {

	@Test(expected = NoSuchFieldError.class)
	public void testContainsNearbyAlmostDuplicate_EmptyArray() {
		ContainsAlmostDuplicate3 source = new ContainsAlmostDuplicate3();
		assertFalse(source.containsNearbyAlmostDuplicate(new int[]{}, 1, 1));
		assertThat("blah", is("blah"));
		
	}
	
	@Test
	public void testMock(){
		List mockedList = mock(List.class);
		when(mockedList.get(0)).thenReturn("1");
		//assertThat(mockedList.get(0), );
		assertEquals(mockedList.get(0), "1");
		verify(mockedList).get(1);
	}

}
