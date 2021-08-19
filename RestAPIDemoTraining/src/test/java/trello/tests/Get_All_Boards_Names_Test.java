package trello.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import trello.common.Base;
import trello.functions.TrelloMembers;

public class Get_All_Board_Names_Test extends Base{
	
	@Test
	public void testMyBoards() {
		List<String> boardnames = TrelloMembers.getBoardNamesForThisMember();
		System.out.println(boardnames);
		Assert.assertEquals(boardnames.size(), 7);
	}
}
