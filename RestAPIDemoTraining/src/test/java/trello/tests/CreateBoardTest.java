package trello.tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import trello.functions.CreateBoard;

public class CreateBoardTest {

	
	@Test
	public void testCreateBoard(){
		int statusCode=CreateBoard.createNewBoard("Board_JPMC_1");
		Assert.assertEquals(statusCode, 200);
	}
}
