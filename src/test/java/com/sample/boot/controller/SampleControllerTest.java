package com.sample.boot.controller;

import com.sample.boot.dto.GroupDTO;
import com.sample.boot.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebAppConfiguration
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

//    @Autowired
//    SampleController controller;

    @MockBean
    GroupService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mock_Test() throws Exception {
        List<GroupDTO> emptyList = new ArrayList<>();

        given(service.getGroupList(1)).willReturn(null);
        given(service.getGroupList(2)).willReturn(emptyList);

        List<GroupDTO> result = service.getGroupList(1);
        assertNull(result);

        List<GroupDTO> result2 = service.getGroupList(2);
        assertEquals(result2, emptyList);

//        List<GroupDTO> result3 = controller.hello(1);
//        assertNull(result3);
//
//        List<GroupDTO> result4 = controller.hello(2);
//        assertEquals(result4, emptyList);

        mockMvc.perform(get("/test/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());
    }
}