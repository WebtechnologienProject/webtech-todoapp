package de.htwberlin.webtechtodoapp.service;
import de.htwberlin.webtechtodoapp.repos.ToDoRepository;
import de.htwberlin.webtechtodoapp.servises.ToDoService;
import de.htwberlin.webtechtodoapp.servises.ToDoServiceImpl;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest implements WithAssertions {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoServiceImpl toDoServiceImpl;

    @Test
    @DisplayName("Must return true, if delete was successful")
    void mustReturnTrueIfDeleteWasSuccessful() {
        // given
        Long givenId = 111L;
        doReturn(true).when(toDoRepository).existsById(givenId);

        // when
        boolean result = toDoServiceImpl.deleteById(givenId);

        // then
        verify(toDoRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Must return true, if todoId for delete doesn't exist")
    void should_return_false_if_todo_to_delete_does_not_exist() {
        // given
        Long givenId = 111L;
        doReturn(false).when(toDoRepository).existsById(givenId);

        // when
        boolean result = toDoServiceImpl.deleteById(givenId);

        // then
        verifyNoMoreInteractions(toDoRepository);
        assertThat(result).isFalse();
    }
}
