package de.htwberlin.webtechtodoapp.web;


import de.htwberlin.webtechtodoapp.controllers.ToDoController;
import de.htwberlin.webtechtodoapp.entities.Category;
import de.htwberlin.webtechtodoapp.entities.Todo;
import de.htwberlin.webtechtodoapp.servises.ToDoService;
import de.htwberlin.webtechtodoapp.servises.ToDoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoController.class)
class ToDoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoServiceImpl toDoServiceImpl;

    @Test
    @DisplayName("should return 404 if todo is not found")
    void should_return_404_if_todo_is_not_found() throws Exception {
        // given
        doReturn(null).when(toDoServiceImpl).getTodoById(anyLong());

        // when
        mockMvc.perform(get("/api/todo/236"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should validate create todo request")
    void should_validate_create_todo_request() throws Exception {
        // given
        String toDoToCreateAsJson = "{\"title\":, \"description\":, \"category\":, \"myDay\":}";

        // when
        mockMvc.perform(
                        post("/api/todo")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(toDoToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should show 201 status, when a new todo will be created")
    void should_show_201_status_after_creating_a_new_todo() throws Exception {
        // given
        String toDoToCreateAsJson = "{\"title\": \"this is a new todo\", \"description\":  \"this is a description of todo\", \"category\": {\"categoryId\": 1, \"categoryTitle\": \"Urgent and Important\"}, \"myDay\": true}";
        Category category = new Category(1L, "Urgent and important");
        Todo todo = new Todo("this is a new todo", "this is a description of todo", category, true);
        doReturn(todo).when(toDoServiceImpl).create(any(), any(), any(), any());
        // when
        mockMvc.perform(
                        post("/api/todo")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(toDoToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated());
    }
}
