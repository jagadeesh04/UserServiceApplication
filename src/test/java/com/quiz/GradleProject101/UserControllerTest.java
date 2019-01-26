package com.quiz.GradleProject101;


import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private MockMvc mvc;

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
        List<User> userList = new ArrayList();
        userList.add(new User(1, "apple", "apple@apple.com"));
        userList.add(new User(2, "banana", "banana@banana.com"));
        Mockito.when(userService.getAllUsers()).thenReturn(userList);

    }

    @Test
    public void testGetAllUsers() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/user/getAllUsers")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }



    @Test
    public void testPutUsersToUpdateUser1() throws Exception
    {
        Mockito.when(userService.updateUser(any(User.class))).thenReturn(new User(1, "cat", "cat@cat.com"));
        String user = "{\"id\":1,\"userName\":\"cat\",\"email\":\"cat@cat.com\"}";
        MvcResult newValue = mvc.perform(MockMvcRequestBuilders
                .put("/user/{userId}", 1)
                .content(new Gson().toJson(new User(1, "cat", "cat@cat.com")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        Assert.assertEquals(user, newValue.getResponse().getContentAsString());
    }

    @Test
    public void testPutUserForInvalidUserName() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                .put("/user/{userId}", 1)
                .content(new Gson().toJson(new User(1, "", "cat@cat.com")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testPutUserForInvalidEmailId() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                .put("/user/{userId}", 1)
                .content(new Gson().toJson(new User(1, "cat", "cat.com")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testPutUserForNullInputs() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                .put("/user/{userId}", 1)
                .content(new Gson().toJson(new User(1, null, null)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
