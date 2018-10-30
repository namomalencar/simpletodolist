package todolist;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import br.com.namom.todolist.controller.ListController;
import br.com.namom.todolist.persistence.ListRepository;

public class ListControllerTest {

	@Mock
	ListRepository repoList;
	
	private ListController listContr;
	
	@Mock
	Model model;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.listContr = new ListController(repoList);
	}

	@Test
	public void shouldSaveANewList() {
		// scenario
		String listName = "My New List";

		// action
		String page = listContr.save(listName, model);

		// validation
		assertTrue(page.equalsIgnoreCase("mylists"));
	}
	
	@Test
	public void shouldNotSaveANewListWhenEmptyName() {
		// scenario
		String listName = "";
		thrown.expect(Exception.class);
		thrown.expectMessage("List name cannot be empty or null");

		// action
		listContr.save(listName, model);

	}
	
	@Test
	public void shouldNotSaveANewListWhenNameIsNull() {
		// scenario
		String listName = null;
		thrown.expect(Exception.class);
		thrown.expectMessage("List name cannot be empty or null");

		// action
		listContr.save(listName, model);

	}

}
